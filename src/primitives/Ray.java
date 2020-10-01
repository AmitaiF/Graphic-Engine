package primitives;

import java.util.Objects;

// ray - infinite vector with start point

public class Ray {

    private Point3D p0;

    private Vector direction;

    @Override
    public String toString() {
        return "{" +
                "p0=" + getP0() +
                ", direction=" + getDirection() +
                '}';
    }

    public Point3D getP0() {
        return new Point3D(p0);
    }

    public void setP0(Point3D p0) {
        this.p0 = new Point3D(p0);
    }

    public Vector getDirection() {
        return direction;
    }

    public void setDirection(Vector direction) {
        this.direction = new Vector(direction);
    }

    // default ctor
    public Ray() {
        setP0(new Point3D());
        setDirection(new Vector());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Ray)) return false;
        Ray ray = (Ray) o;
        return getP0().equals(ray.getP0()) &&
                getDirection().equals(ray.getDirection());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getP0(), getDirection());
    }

    public Ray(Point3D p0, Vector direction) {
        this.setP0(p0);
        this.setDirection(direction);
    }

    // copy ctor
    public Ray(Ray ray){
        setP0(ray.getP0());
        setDirection(ray.getDirection());
    }
}
