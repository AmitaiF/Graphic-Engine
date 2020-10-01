
package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

class SphereTest {

    @Test
    void findIntersections() {
        Sphere sp = new Sphere(5, new Point3D(7, 8, 9));
        Ray ray1 = new Ray(new Point3D(0, 0, 0), new Vector(1, 1, 1));
        Ray ray2 = new Ray(new Point3D(0, 0, 0), new Vector(-1, -1, -1));

        Point3D expected = new Point3D(5.231125379027, 5.231125379027, 5.231125379027);

        assertEquals(expected, sp.findIntersections(ray1).get(0));
        assertTrue(sp.findIntersections(ray2).isEmpty());
    }
}
