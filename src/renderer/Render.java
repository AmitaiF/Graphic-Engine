package renderer;

import elements.Light;
import geometries.FlatGeometry;
import geometries.Geometry;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import scene.Scene;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Map.Entry;

/**
 * Rendering the scene, using an ImageWriter.
 */

public class Render {

    private static final int RECURSION_LEVEL = 3; // calc color only to the 3th level
    private final boolean SUPER_SAMPLING = false;

    private ImageWriter imageWriter; // the image writer that we use for writing the image.
    private Scene scene; // the scene we are rendering.

    /**
     * Constructor with ImageWriter and Scene.
     *
     * @param imageWriter the image writer we will use.
     * @param scene       the scene we will use.
     */
    public Render(ImageWriter imageWriter, Scene scene) {
        this.setImageWriter(imageWriter);
        this.setScene(scene);
    }

    public ImageWriter getImageWriter() {
        return imageWriter;
    }

    public void setImageWriter(ImageWriter imageWriter) {
        this.imageWriter = new ImageWriter(imageWriter);
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = new Scene(scene);
    }

    // the render engine

    /**
     * The actual rendering engine. calculating the color of each pixel, and writing it to an image file.
     */
    public void renderImage() {

        List<Ray> rays = new ArrayList<Ray>(); // array for the super-sampling rays.
        List<Color> colors = new ArrayList<Color>(); // colors for each ray of the rays.
        Color weightedColor = Color.black;

        double Rx = getImageWriter().getWidth() / getImageWriter().getNx(); // size of pixel x
        double Ry = getImageWriter().getWidth() / getImageWriter().getNy(); // size of pixel y

        for (int i = 0; i < getImageWriter().getHeight(); i++) { // iterate x pixels
            for (int j = 0; j < getImageWriter().getWidth(); j++) { // iterate y pixels
                if (SUPER_SAMPLING) { // if super sampling is on
                    for (double k = (-1.0 / 3); k < (2.0 / 3); k += (1.0 / 3)) { // super-sampling (9 rays instead 1)
                        for (double l = (-1.0 / 3); l < (2.0 / 3); l += (1.0 / 3)) {
                            Ray ray = new Ray(getScene().getCamera().constructRayThroughPixel(getImageWriter().getNx(), getImageWriter().getNy(),
                                    i + Rx * k, j + Ry * l, getScene().getScreenDistance(), getImageWriter().getWidth(), getImageWriter().getHeight()));
                            rays.add(ray); // add the ray to a list for calculating the colors
                        }
                    }
                    colors = getColorsFromRays(rays); // calculate the colors from the rays
                    rays.clear(); // clear for next pixel
                    weightedColor = mixColor(colors);
                    colors.clear(); // clear for next pixel

                } else { // super sampling is off
                    // construct ray through the pixel
                    Ray ray = new Ray(getScene().getCamera().constructRayThroughPixel(getImageWriter().getNx(), getImageWriter().getNy(),
                            i, j, getScene().getScreenDistance(), getImageWriter().getWidth(), getImageWriter().getHeight()));
                    // find the ray intersections
                    Map.Entry<Geometry, Point3D> entry = findClosestIntersection(ray);
                    if (entry == null) // there are no intersections
                        weightedColor = getScene().getBackground(); // background color
                    else // there are intersections
                        weightedColor = calcColor(entry.getKey(), entry.getValue(), ray); // calc color and write it
                }
                getImageWriter().writePixel(i, j, weightedColor); // write the color to the pixel
            }
        }
        imageWriter.writeToimage(); // write the final image
    }

    /**
     * Calculate an average color from 9 colors.
     *
     * @param colors list of colors to be mixed.
     * @return a new average color.
     */
    private Color mixColor(List<Color> colors) {

        int r = 0, g = 0, b = 0; // initial value for the color components.

        for (Color color : colors) { // for each color, add color components to r, g, b.
            r += color.getRed(); // sum of red component
            g += color.getGreen(); // sum of green component
            b += color.getBlue(); // sum of blue component
        }
        r /= 9; // get average red component.
        g /= 9; // get average green component.
        b /= 9; // get average blue component.

        Color color = new Color(r, g, b); // create new average color
        return color; // return average color.
    }

