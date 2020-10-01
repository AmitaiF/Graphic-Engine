import elements.PointLight;
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

import java.awt.*;

public class FinalTest {

    private final String IMAGES_TEST_DIR = "src/test/images";

    @Test
    public void desktopTest() {

        ImageWriter imageWriter = new ImageWriter("\\" + IMAGES_TEST_DIR + "\\" + "Desktop Test", 500, 500, 500, 500);

        Scene scene = new Scene("Desktop scene");
        scene.setScreenDistance(350);

        Triangle triangle1 = new Triangle(new Point3D(200, 0, -500), new Point3D(200, 50, -600), new Point3D(-200, 0, -500));
        Triangle triangle2 = new Triangle(new Point3D(-200, 0, -500), new Point3D(200, 50, -600), new Point3D(-200, 50, -600));
        Triangle triangle3 = new Triangle(new Point3D(200, -10, -500), new Point3D(200, 40, -600), new Point3D(-200, -10, -500));
        Triangle triangle4 = new Triangle(new Point3D(-200, -10, -500), new Point3D(200, 40, -600), new Point3D(-200, 40, -600));
        Triangle triangle5 = new Triangle(new Point3D(200, 0, -500), new Point3D(200, -10, -500), new Point3D(-200, 0, -500));
        Triangle triangle6 = new Triangle(new Point3D(200, -10, -500), new Point3D(-200, -10, -500), new Point3D(-200, 0, -500));

        Color color = new Color(110, 58, 2);

        triangle1.setEmmission(color);
        triangle2.setEmmission(color);
        triangle3.setEmmission(color);
        triangle4.setEmmission(color);
        triangle5.setEmmission(color);
        triangle6.setEmmission(color);

        Material material = new Material();

        triangle1.setMaterial(material);
        triangle2.setMaterial(material);
        triangle3.setMaterial(material);
        triangle4.setMaterial(material);
        triangle5.setMaterial(material);
        triangle6.setMaterial(material);

        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle5);
        scene.addGeometry(triangle6);
        //scene.addGeometry(triangle3);
        //scene.addGeometry(triangle4); // desktop setup

        //front legs
        Triangle triangle7 = new Triangle(new Point3D(120, 5, -530), new Point3D(120, -185, -530), new Point3D(145, 5, -530));
        Triangle triangle8 = new Triangle(new Point3D(120, -185, -530), new Point3D(145, 5, -530), new Point3D(145, -185, -530));
        Triangle triangle9 = new Triangle(new Point3D(-120, 5, -530), new Point3D(-120, -185, -530), new Point3D(-145, 5, -530));
        Triangle triangle10 = new Triangle(new Point3D(-120, -185, -530), new Point3D(-145, 5, -530), new Point3D(-145, -185, -530));
        Triangle triangle11 = new Triangle(new Point3D(120, -185, -530), new Point3D(120, 5, -530), new Point3D(120, -185, -550));
        Triangle triangle12 = new Triangle(new Point3D(120, -185, -530), new Point3D(120, 5, -530), new Point3D(120, 5, -550));
        Triangle triangle13 = new Triangle(new Point3D(-120, -185, -530), new Point3D(-120, 5, -530), new Point3D(-120, -185, -550));
        Triangle triangle14 = new Triangle(new Point3D(-120, -185, -530), new Point3D(-120, 5, -530), new Point3D(-120, 5, -550));

        //back legs
        Triangle triangle15 = new Triangle(new Point3D(120, 30, -580), new Point3D(120, -160, -580), new Point3D(145, 30, -580));
        Triangle triangle16 = new Triangle(new Point3D(120, -160, -580), new Point3D(145, 30, -580), new Point3D(145, -160, -580));
        Triangle triangle17 = new Triangle(new Point3D(-120, 30, -580), new Point3D(-120, -160, -580), new Point3D(-145, 30, -580));
        Triangle triangle18 = new Triangle(new Point3D(-120, -160, -580), new Point3D(-145, 30, -580), new Point3D(-145, -160, -580));
        Triangle triangle19 = new Triangle(new Point3D(120, -160, -580), new Point3D(120, 30, -580), new Point3D(120, -160, -600));
        Triangle triangle20 = new Triangle(new Point3D(120, -160, -580), new Point3D(120, 30, -580), new Point3D(120, 30, -600));
        Triangle triangle21 = new Triangle(new Point3D(-120, -160, -580), new Point3D(-120, 30, -580), new Point3D(-120, -160, -600));
        Triangle triangle22 = new Triangle(new Point3D(-120, -160, -580), new Point3D(-120, 30, -580), new Point3D(-120, 30, -600));

