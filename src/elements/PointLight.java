package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

/**
 * A light source that light all around itself.
 */

public class PointLight extends Light {

    private Point3D position;

    private double Kc, Kl, Kq;

    /**
     * Constructor with all the point light parameters.
     * @param position position of the light source.
     * @param Kc first distance factor.
     * @param Kl second distance factor.
     * @param Kq third distance factor.
     * @param color light source's color.
     */
    public PointLight(Point3D position, double Kc, double Kl, double Kq, Color color) {
        super(color);
        this.setPosition(position);
        this.setKc(Kc);
        this.setKl(Kl);
        this.setKq(Kq);
    }

    public Point3D getPosition() {
        return position;
    }

    public void setPosition(Point3D position) {
        this.position = position;
    }

    public double getKc() {
        return Kc;
    }

    public void setKc(double Kc) {
        this.Kc = Kc;
    }

    public double getKl() {
        return Kl;
    }

    public void setKl(double Kl) {
        this.Kl = Kl;
    }

    public double getKq() {
        return Kq;
    }

    public void setKq(double Kq) {
        this.Kq = Kq;
    }

    /**
     * Get intensity in a specific point.
     * @param point point for finding intensity.
     * @return color at the point.
     */
    @Override
    public Color getIntensity(Point3D point) {

        double d = getPosition().distance(point); // the distance between the light source and geometry

        double k = 1 / (getKc() + getKl() * d + getKq() * Math.pow(d, 2)); // calculating the intensity factor
        if (k > 1) k = 1;

        return new Color((int) (_color.getRed() * k), (int) (_color.getGreen() * k), (int) (_color.getBlue() * k)); // calculating the color
    }

    /**
     * Get a vector from point source to geometry point.
     * @param point the 'to' point of the vector.
     * @return vector from point source to geometry point.
     */
    @Override
    public Vector getL(Point3D point) {
        //point light points all around, so we just need to create vector from its position to geometry point
        return point.subtract(getPosition()).normalize();
    }
}