    /**
     * Calculate color for each ray in rays.
     *
     * @param rays rays we want to get colors from.
     * @return list of colors from the rays.
     */
    private List<Color> getColorsFromRays(List<Ray> rays) {
        List<Color> colors = new ArrayList<Color>(); // list for the colors
        for (Ray ray : rays) { // for each ray find its pixel's color and add it to the list.
            Map.Entry<Geometry, Point3D> entry = findClosestIntersection(ray); // find the intersection
            if (entry == null) // ray doesn't intersect
                colors.add(getScene().getBackground()); // blank pixel - background
            else
                colors.add(calcColor(entry.getKey(), entry.getValue(), ray)); // calc the intersection color and add it.
        }
        return colors; // return colors list.
    }

    // return entry of intersections point

    /**
     * Find all the intersection the ray has, and return the closest.
     *
     * @param ray a ray for intersections.
     * @return entry of geometries and their intersections point.
     */
    private Map.Entry<Geometry, Point3D> findClosestIntersection(Ray ray) {

        Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(ray); // get all the intersections of a ray

        if (intersectionPoints.size() == 0) // no intersections
            return null;

        Map<Geometry, Point3D> closestPoint = getClosestPoint(intersectionPoints); // get the closest point from the points
        Entry<Geometry, Point3D> entry = closestPoint.entrySet().iterator().next(); // get entry iterator
        return entry; // return it

    }

    /**
     * Get all the intersections a ray has in the scene.
     *
     * @param ray the ray to intersect the geometries.
     * @return map of geometries and their intersections points.
     */
    private Map<Geometry, List<Point3D>> getSceneRayIntersections(Ray ray) {

        Iterator<Geometry> geometries = getScene().getGeometriesIterator(); // iterator for the geometries.

        Map<Geometry, List<Point3D>> intersectionPoints = new HashMap<Geometry, List<Point3D>>(); // map for the geometries and their intersections points.

        // check for each geometry if there is an intersections points
        while (geometries.hasNext()) {
            Geometry geometry = geometries.next(); // get the geometry
            List<Point3D> geometryIntersectionPoints = geometry.findIntersections(ray); // find its intersections
            if (!geometryIntersectionPoints.isEmpty()) // if there is intersections
                intersectionPoints.put(geometry, geometryIntersectionPoints); // add it to the map
        }
        return intersectionPoints; // return the map
    }

    /**
     * Get the closest point from several points.
     *
     * @param intersectionPoints list of all the intersections of a ray.
     * @return the closest intersection point, and its geometry.
     */
    private Map<Geometry, Point3D> getClosestPoint(Map<Geometry, List<Point3D>> intersectionPoints) {

        double distance = Double.MAX_VALUE; // the biggest distance
        Point3D position = getScene().getCamera().getPosition(); // position of the camera
        Map<Geometry, Point3D> minDistancePoint = new HashMap<Geometry, Point3D>(); // map for the closest intersection point and its geometry.

        // if distance<minDistane - the point is closer
        for (Entry<Geometry, List<Point3D>> entry : intersectionPoints.entrySet()) {
            for (Point3D point : entry.getValue()) {
                double pointDistance = position.distance(point); // find the distance between the points.
                if (pointDistance < distance) { // the current point is closer than the current closest point
                    minDistancePoint.clear(); // erase the current closest point
                    minDistancePoint.put(entry.getKey(), new Point3D(point)); // put the new closest point
                    distance = pointDistance; // set the new distance
                }
            }
        }
        return minDistancePoint; // return the closest point and its geometry.
    }

    /**
     * Call the calcColor with level 0.
     *
     * @param geometry the intersection geometry.
     * @param point    the intersection point.
     * @param inRay    the intersection ray.
     * @return the color of the intersection point.
     */
    private Color calcColor(Geometry geometry, Point3D point, Ray inRay) {
        return calcColor(geometry, point, inRay, 0);
    }

    // calculate the color from a ray

