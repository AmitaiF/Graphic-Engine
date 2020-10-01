package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    @Test
    void add() {
        Vector V = new Vector(new Point3D(new Coordinate(1), new Coordinate(1), new Coordinate(1)));
        Vector U = new Vector(new Point3D(new Coordinate(1), new Coordinate(1), new Coordinate(1)));
        Vector expectedV = new Vector(new Point3D(new Coordinate(2), new Coordinate(2), new Coordinate(2)));
        V.add(U);
        assertEquals(expectedV, V);
    }

    @Test
    void subtract() {
        Vector V = new Vector(new Point3D(new Coordinate(2), new Coordinate(2), new Coordinate(2)));
        Vector U = new Vector(new Point3D(new Coordinate(1), new Coordinate(1), new Coordinate(1)));
        Vector expectedV = new Vector(new Point3D(new Coordinate(1), new Coordinate(1), new Coordinate(1)));
        V.subtract(U);
        assertEquals(expectedV, V);
    }

    @Test
    void scale() {
        Vector V = new Vector(new Point3D(new Coordinate(1), new Coordinate(1), new Coordinate(1)));
        Vector expectedV = new Vector(new Point3D(new Coordinate(3), new Coordinate(3), new Coordinate(3)));
        V = V.scale(3);
        assertEquals(expectedV, V);
    }

    @Test
    void dotProduct() {
        Vector V = new Vector(new Point3D(new Coordinate(2), new Coordinate(7), new Coordinate(1)));
        Vector U = new Vector(new Point3D(new Coordinate(3), new Coordinate(6), new Coordinate(2)));
        double expected = 50;
        assertEquals(expected, V.dotProduct(U));
    }

    @Test
    void crossProduct() {
        Vector V = new Vector(new Point3D(new Coordinate(1), new Coordinate(2), new Coordinate(3)));
        Vector U = new Vector(new Point3D(new Coordinate(3), new Coordinate(4), new Coordinate(5)));
        Vector expectedV = new Vector(new Point3D(new Coordinate(-2), new Coordinate(4), new Coordinate(-2)));
        assertEquals(expectedV, V.crossProduct(U));
    }

    @Test
    void length() {
        Vector V = new Vector(new Point3D(new Coordinate(1), new Coordinate(0), new Coordinate(0)));
        double expected = 1;
        assertEquals(expected, V.length());
    }

    @Test
    void normalize() {
        Vector V = new Vector(new Point3D(new Coordinate(0), new Coordinate(1), new Coordinate(0)));
        Vector expectedV = new Vector(new Point3D(new Coordinate(0), new Coordinate(1), new Coordinate(0)));
        V = V.normalize();
        assertEquals(expectedV, V);
    }
}