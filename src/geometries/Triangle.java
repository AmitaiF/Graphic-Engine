package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


/**
 * 2D triangle, defined by 3 points.
 */

public class Triangle extends Plane {

    private Point3D p1;
    private Point3D p2;
    private Point3D p3;

    /**
     * Constructor that gets 3 points.
     * @param p1 first point for triangle.
     * @param p2 second point for triangle.
     * @param p3 third point for triangle.
     */
    public Triangle(Point3D p1, Point3D p2, Point3D p3) {
        this.setP1(p1);
        this.setP2(p2);
        this.setP3(p3);
    }

    /**
     * Copy constructor for deep copy.
     * @param t the triangle we copy from.
     */
    public Triangle(Triangle t) {
        setP1(t.getP1());
        setP2(t.getP2());
        setP3(t.getP3());
    }

    /**
     * Get a normal to the triangle.
     * @param point the point we want the normal.
     * @return normal to the trinagle.
     */
    public Vector getNormal(Point3D point) {
        Vector v1 = p1.subtract(p2); // find a vector on the triangle.
        Vector v2 = p1.subtract(p3); // find another vector on the triangle.
        Vector N = v1.crossProduct(v2).normalize(); // find orthogonal vector to them, and normalize it.
        return N; // return the normalized.
    }

    public Point3D getP1() {
        return p1;
    }

    public Point3D getP2() {
        return p2;
    }

    public Point3D getP3() {
        return p3;
    }

    public void setP1(Point3D p1) {
        this.p1 = p1;
    }

    public void setP2(Point3D p2) {
        this.p2 = p2;
    }

    public void setP3(Point3D p3) {
        this.p3 = p3;
    }

    /**
     * Find intersections of the triangle with a ray (only 1 point).
     * @param ray the ray for intersect.
     * @return list of the intersections points (only 1 point).
     */
    @Override
    public List<Point3D> findIntersections(Ray ray) {

        List<Point3D> intersections = new ArrayList<Point3D>();

        Plane plane = new Plane(p1, p2, p3); // creates plane from the triangle
        intersections = plane.findIntersections(ray); // find the plane intersection
        if (intersections.isEmpty()) // has no intersections.
            return intersections;

        Point3D p0 = ray.getP0();

        // check if the intersection point is inside the triangle

        //vectors between the triangle's points
        Vector v1 = new Vector(p1, p0).normalize();
        Vector v2 = new Vector(p2, p0).normalize();
        Vector v3 = new Vector(p3, p0).normalize();

        // normals to the vectors (for "triangles")
        Vector n1 = new Vector(v1.crossProduct(v2));
        Vector n2 = new Vector(v2.crossProduct(v3));
        Vector n3 = new Vector(v3.crossProduct(v1));

        Point3D p = new Point3D(intersections.get(0));

        // if the point hasn't same sign for each "triangle"
        if (!((Math.signum(new Vector(p, p0).dotProduct(n1)) ==
                Math.signum(new Vector(p, p0).dotProduct(n2)) &&
                Math.signum(new Vector(p, p0).dotProduct(n2)) ==
                        Math.signum(new Vector(p, p0).dotProduct(n3)))))
            intersections.clear();

        // if the ray is the same direction as the point
        else {
            if (new Vector(intersections.get(0), ray.getP0()).dotProduct(ray.getDirection()) < 0)
                intersections.clear();
        }

        return intersections;


    }

}
