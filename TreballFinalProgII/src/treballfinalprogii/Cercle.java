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

    //declaració dels atributs de la classe Cercle
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
        //posam un color aleatori
        this.color = new Color(new Random().nextFloat(), new Random().nextFloat(), new Random().nextFloat());
        this.posicio = posicio;
        //definim una velocitat inicial
        this.velocitat = new Vector(0, 1);
        //definim una acceleració inicial
        this.acceleracio = new Vector(-0.01, 0.1);
    }

    public void moureCercle(boolean teLimits, boolean seguirRatoli, Vector posicioMouse) {
        if (seguirRatoli) {
            //agafam un cercle i cridam al metode q ens calcula la seva accleracio provocada pel mouse
            //acceleracio mouse: sera restar vectorPosMouse - PosBolla ----> normalitzam ---> mult per factor
            //adjudicam a la bolla la seva nova pos--> pos anterior bolla + acceleracio
            this.acceleracioMouse = calcularAcceleracioSegonsMouse(posicioMouse);
            calcularPosicioAmbMouse();

        } else {
            //sumam la velociatat a la posicio
            this.posicio.suma(this.velocitat);
            //cridam calcular direcció i passam per parametres si te limits o no
            calcularDireccio(teLimits);

        }
    }

    private void calcularDireccio(boolean teLimits) {
        //miram si té limits 
        if (teLimits) {
            this.calcularDireccioRebot();
        } else {
            this.calcularDireccioContinu();
        }
    }

    private void comprovarVelocitatLimit() {
        //metode per comprovar si s'ha arribat a la velocitat limit
        //calculam la nova velocitat
        Vector velocitatAmbNovaAcceleracio = calcularVelocitat();
        //miram si hem arribat a la velocitat limit en l'eix X
        if (this.velocitat.getX() < this.velocitatLimit) {
            //en cas de que no sigui així posam la nova velocitat 
            this.velocitat.setX(velocitatAmbNovaAcceleracio.getX());
        }
        //miram si hem arribat a la velocitat limit en l'eix Y
        if (this.velocitat.getY() < this.velocitatLimit) {
            //en cas de que no sigui així posam la nova velocitat 
            this.velocitat.setY(velocitatAmbNovaAcceleracio.getY());
        }
    }

    private void calcularDireccioRebot() {
        //cirdam a comprovar velocitat limit
        comprovarVelocitatLimit();
        //revisam si hem topat amb la paret esquerra o dreta de l'eix X
        if (this.posicio.getX() < 0 || this.posicio.getX() > (PanellCercles.margeX - this.diamtre)) {
            // si es així invertim el signe de la velocitat
            this.velocitat.setX(-this.getVelocitat().getX());
        }
        // revisam si hem topat amb la paret d'adalt o d'abaix de l'eix Y
        if (this.posicio.getY() < 0 || this.posicio.getY() > (PanellCercles.margeY - 60)) {
            // si es així invertim el signe de la velocitat
            this.velocitat.setY(-this.velocitat.getY());
        }
    }

    private void calcularDireccioContinu() {
        //cirdam a comprovar velocitat limit
        comprovarVelocitatLimit();
        //comprovam si hem passat la paret de l'esquerra en l'eix X
        if (this.posicio.getX() < 0 - 100) {
            //  si es aixi passam la pilota a l'altre banda 
            this.posicio.setX(PanellCercles.margeX);
            //comprovam si hem passat la paret de la dreta en l'eix X
        } else if (this.posicio.getX() > PanellCercles.margeX + 120) {
            //  si es aixi passam la pilota a l'altre banda 
            this.posicio.setX(0);
        }
        //comprovam si hem passat la paret de dalt en l'eix Y
        if (this.posicio.getY() < 0 - 100) {
            //  si es aixi passam la pilota a l'altre banda 
            this.posicio.setY(PanellCercles.margeY);
            //comprovam si hem passat la paret d'abaix en l'eix Y
        } else if (this.posicio.getY() > PanellCercles.margeY) {
            //  si es aixi passam la pilota a l'altre banda 
            this.posicio.setY(-4);
        }

    }

    private Vector calcularVelocitat() {
        //crema un vector temporal de velocitat
        Vector velocitatTemp = new Vector(0, 0);
        //sumam aceleració a les velocitats
        velocitatTemp.setX((this.velocitat.getX() + this.acceleracio.getX()));
        velocitatTemp.setY((this.velocitat.getY() + this.acceleracio.getY()));
        //retornam el vector temporal
        return velocitatTemp;
    }

    private Vector calcularAcceleracioSegonsMouse(Vector posicioMouse) {
        Vector tmpMouse = new Vector(posicioMouse.getX(), posicioMouse.getY());
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

    //getters && setters
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
