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
        //this.color = Color.BLUE;
        this.color= new Color (new Random().nextFloat(),new Random().nextFloat(), new Random().nextFloat());
        this.posicio = posicio;
        this.velocitat = new Vector(0, 6);
        this.acceleracio = new Vector(0, 0.01);
        //sera cte (0,1) cap avall
        //a cada pas de temps a la velocitat li sum lacceleracio, a cada pas de temps calculare la posicio segons la v q dugui + acceleracio
        //velocitat ha de tenir un limit de velocitat i quan hi arribi, es manendra = velocitat es velocitat + acceleracio i si arribaa a limit satura
        //he de programar dsps si hi ha intereaccio amb ratoli
        //en es metode de calcular la nova pos del cercle hi ha cond de si he de seguir o no el ratoli
        //si no, ja se com ferho: cte que ha de caure
        //si hi ha ratoli: tenc el cercle a una pos i el ratoli que esta a una altra respecte de (0,=), he de restar akests dos vectors i tenc vector dacceleracio
        //quan tenc akest super vector, lhe de normalitzar, i ara l'he de multiplicar per un factor i aixi aqueda visuatlment bé
        this.moureCercle();
    }

    public void moureCercle() {
        this.posicio.suma(this.velocitat);
        calcularDireccio(this.posicio);
    }

    private void calcularDireccio(Vector posicio) {
        calcularDireccioRebot(posicio);
    }

    private void calcularDireccioRebot(Vector posicio) {
        Vector velocitatAmbNovaAcceleracio = calcularVelocitat(this.velocitat);
        if (this.velocitat.getX() < 6) {
            this.velocitat.setX(velocitatAmbNovaAcceleracio.getX());
        }
        if (this.velocitat.getY() < 6) {
            this.velocitat.setY(velocitatAmbNovaAcceleracio.getY());
        }
        System.out.println(posicio);

        if (posicio.getX() >= -3 && posicio.getX() <= 3) {
            System.out.println("test 1 x");
            this.velocitat.setX(-this.velocitat.getX());
        } else if (posicio.getX() >= 458 && posicio.getX() <= 463) {
            System.out.println("test 2 x");
            this.velocitat.setX(-this.velocitat.getX());
        }
        if (posicio.getY() >= -3 && posicio.getY() <= 3) {
            System.out.println("test 1 y");
            this.velocitat.setY(-this.velocitat.getY());
        } else if (posicio.getY() >= 630 && posicio.getY() <= 637) {
            System.out.println("test 2 y");
            this.velocitat.setY(-this.velocitat.getY());
        }
    }

    private void calcularDireccioContinu(Vector posicio) {
        if (posicio.getX() == -7 || posicio.getX() == -6 || posicio.getX() == -5) {
            this.posicio.setX(458);
        } else if (posicio.getX() == 499 || posicio.getX() == 500 || posicio.getX() == 501) {
            this.posicio.setX(0);
        }

        if (posicio.getY() == -1 || posicio.getY() == 0 || posicio.getY() == 1) {
            this.posicio.setY(632);
        } else if (posicio.getY() == 689 || posicio.getY() == 690 || posicio.getY() == 691) {
            this.posicio.setY(0);
        }

    }

    private Vector calcularVelocitat(Vector velocitat) {
        Vector velocitatTemp = velocitat;
        if (velocitatTemp.getX() > 0) {
            velocitatTemp.setX((velocitatTemp.getX() + this.acceleracio.getX()));
        } else {
            velocitatTemp.setX((velocitatTemp.getX() + this.acceleracio.getX()));
        }

        if (velocitatTemp.getY() > 0) {
            velocitatTemp.setY((velocitatTemp.getY() + this.acceleracio.getY()));
        } else {
            velocitatTemp.setY((velocitatTemp.getY() + this.acceleracio.getY()));
        }
        return velocitatTemp;
    }

    public void pintarCercle(Graphics g) {
        g.setColor(this.color);
        //g.setColor(Color.YELLOW); //definim color de la bolla
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
