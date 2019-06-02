/*
 * Bartomeu Tortella Garcias i Maria Orell Monserrat
 *
 */
package treballfinalprogii;

import java.util.concurrent.ThreadLocalRandom;

public class Vector {

    private double x;
    private double y;
    private double modul;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void suma(Vector v) { //tb ho puc fer com public Vector Suma (Vector v){ i acabar amb un "return this"}
        this.x += v.getX();
        this.y += v.getY();
    }

    public void resta(Vector v) {
        this.x -= v.getX();
        this.y -= v.getY();
    }

    public void multiplicacio(Vector v) {
        this.x *= v.getX();
        this.y *= v.getY();
    }

    //CANVIAR NOM
    //Normalitzar vector --> fer-lo unitari. Hem de fer el mòdul (arrel quadrada de sumar elements vector al quadrat); 
    // i dividim cada element pel modul.
    public void calcularUnitari() {
        double tmpX = (this.x * this.x);
        double tmpY = (this.y * this.y);
        this.modul = Math.sqrt((tmpX + tmpY));
        this.normalitzacio();
    }

    private void normalitzacio() {
        this.x = this.x / modul;
        this.y = this.y / modul;
    }

    public static Vector generarPosicioAleatoria() { //aixo ha d'estar a la classe vector .

        int randomNumX = ThreadLocalRandom.current().nextInt(0, 460 + 1);
        int randomNumY = ThreadLocalRandom.current().nextInt(0, 634 + 1);
        Vector vector = new Vector(randomNumX, randomNumY);
        return vector;
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

    @Override
    public String toString() {
        return "Vector{" + "x=" + x + ", y=" + y + '}';
    }

}