        Color legsColor = new Color(80, 80, 80);

        triangle7.setEmmission(legsColor);
        triangle8.setEmmission(legsColor);
        triangle9.setEmmission(legsColor);
        triangle10.setEmmission(legsColor);
        triangle11.setEmmission(legsColor);
        triangle12.setEmmission(legsColor);
        triangle13.setEmmission(legsColor);
        triangle14.setEmmission(legsColor);
        triangle15.setEmmission(legsColor);
        triangle16.setEmmission(legsColor);
        triangle17.setEmmission(legsColor);
        triangle18.setEmmission(legsColor);
        triangle19.setEmmission(legsColor);
        triangle20.setEmmission(legsColor);
        triangle21.setEmmission(legsColor);
        triangle22.setEmmission(legsColor);

        Material m = new Material(0.2, 0.1, 5, 0, 0);

        triangle7.setMaterial(m);
        triangle8.setMaterial(m);
        triangle9.setMaterial(m);
        triangle10.setMaterial(m);
        triangle11.setMaterial(m);
        triangle12.setMaterial(m);
        triangle13.setMaterial(m);
        triangle14.setMaterial(m);
        triangle15.setMaterial(m);
        triangle16.setMaterial(m);
        triangle17.setMaterial(m);
        triangle18.setMaterial(m);
        triangle19.setMaterial(m);
        triangle20.setMaterial(m);
        triangle21.setMaterial(m);
        triangle22.setMaterial(m);

        scene.addGeometry(triangle7);
        scene.addGeometry(triangle8);
        scene.addGeometry(triangle9);
        scene.addGeometry(triangle10);
        scene.addGeometry(triangle11);
        scene.addGeometry(triangle12);
        scene.addGeometry(triangle13);
        scene.addGeometry(triangle14);
        scene.addGeometry(triangle15);
        scene.addGeometry(triangle16);
        scene.addGeometry(triangle17);
        scene.addGeometry(triangle18);
        scene.addGeometry(triangle19);
        scene.addGeometry(triangle20);
        scene.addGeometry(triangle21);
        scene.addGeometry(triangle22); // legs setup

        Triangle triangle23 = new Triangle(new Point3D(500, -450, 0), new Point3D(-500, -450, 0), new Point3D(700, -50, -800));
        Triangle triangle24 = new Triangle(new Point3D(-500, -450, 0), new Point3D(700, -50, -800), new Point3D(-700, -50, -800));

        Color floorColor = new Color(150, 150, 150);

        triangle23.setEmmission(floorColor);
        triangle24.setEmmission(floorColor);

        Material floorMaterial = new Material(1, 1, 30, 0, 0);
        triangle23.setMaterial(floorMaterial);
        triangle24.setMaterial(floorMaterial);

        scene.addGeometry(triangle23);
        scene.addGeometry(triangle24); // floor setup

        Triangle triangle25 = new Triangle(new Point3D(1000, -200, -700), new Point3D(1000, 800, -700), new Point3D(-1000, -200, -700));
        Triangle triangle26 = new Triangle(new Point3D(1000, 800, -700), new Point3D(-1000, -200, -700), new Point3D(-1000, 800, -700));

        Color wallColor = new Color(200, 200, 200);

        triangle25.setEmmission(wallColor);
        triangle26.setEmmission(wallColor);

        Material wallMaterial = new Material(0.2, 0.1, 10, 0, 0);

        triangle25.setMaterial(wallMaterial);
        triangle26.setMaterial(wallMaterial);

        scene.addGeometry(triangle25);
        scene.addGeometry(triangle26); // wall setup

        Sphere mouse = new Sphere(15, new Point3D(78, 16, -527));

