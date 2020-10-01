package geometries;

import org.junit.jupiter.api.Test;
import primitives.Coordinate;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {

    @Test
    void findIntersections() {
        /***Point3D p0 = new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(0));
        Vector n = new Vector(new Point3D(new Coordinate(-3), new Coordinate(2), new Coordinate(1)));
        Point3D p = new Point3D(new Coordinate(2), new Coordinate(5),new Coordinate(7));
        Plane plane = new Plane(p, n);
        Vector v = new Vector(new Point3D(new Coordinate(2), new Coordinate(1), new Coordinate(2)));
        Ray ray = new Ray(p0,v);

        List<Point3D> intersections = new ArrayList<Point3D>();
        intersections = plane.findInersections(ray);

        assertEquals("",intersections.get(0).toString());***/
        // creating the expected values

        List<Point3D> answerList = new ArrayList<Point3D>();
        Point3D answerPoint = new Point3D(0, 0, -200);
        answerList.add(answerPoint);

        // building the plane

        Point3D directionPoint = new Point3D(0, 0, -1);
        Point3D planePoint = new Point3D(0, 100, -200);

        Vector direction = new Vector(directionPoint);

        Plane plane = new Plane(planePoint, direction);

        // building the ray that will intersect the plane

        Point3D centerPoint = new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(0));
        Vector vector = new Vector(0, 0, -5);
        Ray ray = new Ray(centerPoint, vector);

        // testing the findIntersection function

        List<Point3D> list = new ArrayList<Point3D>();
        list = plane.findIntersections(ray);
        assertEquals(answerList, list);
    }
}