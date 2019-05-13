/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treballfinalprogii;

import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import javafx.scene.paint.Color;

/**
 *
 * @author mery
 */
public class Cercle {

    private int diamtre;
    private Color color;
    private Vector posicio;
    private int velocitat;
    private int acceleracio;
    private Ellipse2D.Float cercle;

    public Cercle(int posició) {
        this.diamtre = diamtre;
        this.color = Color.BLUE;
        this.posicio = posicio;
        this.velocitat = velocitat;
        this.acceleracio = acceleracio;

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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
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
