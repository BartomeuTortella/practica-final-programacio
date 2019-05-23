/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treballfinalprogii;

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
    private Vector velocitat;
    private int acceleracio;
    private Ellipse2D.Float cercle;

    public Cercle(Vector posicio) {
        this.diamtre = 40;
        this.color = Color.BLUE;
        this.posicio = posicio;
        System.out.println(posicio);
        this.velocitat = new Vector(3, 3);
        this.acceleracio = 0;
        moureCercle();
    }

    public void moureCercle() {
        this.posicio.suma(this.velocitat);
        calcularDireccio(this.posicio);
    }

    private void calcularDireccio(Vector posicio) {
        if (posicio.getX() == -1 || posicio.getX() == 0 || posicio.getX() == 1) {
            this.velocitat.setX(2);
        } else if (posicio.getX() == 459 || posicio.getX() == 460 || posicio.getX() == 461) {
            this.velocitat.setX(-2);
        }

        if (posicio.getY() == -1 || posicio.getY() == 0 || posicio.getY() == 1) {
            this.velocitat.setY(2);
        } else if (posicio.getY() == 633 || posicio.getY() == 634 || posicio.getY() == 635) {
            this.velocitat.setY(-2);
        }
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

    public Vector getVelocitat() {
        return velocitat;
    }

    public void setVelocitat(Vector velocitat) {
        this.velocitat = velocitat;
    }

    public int getAcceleracio() {
        return acceleracio;
    }

    public void setAcceleracio(int acceleracio) {
        this.acceleracio = acceleracio;
    }

}