    /**
     * Calculate the color of an intersection point.
     *
     * @param geometry the intersection geometry.
     * @param point    the intersection point.
     * @param inRay    the intersection ray.
     * @param level    the level of the reflection and refraction recursion.
     * @return the color of the intersection point.
     */
    private Color calcColor(Geometry geometry, Point3D point, Ray inRay, int level) {

        if (level == RECURSION_LEVEL) return new Color(0, 0, 0); // return blank color

        Color ambientColor = getScene().getAmbientLight().getIntensity(point); // the ambient component.
        Color emmissionColor = geometry.getEmmission(); // the emmission component

        Color result = addColor(ambientColor, emmissionColor); // add them together

        Color diffuseColor = Color.black; //initial value
        Color specularColor = Color.black; //initial value

        Iterator<Light> lights = getScene().getLightsIterator(); // iterator for the light sources in the scene

        // check for each light source
        while (lights.hasNext()) {
            Light light = lights.next();
            double k = occluded(light, point, geometry); // get the occluded level
            if (k != 0) { // if not occluded
                // calc the diffuse component and add it to diffuse.
                diffuseColor = addColor(diffuseColor, calcDiffusiveComp(geometry.getMaterial().get_Kd(), geometry.getNormal(point), light.getL(point), light.getIntensity(point)));
                // calc the specular component and add it to specular.
                specularColor = addColor(specularColor, calcSpecularComp(geometry.getMaterial().get_Ks(), new Vector(getScene().getCamera().getPosition().subtract(point)), geometry.getNormal(point), light.getL(point), geometry.getShininess(), light.getIntensity(point)));
            }
            // multiply the diffuse with occluded level
            diffuseColor = new Color((int) (diffuseColor.getRed() * k), (int) (diffuseColor.getGreen() * k), (int) (diffuseColor.getBlue() * k));
            // multiply the specular with occluded level
            specularColor = new Color((int) (specularColor.getRed() * k), (int) (specularColor.getGreen() * k), (int) (specularColor.getBlue() * k));
        }

        Color reflectedColor = Color.black; //initial value
        Color refractedColor = Color.black; //initial value

        double Kr = geometry.getMaterial().get_Kr(); // get reflected factor
        if (Kr != 0) { // if Kr=0 - don't need to calculate the color
            Ray reflectedRay = constructReflectedRay(geometry, point, inRay); // construct reflected ray
            Map.Entry<Geometry, Point3D> reflectedEntry = findClosestIntersection(reflectedRay); // find intersections for the reflected ray
            if (reflectedEntry != null) { // there are intersections
                //calc color for the reflected ray, increase the recursion level
                reflectedColor = calcColor(reflectedEntry.getKey(), reflectedEntry.getValue(), reflectedRay, level + 1);
                // multiply the reflected component with the reflected factor
                reflectedColor = new Color((int) (reflectedColor.getRed() * Kr), (int) (reflectedColor.getGreen() * Kr), (int) (reflectedColor.getBlue() * Kr));
            }
        }
        double Kt = geometry.getMaterial().get_Kt(); // get refracted factor
        if (Kt != 0) { // if Kt=0 - don't need to calculate the color
            Ray refractedRay = constructRefractedRay(geometry, point, inRay); // construct refracted ray
            Map.Entry<Geometry, Point3D> refractedEntry = findClosestIntersection(refractedRay); // find intersections for the refracted ray
            if (refractedEntry != null) { // there are intersections
                //calc color for the refracted ray, increase the recursion level
                refractedColor = calcColor(refractedEntry.getKey(), refractedEntry.getValue(), refractedRay, level + 1);
                // multiply the refracted component with the refracted factor
                refractedColor = new Color((int) (refractedColor.getRed() * Kt), (int) (refractedColor.getGreen() * Kt), (int) (refractedColor.getBlue() * Kt));
            }
        }
        // add all the colors together
        result = addColor(addColor(result, addColor(diffuseColor, specularColor)), addColor(reflectedColor, refractedColor));
        return result; // return result color.
    }

    /**
     * Construct reflected ray to geometry, in a specific point.
     *
     * @param geometry the geometry we reflect from.
     * @param point    the point we reflect from.
     * @param inRay    the ray we want to reflect.
     * @return reflected ray.
     */
    private Ray constructReflectedRay(Geometry geometry, Point3D point, Ray inRay) {

        Vector normal = geometry.getNormal(point); // get the normal to the point

        // constructing using the formula: R = D - 2(D・N)N

        normal = normal.scale(-2 * inRay.getDirection().dotProduct(normal));

        normal.add(inRay.getDirection());

        Ray res = new Ray(point.addVector(new Vector(normal).scale(0.3)), new Vector(normal)); // add an epsilon to the result

        return res; // return the reflected ray
    }

    /**
     * Construct refracted ray from specific point on geometry.
     *
     * @param point the point we refract from.
     * @param inRay the ray we want to refract.
     * @return refracted ray.
     */
    private Ray constructRefractedRay(Geometry g, Point3D point, Ray inRay) {

        // refracted ray, is the inRay, with an epsilon at p0.
        // add epsilon:
        Ray reflectedRay = new Ray(point.addVector(inRay.getDirection().scale(0.3)), new Vector(inRay.getDirection()));

        return reflectedRay; // return refracted ray
    }

