/*
 * Bartomeu Tortella Garcias i Maria Orell Monserrat
 *
 */
package treballfinalprogii;

import java.util.concurrent.ThreadLocalRandom;

public class Vector {

    //definim els atributs de la classe Vector
    private double x;
    private double y;
    private double modul;

    public Vector(double x, double y) {
        //inicialitzam les variables
        this.x = x;
        this.y = y;
    }

    public void suma(Vector v) {
        //sumam el valor del vector que ens pasen per parametre al vector actual
        this.x += v.getX();
        this.y += v.getY();
    }

    public void resta(Vector v) {
        //restam el valor del vector que ens pasen per parametre al vector actual
        this.x -= v.getX();
        this.y -= v.getY();
    }

    public void multiplicacio(double escalar) {
        //multiplicam el valor del vector que ens pasen per parametre al vector actual
        this.x *= escalar;
        this.y *= escalar;
    }

    public void calcularUnitari() {
        //per calcular el vector unitari, necessitam 1r obtenir el mòdul del vector 
        //i després cridam al mètode de normalitzacio().
        double tmpX = (this.x * this.x);
        double tmpY = (this.y * this.y);
        this.modul = Math.sqrt((tmpX + tmpY));
        this.normalitzacio();
    }

    private void normalitzacio() {
        //Per normalitzar un vector, agafam cada component i les dividim entre el
        //mòdul prèviament calculat del vector inicial.
        this.x = this.x / modul;
        this.y = this.y / modul;
    }

    private static double getMagnitud(Vector v) {
        //Càlcul del mòdul d'un vector
        double tmpX = (v.x * v.x);
        double tmpY = (v.y * v.y);
        double modul = Math.sqrt((tmpX + tmpY));
        return modul;
    }

    public static Vector limit(Vector v, double limit) {
        double magnitud = getMagnitud(v); // calculam la seva magnitud
        //Comprovam si el vector és major que el límit. 
        if (magnitud > limit) { 
            //en cas de que ho sigui
            //calculam el seu unitari
            v.calcularUnitari();
            //multiplicam el vector normalitzat pel limit
            v.multiplicacio(limit);
        }
        //retornam el vector modificat o no
        return v;
    }

    public static Vector generarPosicioAleatoria() {
        // generam un nombre aleatori entre 0 i el marge de x - 100 
        int randomNumX = ThreadLocalRandom.current().nextInt(0, PanellCercles.MARGE_X_PANELL - 100);
        // generam un nombre aleatori entre 0 i el marge de y - 100 
        int randomNumY = ThreadLocalRandom.current().nextInt(0, PanellCercles.MARGE_Y_PANELL - 100);
        //cream un vector amb aquestes posicions aleatories
        Vector vector = new Vector(randomNumX, randomNumY);
        //retornam el vector
        return vector;
    }

    //getters && setters && toString
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
