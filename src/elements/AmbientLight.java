package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

/**
 * A light that has const intensity everywhere.
 */

public class AmbientLight extends Light {

    private double Ka = 0.1;

    /**
     * Default constructor. sets the color to white.
     */
    public AmbientLight(){
        super(Color.white);
    }

    /**
     * Constructor with color and Ka.
     * @param color color for the light.
     * @param ka "mekadem deicha"
     */
    public AmbientLight(Color color, double ka) {
        super(color);
        setKa(ka);
    }

    /**
     * Constructor that creates color.
     * @param r red component.
     * @param g green component.
     * @param b blue component.
     * @param ka "mekadem deicha"
     */
    public AmbientLight(int r, int g, int b, double ka){
        super(new Color(r,g,b));
        setKa(ka);
    }

    public double getKa() {
        return Ka;
    }

    public void setKa(double ka) {
        Ka = ka;
    }

    /**
     * Get the intensity of the light. fixed everywhere.
     * @param point point for getting intensity.
     * @return intensity color.
     */
    @Override
    public Color getIntensity(Point3D point) {
        //color * K.
        double r = super.getIntensity(point).getRed() * getKa();
        double g = super.getIntensity(point).getGreen() * getKa();
        double b = super.getIntensity(point).getBlue() * getKa();
        return new Color((int) r, (int) g, (int) b);
    }

    /**
     * Ambient doesn't have direction vector.
     * @param point the 'to' point of the vector.
     * @return vector from light source ti point.
     */
    @Override
    public Vector getL(Point3D point){
        return null;
    }
}
