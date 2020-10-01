package primitives;

/**
 * Material for objects. defines diffuse, specular, shininess, reflection and refraction components factors.
 */

public class Material {

    private double _Kd; //diffuse component factor
    private double _Ks; //specular component factor

    private int _nShininess; //shininess component factor

    private double _Kr; //reflection component factor
    private double _Kt; //refraction component factor

    /**
     * Default constructor. sets Kd and Ks to 1, shininess to 20, and Kr and Kt to 0.
     */
    public Material() {
        this.set_Kd(1);
        this.set_Ks(1);
        this.set_nShininess(20);
        this.set_Kr(0);
        this.set_Kt(0);
    }

    /**
     * Constructor that set values by user parameters.
     * @param _Kd diffuse component factor.
     * @param _Ks specular component factor.
     * @param _nShininess shininess component factor.
     * @param _Kr reflection component factor.
     * @param _Kt refraction component factor.
     */
    public Material(double _Kd, double _Ks, int _nShininess, double _Kr, double _Kt) {
        this.set_Kd(_Kd);
        this.set_Ks(_Ks);
        this.set_nShininess(_nShininess);
        this.set_Kr(_Kr);
        this.set_Kt(_Kt);
    }

    /**
     * Copy constructor.
     * @param other the object to copy from.
     */
    public Material(Material other){
        this.set_Kd(other._Kd);
        this.set_Ks(other._Ks);
        this.set_nShininess(other._nShininess);
        this.set_Kr(other._Kr);
        this.set_Kt(other._Kt);
    }

    public void setKd(double _Kd) {
        this.set_Kd(_Kd);
    }

    public void setKs(double _Ks) {
        this.set_Ks(_Ks);
    }

    public void setnShininess(int _nShininess) {
        this.set_nShininess(_nShininess);
    }

    public void setKr(double _Kr) {
        this.set_Kr(_Kr);
    }

    public void setKt(double _Kt) {
        this.set_Kt(_Kt);
    }

    public double getKd() {
        return get_Kd();
    }

    public double getKs() {
        return get_Ks();
    }

    public int getnShininess() {
        return get_nShininess();
    }

    public double getKr() {
        return get_Kr();
    }

    public double getKt() {
        return get_Kt();
    }

    public double get_Kd() {
        return _Kd;
    }

    public void set_Kd(double _Kd) {
        this._Kd = _Kd;
    }

    public double get_Ks() {
        return _Ks;
    }

    public void set_Ks(double _Ks) {
        this._Ks = _Ks;
    }

    public int get_nShininess() {
        return _nShininess;
    }

    public void set_nShininess(int _nShininess) {
        this._nShininess = _nShininess;
    }

    public double get_Kr() {
        return _Kr;
    }

    public void set_Kr(double _Kr) {
        this._Kr = _Kr;
    }

    public double get_Kt() {
        return _Kt;
    }

    public void set_Kt(double _Kt) {
        this._Kt = _Kt;
    }
}