        Color mouseColor = new Color(18, 18, 16);
        mouse.setEmmission(mouseColor);

        mouse.setMaterial(new Material(0.7, 0.2, 10, 0, 0));

        scene.addGeometry(mouse); // mouse setup

        Triangle triangle27 = new Triangle(new Point3D(40, 8, -502),
                new Point3D(-80, 8, -502),
                new Point3D(40, 24, -534)
        );
        Triangle triangle28 = new Triangle(new Point3D(40, 24, -534),
                new Point3D(-80, 8, -502),
                new Point3D(-80, 24, -534)
        );
        Triangle triangle29 = new Triangle(new Point3D(40, 8, -502),
                new Point3D(-80, 8, -502),
                new Point3D(40, 8, -516)
        );
        Triangle triangle30 = new Triangle(new Point3D(-80, 8, -516),
                new Point3D(-80, 8, -502),
                new Point3D(40, 8, -516)
        );

        Color keyboardColor = new Color(110, 100, 90);

        triangle27.setEmmission(keyboardColor);
        triangle28.setEmmission(keyboardColor);
        triangle29.setEmmission(keyboardColor);
        triangle30.setEmmission(keyboardColor);

        Material keyboardMaterial = new Material(0.4, 0.3, 15, 0, 0);

        triangle27.setMaterial(keyboardMaterial);
        triangle28.setMaterial(keyboardMaterial);
        triangle29.setMaterial(keyboardMaterial);
        triangle30.setMaterial(keyboardMaterial);

        scene.addGeometry(triangle27);
        scene.addGeometry(triangle28);
        scene.addGeometry(triangle29);
        scene.addGeometry(triangle30); // keyboard setup

        Triangle triangle35 = new Triangle(new Point3D(20, 30, -560),
                new Point3D(-20, 30, -560),
                new Point3D(20, 90, -560)
        );
        Triangle triangle36 = new Triangle(new Point3D(20, 90, -560),
                new Point3D(-20, 30, -560),
                new Point3D(-20, 90, -560)
        );
        Triangle triangle37 = new Triangle(new Point3D(100, 50, -554),
                new Point3D(-100, 50, -554),
                new Point3D(100, 150, -554)
        );
        Triangle triangle38 = new Triangle(new Point3D(100, 150, -554),
                new Point3D(-100, 50, -554),
                new Point3D(-100, 150, -554)
        );
        Triangle triangle39 = new Triangle(new Point3D(100, 50, -564),
                new Point3D(-100, 50, -564),
                new Point3D(100, 150, -564)
        );
        Triangle triangle40 = new Triangle(new Point3D(100, 150, -564),
                new Point3D(-100, 50, -564),
                new Point3D(-100, 150, -564)
        );

        Color screenColor = new Color(0, 0, 0);

        triangle35.setEmmission(keyboardColor);
        triangle36.setEmmission(keyboardColor);
        triangle37.setEmmission(screenColor);
        triangle38.setEmmission(screenColor);
        triangle39.setEmmission(screenColor);
        triangle40.setEmmission(screenColor);

        Material screenMaterial = new Material(0.1, 1, 30, 0, 0);

        triangle35.setMaterial(new Material());
        triangle36.setMaterial(new Material());
        triangle37.setMaterial(screenMaterial);
        triangle38.setMaterial(screenMaterial);
        triangle39.setMaterial(screenMaterial);
        triangle40.setMaterial(screenMaterial);

        scene.addGeometry(triangle35);
        scene.addGeometry(triangle36);
        scene.addGeometry(triangle37);
        scene.addGeometry(triangle38);
        scene.addGeometry(triangle39);
        scene.addGeometry(triangle40); // screen setup

        Triangle triangle41 = new Triangle(new Point3D(140, 10, -520), new Point3D(180, 10, -520), new Point3D(140, 150, -520));
        Triangle triangle42 = new Triangle(new Point3D(180, 10, -520), new Point3D(140, 150, -520), new Point3D(180, 150, -520));
        Triangle triangle43 = new Triangle(new Point3D(140, 150, -520), new Point3D(180, 150, -520), new Point3D(180, 180, -580));
        Triangle triangle44 = new Triangle(new Point3D(140, 150, -520), new Point3D(180, 180, -580), new Point3D(140, 180, -580));
        Triangle triangle45 = new Triangle(new Point3D(140, 10, -520), new Point3D(140, 150, -520), new Point3D(140, 180, -580));
        Triangle triangle46 = new Triangle(new Point3D(140, 180, -580), new Point3D(140, 10, -520), new Point3D(140, 40, -580));

