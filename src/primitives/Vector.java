package primitives;

import java.util.Objects;

import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;

// vector - start from (0,0,0)

public class Vector {
    private Point3D head;

    public Vector(double x, double y, double z){
        this.head = new Point3D(new Coordinate(x), new Coordinate(y), new Coordinate(z));
    }

    //ctor from 2 points
    public Vector(Point3D p1, Point3D p2){
        setHead(p1.subtract(p2).getHead());
    }

    public Vector(Point3D head) {
        this.setHead(head);
    }

    // copy ctor
    public Vector(Vector v){
        setHead(v.getHead());
    }

    //add vector to vector
    public void add(Vector vec) {
        setHead(getHead().addVector(vec));
    }

    // subtract between 2 vectors
    public void subtract(Vector vec) {
        setHead(getHead().subtract(vec.getHead()).getHead());
    }

    // scale vector with scalar
    public Vector scale(double scalar) {
        return new Vector(new Point3D(getHead().getX().scale(scalar), getHead().getY().scale(scalar), getHead().getZ().scale(scalar)));
    }

    public double dotProduct(Vector vec) {
        double x1 = getHead().getX().get();
        double y1 = getHead().getY().get();
        double z1 = getHead().getZ().get();

        double x2 = vec.getHead().getX().get();
        double y2 = vec.getHead().getY().get();
        double z2 = vec.getHead().getZ().get();

        return Util.uadd(Util.uadd(Util.uscale(x1, x2), Util.uscale(y1, y2)), Util.uscale(z1, z2));
    }

    // find orthogonal vector
    public Vector crossProduct(Vector vec) {

        double x1 = getHead().getX().get();
        double y1 = getHead().getY().get();
        double z1 = getHead().getZ().get();

        double x2 = vec.getHead().getX().get();
        double y2 = vec.getHead().getY().get();
        double z2 = vec.getHead().getZ().get();

        return new Vector(new Point3D(
                new Coordinate(Util.usubtract(Util.uscale(y1, z2), Util.uscale(z1, y2))),
                new Coordinate(Util.usubtract(Util.uscale(z1, x2), Util.uscale(x1, z2))),
                new Coordinate(Util.usubtract(Util.uscale(x1, y2), Util.uscale(y1, x2)))));
    }

    // return the vector's length
    public double length() {
        double x = getHead().getX().get();
        double y = getHead().getY().get();
        double z = getHead().getZ().get();

        return sqrt(Util.uadd(Util.uadd(Util.uscale(x, x), Util.uscale(y, y)), Util.uscale(z, z)));

    }

    // returns normalize vector
    public Vector normalize() {
        double x = getHead().getX().get();
        double y = getHead().getY().get();
        double z = getHead().getZ().get();

        double length = length();

        if (length == 0)
            throw new ArithmeticException();

        return new Vector(x/length,y/length,z/length);
    }

    public Vector() {
        setHead(new Point3D());
    }

    public Point3D getHead() {
        return new Point3D(head);
    }

    public void setHead(Point3D head) {
        this.head = new Point3D(head);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Vector)) return false;
        Vector vector = (Vector) o;
        return getHead().equals(vector.getHead());
    }

    @Override
    public String toString() {
        return "{" +
                "head=" + getHead() +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHead());
    }

}
