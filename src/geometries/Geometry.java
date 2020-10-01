package geometries;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;
import java.awt.*;

/**
 *  Abstract class for all geometries.
 */

public abstract class Geometry implements IGeometry {

    private Material material = new Material();
    private double nShininess = 1;
    private Color emmission = Color.black;

    public void setShininess(double n) {
        nShininess = n;
    }

    public void setMaterial(Material material) {
        this.material = new Material(material);
    }

    public void setEmmission(Color emmission) {
        this.emmission = new Color(emmission.getRed(), emmission.getGreen(), emmission.getBlue());
    }

    public Color getEmmission() {
        return new Color(emmission.getRed(), emmission.getGreen(), emmission.getBlue());
    }

    public Material getMaterial() {
        return new Material(material);
    }

    public double getShininess() {
        return nShininess;
    }


    public void setKs(double ks) {
        material.setKs(ks);
    }

    public void setKd(double kd) {
        material.setKd(kd);
    }

    public void setKr(double Kr) {
        material.setKr(Kr);
    }

    public void setKt(double Kt) {
        material.setKt(Kt);
    }

    @Override
    public abstract List<Point3D> findIntersections(Ray ray);

    @Override
    public abstract Vector getNormal(Point3D point);
}
