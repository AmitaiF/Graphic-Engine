package elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * A camera that construct rays through pixels.
 */

public class Camera {

    Point3D position;
    Vector vUp, vRight, vToward;

    /**
     * Constructor with position, vUp and vTo. calculate Vright.
     * @param _position position of the camera.
     * @param _vUp vector that defines what is "UP" relative to the camera.
     * @param _vToward vector that defines what is "TOWARD" relative to the camera.
     */
    public Camera(Point3D _position, Vector _vUp, Vector _vToward) {
        if (_vToward.dotProduct(_vUp) != 0) // the vectors don't orthogonal
            throw new IllegalArgumentException("the vectors don't orthogonal");
        if (_vToward.length() != 1) // the vector doesn't normalized.
            _vToward = _vToward.normalize(); // normalize
        if (_vUp.length() != 1) // the vector doesn't normalized.
            _vUp = _vUp.normalize(); // normalize

        this.position = _position;
        this.vUp = _vUp;
        this.vToward = _vToward;
        this.vRight = _vToward.crossProduct(_vUp); // calculating vRight.
        vRight = vRight.normalize();
    }

    public Point3D getPosition() {
        return position;
    }

    public Vector getvUp() {
        return vUp;
    }

    public Vector getvRight() {
        return vRight;
    }

    public Vector getvToward() {
        return vToward;
    }

    public String toString() {
        return "Vto: " + vToward + "\n" + "Vup: " + vUp + "\n" + "Vright:" + vRight + ".";
    }

    /**
     * Construct ray through a specific pixel.
     * @param Nx number of x pixels.
     * @param Ny number of y pixels.
     * @param x the x component of the pixel we want a ray to.
     * @param y the y component of the pixel we want a ray to.
     * @param screenDist the distance between the view plane and the objects.
     * @param screenWidth the screen width.
     * @param screenHeight the screen height.
     * @return a ray that starts at the camera and points to the specific pixel.
     */
    public Ray constructRayThroughPixel(int Nx, int Ny, double x, double y, double screenDist, double screenWidth, double screenHeight) {
        if (screenDist <= 0)
            throw new IllegalArgumentException("screen distant must be greater than 0!");
        Point3D pCenter = new Point3D(getPosition().addVector(getvToward().scale(screenDist))); // the center of the view plane
        double Rx = screenWidth / Nx; // size of x pixel.
        double Ry = screenHeight / Ny; // size of y pixel.
        double vRightScaler = (x - Nx / 2) * Rx + (Rx / 2); // calculate times to move right on the view plane
        double vUpScaler = (y - Ny / 2) * Ry + (Ry / 2); // calculate times to move up on the view plane
        Vector v1 = new Vector(getvRight().scale(vRightScaler)); // vector that scaled with the right scalar.
        Vector v2 = new Vector(getvUp().scale(vUpScaler)); // vector that scaled with the up scalar.
        v1.add(v2.scale(-1)); // add them together
        Point3D p = new Point3D(pCenter.addVector(new Vector(v1))); // the pixel point, by adding the vector to pCenter.
        Vector direction = new Vector(p); // make vector direction from the pixel point

        Ray rayToPixel = new Ray(getPosition(), direction); // make ray with the point and direction.

        return rayToPixel; // return ray
    }
}
