package renderer;

import elements.AmbientLight;
import elements.Camera;
import elements.PointLight;
import geometries.Geometry;
import geometries.Sphere;
import geometries.Triangle;
import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Vector;
import scene.Scene;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RenderTest {

    private final String IMAGES_TEST_DIR = "src/test/images";

    @Test
    void renderImage() {
        ImageWriter imageWriter = new ImageWriter("\\" + IMAGES_TEST_DIR + "\\" + "test image6", 500, 500, 500, 500);

        Scene scene = new Scene("first scene");
        scene.setAmbientLight(new AmbientLight(Color.black, 1));
        scene.setBackground(Color.BLUE);
        scene.setCamera(new Camera(Point3D.ZERO, new Vector(0.0, 1.0, 0.0), new Vector(0.0, 0.0, -1.0)));
        scene.setScreenDistance(24);

        List<Geometry> geometries = new ArrayList<Geometry>();
        Sphere sphere = new Sphere(48, new Point3D(0, 0, -50));
        sphere.setEmmission(Color.CYAN);
        geometries.add(sphere);
        Triangle triangle1 = new Triangle(new Point3D(500, 0, -49), new Point3D(0, 500, -49), new Point3D(500, 500, -49));
        triangle1.setEmmission(Color.green);
        geometries.add(triangle1);
        Triangle triangle2 = new Triangle(new Point3D(500, 0, -49), new Point3D(0, -500, -49), new Point3D(500, -500, -49));
        triangle2.setEmmission(Color.yellow);
        geometries.add(triangle2);
        Triangle triangle3 = new Triangle(new Point3D(-500, 0, -49), new Point3D(0, 500, -49), new Point3D(-500, 500, -49));
        triangle3.setEmmission(Color.red);
        geometries.add(triangle3);
        Triangle triangle4 = new Triangle(new Point3D(-500, 0, -49), new Point3D(0, -500, -49), new Point3D(-500, -500, -49));
        triangle4.setEmmission(Color.magenta);
        geometries.add(triangle4);

        scene.setGeometries(geometries);

        Render render = new Render(imageWriter, scene);
        render.renderImage();
    }
}