package scene;

import elements.AmbientLight;
import elements.Camera;
import elements.Light;
import geometries.Geometry;
import primitives.Point3D;
import primitives.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Holds all the scene's data: name, camera, lights and geometries.
 */

public class Scene {
    private String sceneName;
    private Color background;
    private AmbientLight ambientLight;
    private List<Light> lights = new ArrayList<Light>();
    private List<Geometry> geometries = new ArrayList<Geometry>();
    private Camera camera;
    private double screenDistance;

    /**
     * Default constructor. sets the screen distance to 200, ambient light to new AmbientLight, background to black, and a camera.
     */
    public Scene(){
        setSceneName("scene");
        setScreenDistance(200);
        setAmbientLight(new AmbientLight());
        setBackground(Color.black);
        setCamera(new Camera(Point3D.ZERO, new Vector(0.0, 1.0, 0.0), new Vector(0.0, 0.0, -1.0)));
    }

    /**
     * Constructor like the default, but with scene name.
     * @param sceneName a scene name for the scene
     */
    public Scene(String sceneName){
        setSceneName(sceneName);
        setScreenDistance(200);
        setAmbientLight(new AmbientLight());
        setBackground(Color.black);
        setCamera(new Camera(Point3D.ZERO, new Vector(0.0, 1.0, 0.0), new Vector(0.0, 0.0, -1.0)));
    }

    /**
     * Copy constructor.
     * @param scene the scene to copy from.
     */
    public Scene(Scene scene){
        setSceneName(scene.getSceneName());
        setBackground(scene.getBackground());
        setAmbientLight(scene.getAmbientLight());
        setLights(scene.getLights());
        setGeometries(scene.getGeometries());
        setCamera(scene.getCamera());
        setScreenDistance(scene.getScreenDistance());
    }

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }
    public Color getBackground() {
        return background;
    }

    public void setBackground(Color background) {
        this.background = background;
    }

    public AmbientLight getAmbientLight() {
        return ambientLight;
    }

    public void setAmbientLight(AmbientLight ambientLight) {
        this.ambientLight = ambientLight;
    }

    public List<Light> getLights() {
        return lights;
    }

    public void setLights(List<Light> lights) {
        this.lights = lights;
    }

    public List<Geometry> getGeometries() {
        return geometries;
    }

    public void setGeometries(List<Geometry> geometries) {
        this.geometries = geometries;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public double getScreenDistance() {
        return screenDistance;
    }

    public void setScreenDistance(double screenDistance) {
        this.screenDistance = screenDistance;
    }

    /**
     * Add a new geometry to the scene's geometries.
     * @param geometry a new geometry to be added.
     */
    public void addGeometry(Geometry geometry){
        geometries.add(geometry);
    }

    /**
     * Get an iterator for the geometries list.
     * @return iterator for the geometries list.
     */
    public Iterator<Geometry> getGeometriesIterator(){
        return geometries.iterator();
    }

    /**
     * Add a new light to the scene's lights.
     * @param light a new light to be added.
     */
    public void addLight(Light light){
        lights.add(light);
    }

    /**
     * Get an iterator for the lights list.
     * @return iterator for the lights list.
     */
    public Iterator<Light> getLightsIterator(){
        return lights.iterator();
    }
}
