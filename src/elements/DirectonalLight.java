package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

/**
 * A fixed intensity of light.
 */

public class DirectonalLight extends Light {

    private Vector direcrion;

    /**
     * Constructor that sets direction and color.
     * @param direcrion
     * @param color
     */
    public DirectonalLight(Vector direcrion, Color color) {
        super(color);
        this.setDirecrion(direcrion);
    }

    public void setDirecrion(Vector direcrion) {
        this.direcrion = new Vector(direcrion);
    }

    public Vector getDirecrion() {
        return new Vector(direcrion);
    }

    /**
     * Get the light intensity in a specific point.
     * @param point point for finding intensity.
     * @return intensity in a specific point.
     */
    @Override
    public Color getIntensity(Point3D point) {
        return super.getIntensity(point); // has fix intensity, such as "light".
    }

    /**
     * Get vector between the light source and the point.
     * @param point the 'to' point of the vector.
     * @return vector from light source to geometry point.
     */
    @Override
    public Vector getL(Point3D point) {
        return getDirecrion();
    }
}
