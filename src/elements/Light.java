package elements;

import primitives.Point3D;
import primitives.Vector;

import java.awt.*;

/**
 * Abstract class to define light requirements.
 */

public abstract class Light {

    Color _color;

    /**
     * Get vector from the light source to a point.
     * @param point the 'to' point of the vector.
     * @return vector from light source to specific point.
     */
    abstract public Vector getL(Point3D point);

    /**
     * Default constructor. sets color to white.
     */
    public Light() {
        _color = Color.white;
    }

    /**
     * Copy constructor.
     * @param _color color to be copied.
     */
    public Light(Color _color) {
        this._color = _color;
    }

    public void set_color(Color _color) {
        this._color = _color;
    }


    public Color getIntensity(Point3D point){
        return _color;
    }
}
