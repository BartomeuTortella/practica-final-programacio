/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treballfinalprogii;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 *
 * @author mery
 */
public class Cercle {

    private int diamtre;
    private Color color;
    private Vector posicio;
    private Vector velocitat;
    private Vector acceleracio;
    private Ellipse2D.Float cercle;

    public Cercle(Vector posicio) {
        this.diamtre = 40;
        this.color = new Color(new Random().nextFloat(), new Random().nextFloat(), new Random().nextFloat());
        this.posicio = posicio;
        this.velocitat = new Vector(5, 0);
        this.acceleracio = new Vector(0, 0.1);
        //sera cte (0,1) cap avall
        //a cada pas de temps a la velocitat li sum lacceleracio, a cada pas de temps calculare la posicio segons la v q dugui + acceleracio
        //velocitat ha de tenir un limit de velocitat i quan hi arribi, es manendra = velocitat es velocitat + acceleracio i si arribaa a limit satura
        //he de programar dsps si hi ha intereaccio amb ratoli
        //en es metode de calcular la nova pos del cercle hi ha cond de si he de seguir o no el ratoli
        //si no, ja se com ferho: cte que ha de caure
        //si hi ha ratoli: tenc el cercle a una pos i el ratoli que esta a una altra respecte de (0,=), he de restar akests dos vectors i tenc vector dacceleracio
        //quan tenc akest super vector, lhe de normalitzar, i ara l'he de multiplicar per un factor i aixi aqueda visuatlment bé
        this.moureCercle(false);
    }

    public void moureCercle(boolean teLimits) {
        this.posicio.suma(this.velocitat);
        calcularDireccio(teLimits);
    }

    private void calcularDireccio(boolean teLimits) {
        if (teLimits) {
            this.calcularDireccioRebot();
        } else {
            this.calcularDireccioContinu();
        }
    }

    private void comprovarAcceleracioLimit() {
        Vector velocitatAmbNovaAcceleracio = calcularVelocitat();
        if (this.velocitat.getX() < 10) {
            this.velocitat.setX(velocitatAmbNovaAcceleracio.getX());
        }
        if (this.velocitat.getY() < 10) {
            this.velocitat.setY(velocitatAmbNovaAcceleracio.getY());
        }
    }

    private void calcularDireccioRebot() {
        comprovarAcceleracioLimit();
        //////////////////////////////////////////////////
        if (this.posicio.getX() >= -6 && this.posicio.getX() <= 3) {
            this.velocitat.setX(-this.getVelocitat().getX());
        } else if (this.posicio.getX() >= 458 && posicio.getX() <= 492) {
            this.velocitat.setX(-this.velocitat.getX());
        }
        if (this.posicio.getY() >= -6 && this.posicio.getY() <= 3) {
            this.velocitat.setY(-this.velocitat.getY());
        } else if (this.posicio.getY() >= 630 && this.posicio.getY() <= 637) {
            this.velocitat.setY(-this.velocitat.getY());
        }
    }

    private void calcularDireccioContinu() {
        comprovarAcceleracioLimit();
        if (this.posicio.getX() >= -10 && this.posicio.getX() <= -5) {
            this.posicio.setX(490);
        } else if (this.posicio.getX() >= 495 && this.posicio.getX() <= 505) {
            this.posicio.setX(-4);
        }

        if (this.posicio.getY() >= -10 && this.posicio.getY() <= -5) {
            this.posicio.setY(632);
        } else if (this.posicio.getY() >= 685 && this.posicio.getY() <= 695) {
            this.posicio.setY(-4);
        }

    }

    private Vector calcularVelocitat() {
        Vector velocitatTemp = new Vector(0, 0);
        if (this.velocitat.getX() > 0) {
            velocitatTemp.setX((this.velocitat.getX() + this.acceleracio.getX()));
        } else {
            velocitatTemp.setX((this.velocitat.getX() + this.acceleracio.getX()));
        }

        if (this.velocitat.getY() > 0) {
            velocitatTemp.setY((this.velocitat.getY() + this.acceleracio.getY()));
        } else {
            velocitatTemp.setY((this.velocitat.getY() + this.acceleracio.getY()));
        }
        return velocitatTemp;
    }

    public void pintarCercle(Graphics g) {
        g.setColor(this.color); //definim color de la bolla
        //pintam la bolla
        g.fillOval(
                ((Double) this.posicio.getX()).intValue(),
                ((Double) this.posicio.getY()).intValue(),
                this.diamtre,
                this.diamtre);
        g.setColor(Color.BLACK); //definim el color del costat
        //pintam el costat
        g.drawOval(
                ((Double) this.posicio.getX()).intValue(),
                ((Double) this.posicio.getY()).intValue(),
                this.diamtre,
                this.diamtre);
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

    public Vector getAcceleracio() {
        return acceleracio;
    }

    public void setAcceleracio(Vector acceleracio) {
        this.acceleracio = acceleracio;
    }

}
