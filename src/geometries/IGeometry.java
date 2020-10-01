package geometries;

import primitives.*;

import java.awt.Color;
import java.util.List;

/**
 * Defines the functions all geometries must have.
 */

public interface IGeometry {

    /**
     * Get a normal to a geometry in a specific point.
     * @param p the start point of the normal.
     * @return  normal to the point.
     */
    Vector getNormal(Point3D p);

    /**
     * Find all intersections between geometry and a ray.
     * @param ray the ray we using for intersect the geometries.
     * @return list of intersections with the ray.
     */
    List<Point3D> findIntersections(Ray ray);


}
