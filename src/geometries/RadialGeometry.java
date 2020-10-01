package geometries;

import java.awt.*;

/**
 * Abstract class for geometries with radius.
 */

abstract public class RadialGeometry extends Geometry {

    double radius;

    /**
     * Copy constructor.
     * @param radial
     */
    public RadialGeometry(RadialGeometry radial) {
        radius = radial.radius;
    }

    /**
     * Constructor that gets radius.
     * @param _radius a radius for the geometries.
     */
    public RadialGeometry(double _radius) {
        radius = _radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setEmmission(Color emmission) {
        super.setEmmission(emmission);
    }
}
