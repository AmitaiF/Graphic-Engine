import elements.*;
import geometries.Geometry;
import geometries.Sphere;
import geometries.Triangle;
import org.junit.jupiter.api.Test;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Shlav8Tester {

    private final String IMAGES_TEST_DIR = "src/test/images";

    @Test
    public void pointLightTest1() {

        ImageWriter imageWriter = new ImageWriter("\\" + IMAGES_TEST_DIR + "\\" + "Point Test without super-sampling", 500, 500, 500, 500);

        Scene scene = new Scene("point light scene 1");
        scene.setScreenDistance(100);
        scene.setAmbientLight(new AmbientLight());
        scene.setBackground(Color.black);
        scene.setCamera(new Camera(Point3D.ZERO, new Vector(0.0, 1.0, 0.0), new Vector(0.0, 0.0, -1.0)));

        Sphere sphere = new Sphere(800, new Point3D(0, 0, -1000));
        sphere.setEmmission(new Color(0, 0, 100));
        Material m = new Material(1, 0.9, 20, 0, 0);
        sphere.setMaterial(m);

        scene.addGeometry(sphere);
        scene.addLight(new PointLight(new Point3D(-200, -200, -100), 0, 0.000001, 0.0000005, new Color(255, 100, 100)));
        //scene.addLight(new DirectonalLight(new Vector(new Point3D(0,0,-1)), new Color(255, 100, 100)));

        Render render = new Render(imageWriter, scene);

        render.renderImage();

    }


    @Test
    public void pointLightTest2() {

        ImageWriter imageWriter = new ImageWriter("\\" + IMAGES_TEST_DIR + "\\" + "Point Test 2", 500, 500, 500, 500);

        Scene scene = new Scene("point light scene 2");
        scene.setScreenDistance(100);
        scene.setAmbientLight(new AmbientLight());
        scene.setBackground(Color.black);
        scene.setCamera(new Camera(Point3D.ZERO, new Vector(0.0, 1.0, 0.0), new Vector(0.0, 0.0, -1.0)));

        Sphere sphere = new Sphere(800, new Point3D(0, 0, -1000));
        sphere.setEmmission(new Color(0, 0, 100));
        Material m = new Material(1, 0.9, 20, 0, 0);
        sphere.setMaterial(m);

        scene.addGeometry(sphere);

        Triangle triangle = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, -3500, -1000), new Point3D(3500, -3500, -2000));
        triangle.setEmmission(new Color(0, 0, 0));
        triangle.setMaterial(m);
        Triangle triangle2 = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, 3500, -1000), new Point3D(-3500, -3500, -1000));
        triangle2.setEmmission(new Color(0, 0, 0));
        triangle2.setMaterial(m);

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new PointLight(new Point3D(-200, -200, -100), 0, 0.000001, 0.0000005, new Color(255, 100, 100)));
        //scene.addLight(new DirectonalLight(new Vector(new Point3D(0,0,-1)), new Color(255, 100, 100)));

        Render render = new Render(imageWriter, scene);

        render.renderImage();

    }

    @Test
    public void pointLightTest3() {

        ImageWriter imageWriter = new ImageWriter("\\" + IMAGES_TEST_DIR + "\\" + "Point Test 3", 500, 500, 500, 500);

        Scene scene = new Scene("point light scene 3");
        scene.setScreenDistance(100);
        scene.setAmbientLight(new AmbientLight());
        scene.setBackground(Color.black);
        scene.setCamera(new Camera(Point3D.ZERO, new Vector(0.0, 1.0, 0.0), new Vector(0.0, 0.0, -1.0)));

        Sphere sphere = new Sphere(800, new Point3D(0, 0, -1000));
        sphere.setEmmission(new Color(0, 0, 100));
        Material m = new Material(1, 0.9, 20, 0, 0);
        sphere.setMaterial(m);

        scene.addGeometry(sphere);
        scene.addLight(new PointLight(new Point3D(-200, -200, -100), 0, 0.000001, 0.0000005, new Color(255, 100, 100)));
        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(0, 0, -100), 0, 0.00001, 0.000005, new Vector(2, 2, -3)));

        Render render = new Render(imageWriter, scene);

        render.renderImage();

    }

    @Test
    public void pointLightTest4() {

        ImageWriter imageWriter = new ImageWriter("\\" + IMAGES_TEST_DIR + "\\" + "Point Test 4", 500, 500, 500, 500);

        Scene scene = new Scene("point light scene 4");
        scene.setScreenDistance(100);
        scene.setAmbientLight(new AmbientLight());
        scene.setBackground(Color.black);
        scene.setCamera(new Camera(Point3D.ZERO, new Vector(0.0, 1.0, 0.0), new Vector(0.0, 0.0, -1.0)));

        Sphere sphere = new Sphere(500, new Point3D(100, 500, -800));
        sphere.setEmmission(new Color(0, 0, 100));
        Material m = new Material(0.7, 0.8, 2000, 0, 0);
        sphere.setMaterial(m);

        scene.addGeometry(sphere);
        scene.addLight(new PointLight(new Point3D(0, 0, -100), 0, 0.000001, 0.0000005, new Color(255, 100, 100)));

        Render render = new Render(imageWriter, scene);

        render.renderImage();

    }


    @Test
    public void pointLightTest5() {

        ImageWriter imageWriter = new ImageWriter("\\" + IMAGES_TEST_DIR + "\\" + "Point Test 5", 500, 500, 500, 500);

        Scene scene = new Scene("point light scene 5");
        scene.setScreenDistance(100);
        scene.setAmbientLight(new AmbientLight());
        scene.setBackground(Color.black);
        scene.setCamera(new Camera(Point3D.ZERO, new Vector(0.0, 1.0, 0.0), new Vector(0.0, 0.0, -1.0)));


        Material m = new Material(0.5, 0.9, 20, 0, 0);

        Triangle triangle = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, -3500, -2000), new Point3D(3500, -3500, -2000));
        triangle.setEmmission(new Color(255, 12, 12));
        triangle.setMaterial(m);
        Triangle triangle2 = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, 3500, -2000), new Point3D(-3500, -3500, -2000));
        triangle2.setEmmission(new Color(255, 12, 12));
        triangle2.setMaterial(m);

        Sphere sphere = new Sphere(500, new Point3D(-1000, 0, -1000));
        sphere.setEmmission(new Color(25, 7, 255));
        sphere.setMaterial(m);

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addGeometry(sphere);

        scene.addLight(new PointLight(new Point3D(-200, -200, -100), 0, 0.000001, 0.0000005, new Color(255, 235, 13)));
        //scene.addLight(new DirectonalLight(new Vector(new Point3D(0,0,-1)), new Color(255, 100, 100)));

        Render render = new Render(imageWriter, scene);

        render.renderImage();

    }

    @Test
    public void spotLightTest1() {

        ImageWriter imageWriter = new ImageWriter("\\" + IMAGES_TEST_DIR + "\\" + "Spot Test 1", 500, 500, 500, 500);

        Scene scene = new Scene("spot light scene 1");
        scene.setScreenDistance(100);
        scene.setAmbientLight(new AmbientLight());
        scene.setBackground(Color.black);
        scene.setCamera(new Camera(Point3D.ZERO, new Vector(0.0, 1.0, 0.0), new Vector(0.0, 0.0, -1.0)));

        Sphere sphere = new Sphere(800, new Point3D(0, 0, -1000));
        sphere.setEmmission(new Color(0, 0, 100));
        Material m = new Material(1, 1, 20, 0, 0);
        sphere.setMaterial(m);

        scene.addGeometry(sphere);


        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -100), 0, 0.00001, 0.000005, new Vector(2, 2, -3)));

        Render render = new Render(imageWriter, scene);

        render.renderImage();
    }

    @Test
    public void spotLightTest2() {

        ImageWriter imageWriter = new ImageWriter("\\" + IMAGES_TEST_DIR + "\\" + "Spot Test 2", 500, 500, 500, 500);

        Scene scene = new Scene("spot light scene 2");
        scene.setScreenDistance(100);
        scene.setAmbientLight(new AmbientLight());
        scene.setBackground(Color.black);
        scene.setCamera(new Camera(Point3D.ZERO, new Vector(0.0, 1.0, 0.0), new Vector(0.0, 0.0, -1.0)));

        Sphere sphere = new Sphere(800, new Point3D(0, 0, -1000));
        sphere.setEmmission(new Color(0, 0, 100));
        Material m = new Material(1, 0.9, 20, 0, 0);
        sphere.setMaterial(m);

        scene.addGeometry(sphere);


        Triangle triangle = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, -3500, -1000), new Point3D(3500, -3500, -2000));
        triangle.setEmmission(new Color(0, 0, 100));

        Material m1 = new Material(1, 0.9, 4, 0, 0);
        triangle.setMaterial(m);
        scene.addGeometry(triangle);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),
                0.1, 0.00001, 0.000005, new Vector(2, 2, -3)));

        Render render = new Render(imageWriter, scene);

        render.renderImage();
    }

    @Test
    public void spotLightTest3() {

        ImageWriter imageWriter = new ImageWriter("\\" + IMAGES_TEST_DIR + "\\" + "Spot Test 3", 500, 500, 500, 500);

        Scene scene = new Scene("spot light scene 3");
        scene.setScreenDistance(100);
        scene.setAmbientLight(new AmbientLight());
        scene.setBackground(Color.black);
        scene.setCamera(new Camera(Point3D.ZERO, new Vector(0.0, 1.0, 0.0), new Vector(0.0, 0.0, -1.0)));

        Material m = new Material(1, 0.9, 20, 0, 0);

        Triangle triangle = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, -3500, -1000),
                new Point3D(3500, -3500, -2000)
        );
        triangle.setEmmission(new Color(0, 0, 0));
        triangle.setMaterial(m);


        Triangle triangle2 = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, 3500, -1000),
                new Point3D(-3500, -3500, -1000)
        );
        triangle2.setEmmission(new Color(0, 0, 0));
        triangle2.setMaterial(m);

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                0, 0.000001, 0.0000005, new Vector(-2, -2, -3)));

        Render render = new Render(imageWriter, scene);

        render.renderImage();

    }

    @Test
    public void directionalLightTest1() {

        ImageWriter imageWriter = new ImageWriter("\\" + IMAGES_TEST_DIR + "\\" + "Directional Test", 500, 500, 500, 500);

        Scene scene = new Scene("directional light scene 1");
        scene.setScreenDistance(100);
        scene.setAmbientLight(new AmbientLight());
        scene.setBackground(Color.black);
        scene.setCamera(new Camera(Point3D.ZERO, new Vector(0.0, 1.0, 0.0), new Vector(0.0, 0.0, -1.0)));

        Sphere sphere = new Sphere(500, new Point3D(-300, 0, -1000));
        sphere.setEmmission(new Color(0, 0, 100));
        Material m = new Material(1, 0.4, 20, 0, 0);
        sphere.setMaterial(m);

        scene.addGeometry(sphere);

        Triangle triangle = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, -3500, -2000),
                new Point3D(3500, -3500, -2000)
        );
        triangle.setEmmission(new Color(0, 0, 0));
        triangle.setMaterial(m);


        Triangle triangle2 = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, 3500, -2000),
                new Point3D(-3500, -3500, -2000)
        );
        triangle2.setEmmission(new Color(0, 0, 0));
        triangle2.setMaterial(m);

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);


        scene.addLight(new DirectonalLight(new Vector(0, 0, -1), new Color(255, 100, 100)));

        Render render = new Render(imageWriter, scene);

        render.renderImage();
    }

}
