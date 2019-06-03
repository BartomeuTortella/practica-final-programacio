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

    public void multiplicacio(Vector v) {
        //multiplicam el valor del vector que ens pasen per parametre al vector actual
        this.x *= v.getX();
        this.y *= v.getY();
    }

    public void calcularUnitari() {
        //no se si esta bé per tant no coment 
        double tmpX = (this.x * this.x);
        double tmpY = (this.y * this.y);
        this.modul = Math.sqrt((tmpX + tmpY));
        this.normalitzacio();
    }

    private void normalitzacio() {
        //no se si esta bé per tant no coment 
        this.x = this.x / modul;
        this.y = this.y / modul;
    }

    public static Vector generarPosicioAleatoria() {
        // generam un nombre aleatori entre 0 i el marge de x - 100 
        int randomNumX = ThreadLocalRandom.current().nextInt(0, PanellCercles.margeX - 100);
        // generam un nombre aleatori entre 0 i el marge de y - 100 
        int randomNumY = ThreadLocalRandom.current().nextInt(0, PanellCercles.margeY - 100);
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
