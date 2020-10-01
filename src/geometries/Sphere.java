package geometries;

import primitives.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A 3D sphere, defined by radius and center point.
 */

public class Sphere extends RadialGeometry {

    Point3D center;

    /**
     * Constructor with radius and center.
     * @param radius radius for the sphere.
     * @param center center point for the sphere.
     */
    public Sphere(double radius, Point3D center) {
        super(radius);
        this.center = center;
    }

    public Point3D getCenter() {
        return center;
    }

    /**
     * Get normal to the sphere in a specific point.
     * @param p the point for the normal.
     * @return normal to the sphere in the point.
     */
    public Vector getNormal(Point3D p) {
        Vector n = p.subtract(getCenter()); // we find the vector from the center to the point on the sphere surface.
        n = n.normalize(); // normalize it
        return n; // return it.
    }

    /**
     * Find intersections between sphere and a ray.
     * @param ray the ray we intersect the sphere.
     * @return list with intersections points.
     */
    @Override
    public List<Point3D> findIntersections(Ray ray) {
        List<Point3D> intersections = new ArrayList<Point3D>();
        Vector L = getCenter().subtract(ray.getP0());
        double Tm = L.dotProduct(ray.getDirection().normalize());
        double d = Math.sqrt(L.length() * L.length() - Tm * Tm); // finding using Pythagorean theorem
        if (d > getRadius()) // there is no intersection point.
            return intersections;
        double Th = Math.sqrt(getRadius() * getRadius() - d * d); // finding using Pythagorean theorem
        double T1 = Tm - Th; // entry intersection
        double T2 = Tm + Th; // out intersection
        if (T1 > 0)
            intersections.add(new Point3D(ray.getP0().addVector(ray.getDirection().normalize().scale(T1))));
        if (T2 > 0)
            intersections.add(new Point3D(ray.getP0().addVector(ray.getDirection().normalize().scale(T2))));
        return intersections;
    }
}
