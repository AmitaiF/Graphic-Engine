package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * A flat geometry that defined by point and normal.
 */
public class Plane extends Geometry implements FlatGeometry{

    private Point3D p;
    private Vector N;

    public Plane(){}

    /**
     * Constructor that gets 3 points, and calculating normal.
     * @param p1 first point for plane.
     * @param p2 second point for plane.
     * @param p3 third  point for plane.
     */
    public Plane(Point3D p1, Point3D p2, Point3D p3){
        Vector v = p1.subtract(p2); // creates vector
        Vector u = p3.subtract(p2);// creates vector
        Vector n = v.crossProduct(u); // find orthogonal vector
        n = n.normalize(); // normalize the vector

        setN(n);
        setP(p2);
    }

    /**
     * Constructor that get point and normal.
     * @param p point for the plane.
     * @param N normal to the plane.
     */
    public Plane(Point3D p, Vector N){
        this.setP(p);
        N = N.normalize();
        this.setN(N);
    }

    public Point3D getP(){
        return p;
    }
    public Vector getN(){
        return N;
    }

    public void setP(Point3D p) {
        this.p = p;
    }
    public void setN(Vector n) {
        N = n;
        N = N.normalize();
    }

    /**
     * Returns normal to the plane.
     * @param p normal in the point p.
     * @return normal to the plane.
     */
    public Vector getNormal(Point3D p){
        return getN(); //N always normalized.
    }

    /**
     * Find the intersections with a ray, using the fact that dot product between orthogonal vectors is 0.
     * @param ray the ray for intersect.
     * @return list with the intersections point. (in plane, only 1 point).
     */
    public List<Point3D> findIntersections(Ray ray){

        List<Point3D> intersections = new ArrayList<Point3D>();
        Vector v = ray.getDirection();
        Vector u = getP().subtract(ray.getP0()); // vector from p0 to plane
        double t = getN().dotProduct(u); // dot product between u and normal
        t/= getN().dotProduct(v);
        v = v.scale(t);
        Point3D p = ray.getP0().addVector(v);

        intersections.add(p);
        return intersections;
    }
}
