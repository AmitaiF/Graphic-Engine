package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

/**
 * A point light with a specific direction.
 */

public class SpotLight extends PointLight {

    private Vector direction;

    /**
     * Constructor with all the parameters needed.
     * @param color light color.
     * @param position light position.
     * @param kc first distance factor.
     * @param kl second distance factor.
     * @param kq third distance factor.
     * @param direction light direction.
     */
    public SpotLight(Color color, Point3D position, double kc, double kl, double kq, Vector direction) {
        super(position, kc, kl, kq, color);
        setDirection(direction);
    }

    public Vector getDirection() {
        return direction;
    }

    public void setDirection(Vector direction) {
        this.direction = direction;
    }

    /**
     * Get light intensity in a specific point.
     * @param point point for finding intensity.
     * @return color at a specific point.
     */
    @Override
    public Color getIntensity(Point3D point) {

        Color pointLight = super.getIntensity(point); // the point light intensity
        // multiply the dot product between the direction and the L vector
        // (if it's far from direction - it's more weak. if it's close, it's stronger.
        double k = getL(point).dotProduct(getDirection().normalize());
        k = Math.abs(k);

        if (k > 1) k = 1;

        return new Color((int) (pointLight.getRed() * k), (int) (pointLight.getGreen() * k), (int) (pointLight.getBlue() * k)); // scale and return
    }

    /**
     * Get vector from light source to geometry point.
     * @param point the 'to' point of the vector.
     * @return returns vector from light source to geometry point.
     */
    @Override
    public Vector getL(Point3D point) {
        // the L vector is same as the point light L vector
        return super.getL(point);
    }
}
