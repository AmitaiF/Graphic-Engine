package primitives;

import java.util.Objects;
import static java.lang.StrictMath.sqrt;

// three dimensions point, with 2D point and one coordinate

public class Point3D extends Point2D {

    public static final Point3D ZERO = new Point3D();

    private Coordinate z;

    // ctor
    public Point3D(Coordinate x, Coordinate y, Coordinate z) {
        super(x, y);
        this.setZ(z);
    }

    public Point3D(double x, double y, double z){
        setX(new Coordinate(x));
        setY(new Coordinate(y));
        setZ(new Coordinate(z));
    }

    // copy ctor
    public Point3D(Point3D p) {
        setX(p.getX());
        setY(p.getY());
        setZ(p.getZ());
    }

    @Override
    public String toString() {
        String str = super.toString();
        str = str.substring(0, str.length() - 1);
        str += ", z=" + getZ() + "}";
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Point3D)) return false;
        if (!super.equals(o)) return false;
        Point3D point3D = (Point3D) o;
        return getZ().equals(point3D.getZ());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getZ());
    }

    public Point3D() {
        super();
        setZ(Coordinate.ZERO);
    }

    public Coordinate getZ() {
        return new Coordinate(z);
    }

    public void setZ(Coordinate z) {
        this.z = new Coordinate(z);
    }

    public Vector subtract(Point3D p2) {
        Point3D p = new Point3D();
        p.setX(getX().subtract(p2.getX()));
        p.setY(getY().subtract(p2.getY()));
        p.setZ(getZ().subtract(p2.getZ()));
        return new Vector(p);
    }

    // add vector to point, returns point
    public Point3D addVector(Vector v) {
        Point3D pVec = v.getHead();

        Point3D result = new Point3D(
                getX().add(pVec.getX()),
                getY().add(pVec.getY()),
                getZ().add(pVec.getZ()));
        return result;
    }

    // find distance between 2 points using Pythagorean theorem
    public double distance(Point3D p) {
        double xx = Util.uscale((p.getX().get() - getX().get()), (p.getX().get() - getX().get()));
        double yy = Util.uscale((p.getY().get() - getY().get()), (p.getY().get() - getY().get()));
        double zz = Util.uscale((p.getZ().get() - getZ().get()), (p.getZ().get() - getZ().get()));

        return sqrt(Util.uadd(zz, Util.uadd(xx, yy)));
    }

}