        Color computerColor = new Color(130, 130, 130);

        triangle41.setEmmission(computerColor);
        triangle42.setEmmission(computerColor);
        triangle43.setEmmission(computerColor);
        triangle44.setEmmission(computerColor);
        triangle45.setEmmission(computerColor);
        triangle46.setEmmission(computerColor);

        triangle41.setMaterial(m);
        triangle42.setMaterial(m);
        triangle43.setMaterial(m);
        triangle44.setMaterial(m);
        triangle45.setMaterial(m);
        triangle46.setMaterial(m);

        scene.addGeometry(triangle41);
        scene.addGeometry(triangle42);
        scene.addGeometry(triangle43);
        scene.addGeometry(triangle44);
        scene.addGeometry(triangle45);
        scene.addGeometry(triangle46);






        scene.addLight(new PointLight(new Point3D(0, 220, -300),
                0, 0.00001, 0.000005, new Color(108, 43, 43)));


        Render render = new Render(imageWriter, scene);

        render.renderImage();


    }

    @Test
    public void test() {

        Scene scene = new Scene("scene");
        scene.setScreenDistance(100);

        ImageWriter imageWriter = new ImageWriter("\\" + IMAGES_TEST_DIR + "\\" + "Test", 500, 500, 500, 500);

        Triangle triangle = new Triangle(new Point3D(500, -500, -1000),
                new Point3D(-500, -500, -1000), new Point3D(-500, 1000, -1000));
        triangle.setEmmission(new Color(110, 58, 2));
        Material m = new Material();
        triangle.setMaterial(m);

        Triangle triangle2 = new Triangle(new Point3D(500, -500, -503),
                new Point3D(-500, -500, -503), new Point3D(-500, 1000, -503));
        triangle2.setEmmission(new Color(110, 58, 2));
        triangle2.setMaterial(m);

        Sphere sphere = new Sphere(300, new Point3D(0, 0, -500));
        sphere.setEmmission(new Color(110, 58, 2));
        sphere.setMaterial(m);

        scene.addGeometry(triangle);
        //scene.addGeometry(triangle2);
        scene.addGeometry(sphere);

        scene.addLight(new PointLight(new Point3D(0, 70, -100),
                0, 0.00001, 0.000005, new Color(108, 43, 43)));


        Render render = new Render(imageWriter, scene);
        render.renderImage();

    }

    @Test
    public void reflectedTest() {
        Scene scene = new Scene("reflected");
        scene.setScreenDistance(200);

        ImageWriter imageWriter = new ImageWriter("\\" + IMAGES_TEST_DIR + "\\" + "Test", 500, 500, 500, 500);

        Sphere sphere = new Sphere(300, new Point3D(-500, -300, -1000));
        sphere.setEmmission(new Color(255, 64, 9));
        sphere.setMaterial(new Material());

        Triangle triangle = new Triangle(new Point3D(1500, -1500, -1500),
                new Point3D(-1500, 1500, -1500),
                new Point3D(-1500, -1500, -1500));
        triangle.setEmmission(new Color(20, 20, 20));
        triangle.setMaterial(new Material(1, 1, 20, 1, 0));

        Triangle triangle2 = new Triangle(new Point3D(1500, -1500, -1500), new Point3D(-1500, 1500, -1500), new Point3D(500, 0, -500));
        triangle2.setEmmission(new Color(20, 20, 20));
        triangle.setMaterial(new Material(1, 1, 20, 1, 0));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addGeometry(sphere);

        scene.addLight(new PointLight(new Point3D(0, 100, -150), 0, 0.00001, 0.000005, new Color(108, 43, 43)));

        Render render = new Render(imageWriter, scene);
        render.renderImage();
    }

}
