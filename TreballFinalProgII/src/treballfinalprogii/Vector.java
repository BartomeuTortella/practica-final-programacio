package treballfinalprogii;

import java.util.Random;

/**
 * Classe vector
 *
 * @author miquelmascarooliver
 */
public class Vector {

    /**
     * Un vector és una col·lecció de doubles
     *
     * @param dimensio del vector
     */
    private double x[];

    /**
     * Excepció que s'aixeca quan no es pot fer una operació entre dos vectors
     */
    public static class rangsinconsistents extends Exception {

        public rangsinconsistents(String s) {
            super(s); //super és la paraula reservada de java i amb el paràmetre que li passam a super, el mètode farà lo mateix 
            //amb el paràmetre que el que fa el seu predecessor. en aquest cas el predecessor és Exception i lo que provoca tot això
            // és que quan es produeixi la excepció rangsinconsistents, el missatge que s'imprimirà serà el núm. "s".
        }
    }

    /**
     * El vector es construeix buit indicant la dimensió
     *
     * @param dimensio
     */
    public Vector(int dimensio) {
        this.x = new double[dimensio];
    }

    /**
     * Retorna la llargaria del vector
     *
     * @return
     */
    public int getDimensio() {
        return x.length;
    }

    @Override
    public String toString() {
        String s = "(";
        for (int i = 0; i < x.length; i++) {
            s += x[i] + " ";
        }
        return s + ")";
    }

    /**
     * Retorna el mòdul o norma del vector
     *
     * @return
     */
    public double modul() {
        double s = 0;
        for (int i = 0; i < x.length; i++) {
            s += x[i] * x[i];
        }
        return Math.sqrt(s);
    }

    /**
     * Assigna a la posició i el valor x
     *
     * @param i
     * @param x
     */
    public void setValor(int i, double x) {
        this.x[i] = x;
    }

    /**
     * Emplena el vector amb valors aleatòris enters entre 0 i vsup
     *
     * @param vsup
     */
    public void ompleAleatori(int vsup) {
        Random rnd = new Random();
        for (int i = 0; i < this.x.length; i++) {
            this.x[i] = rnd.nextInt(vsup);
        }
    }

    //Lo que ve aquí abaix és la documentació que es genera amb JavaDoc. Es fa quan poses: /**
    /**
     * Producte escalar de dos vectors
     * @param v
     * @return
     * @throws pkg135_operacionsmatrius.Vector.rangsinconsistents 
     */
    
    //Mètode que s'aplica a un vector i té com a paràmetre un altre vector.
    //Primer verificam amb un condicional si les dimensions dels 2 vectors coincideixen.
    public double prodEscalar(Vector v) throws rangsinconsistents {
        if (this.x.length != v.x.length) { //Si no són iguals, activam l'excepció.
            throw new rangsinconsistents("Rangs inconsistents");
        }
        double s = 0;
        for (int i = 0; i < this.x.length; i++) {
            s += this.x[i] * v.x[i];
        }
        return s;
    }

}
