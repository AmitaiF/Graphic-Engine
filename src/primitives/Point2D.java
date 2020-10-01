package primitives;

import java.util.Objects;

// two dimensions point, with two coordinates

public class Point2D {
    protected Coordinate x;
    protected Coordinate y;

    public Point2D(Coordinate x, Coordinate y) {
        this.setX(x);
        this.setY(y);
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + getX() +
                ", y=" + getY() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Point2D)) return false;
        Point2D point2D = (Point2D) o;
        return getX().equals(point2D.getX()) &&
                getY().equals(point2D.getY());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    public Point2D() {
        setX(Coordinate.ZERO);
        setY(Coordinate.ZERO);
    }

    public Coordinate getX() {
        return new Coordinate(x);
    }

    public void setX(Coordinate x) {
        this.x = new Coordinate(x);
    }

    public Coordinate getY() {
        return new Coordinate(y);
    }

    public void setY(Coordinate y) {
        this.y = new Coordinate(y);
    }
}
