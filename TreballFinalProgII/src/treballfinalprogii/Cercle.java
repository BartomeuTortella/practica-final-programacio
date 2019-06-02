/*
 * Bartomeu Tortella Garcias i Maria Orell Monserrat
 *
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
    private Vector acceleracioMouse;
    private Ellipse2D.Float cercle;
    private final int velocitatLimit = 10;

    public Cercle(Vector posicio) {
        this.diamtre = 40;
        this.color = new Color(new Random().nextFloat(), new Random().nextFloat(), new Random().nextFloat());
        this.posicio = posicio;
        this.velocitat = new Vector(0, 1);
        this.acceleracio = new Vector(0.01, 0.1);
        //si hi ha ratoli: tenc el cercle a una pos i el ratoli que esta a una altra respecte de (0,=), he de restar akests dos vectors i tenc vector dacceleracio
        //quan tenc akest super vector, lhe de normalitzar, i ara l'he de multiplicar per un factor i aixi aqueda visuatlment bé
        this.moureCercle(false, false, null);
    }

    public void moureCercle(boolean teLimits, boolean seguirRatoli, Vector posicioMouse) {
        if (seguirRatoli) {
//agafam un cercle i cridam al metode q ens calcula la seva accleracio provocada pel mouse
//acceleracio mouse: sera restar vectorPosMouse - PosBolla ----> normalitzam ---> mult per factor
//adjudicam a la bolla la seva nova pos--> pos anterior bolla + acceleracio
            this.acceleracioMouse = calcularAcceleracioSegonsMouse(posicioMouse);
            calcularPosicioAmbMouse();

        } else {
            this.posicio.suma(this.velocitat);
            calcularDireccio(teLimits);

        }
    }

    private void calcularDireccio(boolean teLimits) {
        if (teLimits) {
            this.calcularDireccioRebot();
        } else {
            this.calcularDireccioContinu();
        }
    }

    private void comprovarVelocitatLimit() {
        Vector velocitatAmbNovaAcceleracio = calcularVelocitat();
        if (this.velocitat.getX() < this.velocitatLimit) {
            this.velocitat.setX(velocitatAmbNovaAcceleracio.getX());
        }
        if (this.velocitat.getY() < this.velocitatLimit) {
            this.velocitat.setY(velocitatAmbNovaAcceleracio.getY());
        }
    }

    //parets
    private void calcularDireccioRebot() {
        comprovarVelocitatLimit();
        if (this.posicio.getX() < 0) {
            this.velocitat.setX(-this.getVelocitat().getX());
        } else if (this.posicio.getX() > (Panell.margeXPanellCercles - this.diamtre)) {
            this.velocitat.setX(-this.velocitat.getX());
        }
        if (this.posicio.getY() < 0) {
            this.velocitat.setY(-this.velocitat.getY());
        } else if (this.posicio.getY() > (Panell.margeYPanellCercles - 60)) {
            this.velocitat.setY(-this.velocitat.getY());
        }
    }

    private void calcularDireccioContinu() {
        comprovarVelocitatLimit();
        if (this.posicio.getX() < 0 - 100) {
            this.posicio.setX(Panell.margeXPanellCercles);
        } else if (this.posicio.getX() > Panell.margeXPanellCercles + 120) {
            this.posicio.setX(0);
        }

        if (this.posicio.getY() < 0 - 100) {
            this.posicio.setY(Panell.margeYPanellCercles);
        } else if (this.posicio.getY() > Panell.margeYPanellCercles) {
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

    private Vector calcularAcceleracioSegonsMouse(Vector posicioMouse) {
        Vector tmpMouse = posicioMouse;
        tmpMouse.resta(this.posicio);
//        System.out.println("resultat resta:" + posicioMouse);
        tmpMouse.calcularUnitari();
//        System.out.println("resultat unitari:" + posicioMouse);
        tmpMouse.multiplicacio(new Vector(10, 10));

        return tmpMouse;
    }

    private void calcularPosicioAmbMouse() {
        this.posicio.suma(this.acceleracioMouse);
//        System.out.println("resultat suma: " + this.posicio);
    }

    //Direccio i velocitat amb mouse
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

    public Vector getAcceleracioMouse() {
        return acceleracioMouse;
    }

    public void setAcceleracioMouse(Vector acceleracioMouse) {
        this.acceleracioMouse = acceleracioMouse;
    }

}
