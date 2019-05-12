/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treballfinalprogii;

import java.awt.geom.Ellipse2D;

/**
 *
 * @author mery
 */
public class Cercle {

    private int diamtre;
    private String color;
    private Vector posicio;
    private int velocitat;
    private int acceleracio;
    private Ellipse2D.Float cercle;

    public Cercle(int posició) {
        this.diamtre = diamtre;
        this.color = color;
        this.posicio = posicio;
        this.velocitat = velocitat;
        this.acceleracio = acceleracio;
        this.cercle = new Ellipse2D.Float(posició, posició, 500, 500);

    }

    public Ellipse2D.Float getCercle() {
        return cercle;
    }
    

    public int getDiamtre() {
        return diamtre;
    }

    public void setDiamtre(int diamtre) {
        this.diamtre = diamtre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Vector getPosicio() {
        return posicio;
    }

    public void setPosicio(Vector posicio) {
        this.posicio = posicio;
    }

    public int getVelocitat() {
        return velocitat;
    }

    public void setVelocitat(int velocitat) {
        this.velocitat = velocitat;
    }

    public int getAcceleracio() {
        return acceleracio;
    }

    public void setAcceleracio(int acceleracio) {
        this.acceleracio = acceleracio;
    }

}