    /**
     * Calculate diffuse component.
     *
     * @param kd             diffuse factor.
     * @param normal         normal at the point.
     * @param l              vector from the light source.
     * @param lightIntensity color at the point.
     * @return color of diffuse component.
     */
    private Color calcDiffusiveComp(double kd, Vector normal, Vector l, Color lightIntensity) {

        // the calculating is by the formula: Kd(N・L)I

        normal = normal.normalize(); // normalize the normal
        l = l.normalize(); // normalize the vector from the light

        double k = Math.abs(kd * normal.dotProduct(l)); // dot product between normal and l, multiply Kd

        // return new color of the color at the point multiply k
        return new Color((int) (lightIntensity.getRed() * k),
                (int) (lightIntensity.getGreen() * k),
                (int) (lightIntensity.getBlue() * k));
    }

    //calculate the  component by the formula

    /**
     * Calculate specular component.
     *
     * @param ks             specular factor.
     * @param v              vector from camera to point.
     * @param normal         normal to the geometry at the point.
     * @param l              vector from light source to point.
     * @param shininess      indicates how shiny the material.
     * @param lightIntensity color at the point.
     * @return color of specular component.
     */
    private Color calcSpecularComp(double ks, Vector v, Vector normal, Vector l, double shininess, Color lightIntensity) {

        //calculating by formula: Ks((V・R)^n)I

        v = v.normalize(); // normalize v
        normal = normal.normalize(); // normalize normal
        l = l.normalize(); // normalize l

        // constructing R, by formula: R = D - 2(D・N)N
        normal = normal.scale(-2 * l.dotProduct(normal)); // normal = -2(l・N)N
        l.add(normal); // l + normal
        Vector R = new Vector(l); // new vector
        R = R.normalize(); // normalize R

        double k = 0; // initial value

        if (v.dotProduct(R) > 0) // only if view vector and the specular vector is the same direction
            k = ks * Math.pow(v.dotProduct(R), shininess); // k = Ks((V・R)^n)
        if (k > 1) k = 1; // in case Ks > 1

        // return k*I
        return new Color((int) (lightIntensity.getRed() * k),
                (int) (lightIntensity.getGreen() * k),
                (int) (lightIntensity.getBlue() * k));
    }

    //combine to colors

    /**
     * Combine two colors into one color.
     *
     * @param color1 first color to combine.
     * @param color2 second color to combine.
     * @return combined color.
     */
    public Color addColor(Color color1, Color color2) {

        int r = color1.getRed() + color2.getRed(); // add red components
        if (r > 255) r = 255; // if higher than max value

        int g = color1.getGreen() + color2.getGreen(); // add green components
        if (g > 255) g = 255; // if higher than max value

        int b = color1.getBlue() + color2.getBlue(); // add blue components
        if (b > 255) b = 255; // if higher than max value

        return new Color(r, g, b); // return new color with the combined components.
    }

    //check if the point in the light

    /**
     * Return occluded level.
     *
     * @param light    the light to check occluded level.
     * @param point    the point to check occluded level.
     * @param geometry the geometry of the point.
     * @return occluded level.
     */
    private double occluded(Light light, Point3D point, Geometry geometry) {

        double result = 1; // initial value of occluded value

        Vector lightDirection = light.getL(point); // get vector from light to point
        lightDirection = lightDirection.scale(-1); // reverse the vector

        Point3D geometryPoint = new Point3D(point); // new point, for avoiding changes in the real point
        Vector epsVector = new Vector(geometry.getNormal(point)); // epsilon for avoiding self intersect
        epsVector = epsVector.scale(2); // epsilon size = 2

        geometryPoint = geometryPoint.addVector(epsVector); // adding epsilon for avoiding self intersect
        Ray lightRay = new Ray(geometryPoint, lightDirection); // construct ray from point (+ epsilon) toward to the light source
        Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(lightRay); // find intersections of the ray

        if (geometry instanceof FlatGeometry) { // flat geometries has self-intersect
            intersectionPoints.remove(geometry);
        }

        // for each geometry from the intersections point
        for (Entry<Geometry, List<Point3D>> entry : intersectionPoints.entrySet())
            result *= entry.getKey().getMaterial().get_Kt(); // multiply result with the transparency factor
        return result; // return occluded level

    }
}