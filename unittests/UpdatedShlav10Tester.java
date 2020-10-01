import java.awt.Color;

import elements.AmbientLight;
import elements.Camera;

import elements.SpotLight;
import geometries.Sphere;
import geometries.Triangle;
import org.junit.jupiter.api.Test;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class UpdatedShlav10Tester {

    private final String IMAGES_TEST_DIR = "src/test/images";

    @Test
    public void recursiveTest1() {

        ImageWriter imageWriter = new ImageWriter("\\" + IMAGES_TEST_DIR + "\\" + "Recursive Test 1", 500, 500, 500, 500);

        Scene scene = new Scene("Recursive scene 1");
        scene.setScreenDistance(200);
        scene.setAmbientLight(new AmbientLight());
        scene.setBackground(Color.black);
        scene.setCamera(new Camera(Point3D.ZERO, new Vector(0.0, 1.0, 0.0), new Vector(0.0, 0.0, -1.0)));

        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.setEmmission(new Color(0, 0, 100));
        Material m = new Material(0.7, 0.5, 200, 0, 0.5);
        sphere.setMaterial(new Material(m));
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(250, new Point3D(0.0, 0.0, -1000));
        sphere2.setEmmission(new Color(100, 20, 20));
        m.setKt(0);
        sphere2.setMaterial(new Material(m));
        scene.addGeometry(sphere2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),
                0.1, 0.00001, 0.000005, new Vector(2, 2, -3))); // NOW

        Render render = new Render(imageWriter, scene);

        render.renderImage();

    }


    @Test
    public void recursiveTest2() {

        ImageWriter imageWriter = new ImageWriter("\\" + IMAGES_TEST_DIR + "\\" + "Recursive Test 2", 500, 500, 500, 500);

        Scene scene = new Scene("Recursive scene 2");
        scene.setScreenDistance(200);
        scene.setAmbientLight(new AmbientLight());
        scene.setBackground(Color.black);
        scene.setCamera(new Camera(Point3D.ZERO, new Vector(0.0, 1.0, 0.0), new Vector(0.0, 0.0, -1.0)));

        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.setEmmission(Color.RED);
        Material material = new Material(0.3, 0.6, 20, 0, 0.5);
        sphere.setMaterial(new Material(material));
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(250, new Point3D(0.0, 0.0, -1000));
        sphere2.setEmmission(Color.BLUE);
        material.setKt(0);
        sphere2.setMaterial(new Material(material));
        scene.addGeometry(sphere2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),
                0.1, 0.00001, 0.000005, new Vector(2, 2, -3)));

        Render render = new Render(imageWriter, scene);

        render.renderImage();
    }


    @Test
    public void recursiveTest3() {

        ImageWriter imageWriter = new ImageWriter("\\" + IMAGES_TEST_DIR + "\\" + "Recursive Test 3", 500, 500, 500, 500);

        Scene scene = new Scene("Recursive scene 3");
        scene.setScreenDistance(200);
        scene.setAmbientLight(new AmbientLight());
        scene.setBackground(Color.black);
        scene.setCamera(new Camera(Point3D.ZERO, new Vector(0.0, 1.0, 0.0), new Vector(0.0, 0.0, -1.0)));

        Sphere sphere = new Sphere(300, new Point3D(-550, -500, -1000));
        sphere.setEmmission(new Color(0, 0, 100));
        Material material = new Material();
        material.setnShininess(20);
        material.setKt(0.5);
        sphere.setMaterial(new Material(material));
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(150, new Point3D(-550, -500, -1000));
        sphere2.setEmmission(new Color(100, 20, 20));
        Material material2 = new Material();
        material2.setnShininess(20);
        material2.setKt(0);
        sphere2.setMaterial(new Material(material2));
        scene.addGeometry(sphere2);

        Triangle triangle = new Triangle(new Point3D(1500, -1500, -1500),
                new Point3D(-1500, 1500, -1500),
                new Point3D(200, 200, -375));
        triangle.setEmmission(new Color(20, 20, 20));

        Triangle triangle2 = new Triangle(new Point3D(1500, -1500, -1500),
                new Point3D(-1500, 1500, -1500),
                new Point3D(-1500, -1500, -1500));
        triangle2.setEmmission(new Color(20, 20, 20));


        Material material3 = new Material();
        material3.setKr(1);
        triangle.setMaterial(new Material(material3));

        Material material4 = new Material();
        material4.setKr(0.5);
        triangle2.setMaterial(new Material(material4));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);


        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -150),
                0.1, 0.00001, 0.000005, new Vector(-2, -2, -3)));

        Render render = new Render(imageWriter, scene);
        render.renderImage();
    }

    @Test
    public void recursiveTest4() {

        Scene scene = new Scene("recursive Test4");

        ImageWriter imageWriter = new ImageWriter("\\" + IMAGES_TEST_DIR + "\\" + "Recursive Test 4", 500, 500, 500, 500);

        Triangle triangle = new Triangle(new Point3D(1500, -1500, -1500),
                new Point3D(-1500, 1500, -1500),
                new Point3D(200, 200, -375));
        triangle.setEmmission(new Color(20, 20, 20));

        Triangle triangle2 = new Triangle(new Point3D(1500, -1500, -1500),
                new Point3D(-1500, 1500, -1500),
                new Point3D(-1500, -1500, -1500));
        triangle2.setEmmission(new Color(20, 20, 20));

        Material material3 = new Material();
        material3.setKr(1);
        triangle.setMaterial(new Material(material3));

        Material material4 = new Material();
        material4.setKr(0.5);
        triangle2.setMaterial(new Material(material4));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        Sphere sphere = new Sphere(300, new Point3D(-550, -500, -1000));
        sphere.setEmmission(new Color(0, 0, 100));
        Material material = new Material();
        material.setnShininess(20);
        material.setKt(0.5);
        sphere.setMaterial(new Material(material));
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(150, new Point3D(-550, -500, -1000));
        sphere2.setEmmission(new Color(100, 20, 20));
        Material material2 = new Material();
        material2.setnShininess(20);
        material2.setKt(0);
        sphere2.setMaterial(new Material(material2));
        scene.addGeometry(sphere2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -150),
                0, 0.00001, 0.000005, new Vector(-2, -2, -3)));

        Render render = new Render(imageWriter, scene);
        render.renderImage();
    }

}
