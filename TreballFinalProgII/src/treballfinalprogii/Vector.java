package treballfinalprogii;

public class Vector {

    private double x;
    private double y;
    private double modul;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void suma(Vector v) { //tb ho puc fer com public Vector Suma (Vector v){ i acabar amb un "return this"}
        x += v.getX();
        y += v.getY();
    }

    public void resta(Vector v) {
        x -= v.getX();
        y -= v.getY();
    }

    //Normalitzar vector --> fer-lo unitari. Hem de fer el mòdul (arrel quadrada de sumar elements vector al quadrat); 
    // i dividim cada element pel modul.
    public void calcularModul(Vector v) {
        double sumaComponentsAlQuadrat = (v.x * v.x) + (v.y * v.y);
        this.modul = Math.sqrt(sumaComponentsAlQuadrat);
        this.normalitzacio(v);
    }

    private void normalitzacio(Vector v) {
        x = v.x / modul;
        y = v.y / modul;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getModul() {
        calcularModul(this);
        return modul;
    }

    public void setModul(double modul) {
        this.modul = modul;
    }

    @Override
    public String toString() {
        return "Vector{" + "x=" + x + ", y=" + y + '}';
    }

}
