package renderer;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.File;

public class ImageWriterTest {

    private final String IMAGES_TEST_DIR = "src/test/images";

    @Test
    public void writeImageTest() {

        //new File(IMAGES_TEST_DIR).mkdirs();

        ImageWriter imageWriter = new ImageWriter("\\" + IMAGES_TEST_DIR + "\\" + "Image writer test", 500, 500, 500, 500);

        for (int i = 0; i < imageWriter.getHeight(); i++) {
            for (int j = 0; j < imageWriter.getWidth(); j++) {

                if (i % 50 == 0 || j % 50 == 0)
                    imageWriter.writePixel(j, i, Color.WHITE);
            }
        }

        imageWriter.writeToimage();
        System.out.println(IMAGES_TEST_DIR + "Image writer test");

    }

}