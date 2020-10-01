import java.awt.Color;


import elements.AmbientLight;
import elements.Camera;
import elements.PointLight;
import elements.SpotLight;
import geometries.Sphere;
import geometries.Triangle;
import org.junit.jupiter.api.Test;
import primitives.Coordinate;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class ShadowTester {

    private final String IMAGES_TEST_DIR = "src/test/images";

    @Test
    public void testShadow() {

        ImageWriter imageWriter = new ImageWriter("\\" + IMAGES_TEST_DIR + "\\" + "Shadow Test", 500, 500, 500, 500);

        Scene scene = new Scene("shadow test");
        scene.setScreenDistance(200);
        scene.setAmbientLight(new AmbientLight());
        scene.setBackground(Color.black);
        scene.setCamera(new Camera(Point3D.ZERO, new Vector(0.0, 1.0, 0.0), new Vector(0.0, 0.0, -1.0)));

        Sphere sphere = new Sphere(500, new Point3D(0, 0, -1000));
        sphere.setEmmission(new Color(0, 0, 100));

        Material m = new Material(1, 0.9, 1000, 0, 0);
        m.setnShininess(20);
        sphere.setMaterial(m);
        scene.addGeometry(sphere);

        Triangle triangle = new Triangle(new Point3D(-125, -225, -260),
                new Point3D(-225, -125, -260),
                new Point3D(-225, -225, -270)
        );
        triangle.setEmmission(new Color(0, 0, 100));

        Material m1 = new Material();
        m1.setnShininess(4);
        triangle.setMaterial(m);
        scene.addGeometry(triangle);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),
                0.1, 0.00001, 0.000005, new Vector(2, 2, -3)));


        Render render = new Render(imageWriter, scene);

        render.renderImage();
    }
}
