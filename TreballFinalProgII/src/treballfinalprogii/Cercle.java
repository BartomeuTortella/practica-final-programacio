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
    private Vector velocitatMouse;
    private Vector acceleracioMouse;
    private Ellipse2D.Float cercle;
    private final int velocitatLimit = 10;
    private final int velocitatLimitMouse = 10;
    private final double factorMouse = 0.7;

    public Cercle(Vector posicio) {

        this.diamtre = 40;
        //posam un color aleatori
        this.color = new Color(new Random().nextFloat(), new Random().nextFloat(), new Random().nextFloat());
        this.posicio = posicio;
        //definim una velocitat inicial
        this.velocitat = new Vector(0, 1);
        //definim una velocitat mouse inicial
        this.velocitatMouse = new Vector(0, 0);
        //definim una acceleració inicial
        this.acceleracio = new Vector(0, 0.1);
    }

    private void calcularAcceleracioIPosicioMouse(Vector posicioMouse) {
        // calculam l'acceleracio Segons la posició del Mouse
        this.acceleracioMouse = calcularAcceleracioSegonsMouse(posicioMouse);
        //cridam a comprovar velocitat limit mouse 
        comprovarVelocitatLimitMouse();
    }

    private void comprovarVelocitatLimitMouse() {
        //sumam l'acceleració a la velocitat del mouse
        this.velocitatMouse.suma(this.acceleracioMouse);
        //revisam que la velocitat no superi el límit de velocitat
        this.velocitatMouse = Vector.limit(this.velocitatMouse, this.velocitatLimitMouse);
        //sumam la velocitat a la posició
        this.posicio.suma(velocitatMouse);
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

    public void calcularDireccioRebot() {
        this.posicio.suma(this.velocitat);

        //cirdam a comprovar velocitat limit
        comprovarVelocitatLimit();
        //revisam si hem topat amb la paret esquerra o dreta de l'eix X
        if (this.posicio.getX() < 0 || this.posicio.getX() > (PanellCercles.MARGE_X_PANELL - this.diamtre)) {
            // si es així invertim el signe de la velocitat
            this.velocitat.setX(-this.getVelocitat().getX());
        }
        // revisam si hem topat amb la paret d'adalt o d'abaix de l'eix Y
        if (this.posicio.getY() < 0 || this.posicio.getY() > (PanellCercles.MARGE_Y_PANELL - 60)) {
            // si es així invertim el signe de la velocitat
            this.velocitat.setY(-this.velocitat.getY());
        }
    }

    public void calcularDireccioContinu() {
        this.posicio.suma(this.velocitat);

        //cirdam a comprovar velocitat limit
        comprovarVelocitatLimit();
        //comprovam si hem passat la paret de l'esquerra en l'eix X
        if (this.posicio.getX() < 0 - 100) {
            //  si es aixi passam la pilota a l'altre banda 
            this.posicio.setX(PanellCercles.MARGE_X_PANELL);
            //comprovam si hem passat la paret de la dreta en l'eix X
        } else if (this.posicio.getX() > PanellCercles.MARGE_X_PANELL + 120) {
            //  si es aixi passam la pilota a l'altre banda 
            this.posicio.setX(0);
        }
        //comprovam si hem passat la paret de dalt en l'eix Y
        if (this.posicio.getY() < 0 - 100) {
            //  si es aixi passam la pilota a l'altre banda 
            this.posicio.setY(PanellCercles.MARGE_Y_PANELL);
            //comprovam si hem passat la paret d'abaix en l'eix Y
        } else if (this.posicio.getY() > PanellCercles.MARGE_Y_PANELL) {
            //  si es aixi passam la pilota a l'altre banda 
            this.posicio.setY(-4);
        }

    }

    public void calcularDireccioRebot(Vector posicioMouse) {
        //calculam l'acceleració i la posció segons la posició dels mouse 
        calcularAcceleracioIPosicioMouse(posicioMouse);

        //revisam si hem topat amb la paret esquerra o dreta de l'eix X
        if (this.posicio.getX() < 0 || this.posicio.getX() > (PanellCercles.MARGE_X_PANELL - this.diamtre)) {
            // si es així invertim el signe de la velocitat
            this.velocitatMouse.setX(-this.velocitatMouse.getX());

        }
        // revisam si hem topat amb la paret d'adalt o d'abaix de l'eix Y
        if (this.posicio.getY() < 0 || this.posicio.getY() > (PanellCercles.MARGE_Y_PANELL - (this.diamtre + 20))) {
            // si es així invertim el signe de la velocitat
            this.velocitatMouse.setY(-this.velocitatMouse.getY());
        }
    }

    public void calcularDireccioContinu(Vector posicioMouse) {
        //calculam l'acceleració i la posció segons la posició dels mouse 
        calcularAcceleracioIPosicioMouse(posicioMouse);

        //cirdam a comprovar velocitat limit
        //comprovam si hem passat la paret de l'esquerra en l'eix X
        if (this.posicio.getX() < 0) {
            //  si es aixi passam la pilota a l'altre banda 
            this.posicio.setX(PanellCercles.MARGE_X_PANELL);
            //comprovam si hem passat la paret de la dreta en l'eix X
        } else if (this.posicio.getX() > PanellCercles.MARGE_X_PANELL) {
            //  si es aixi passam la pilota a l'altre banda 
            this.posicio.setX(0);
        }
        //comprovam si hem passat la paret de dalt en l'eix Y
        if (this.posicio.getY() < 0) {
            //  si es aixi passam la pilota a l'altre banda 
            this.posicio.setY(PanellCercles.MARGE_Y_PANELL);
            //comprovam si hem passat la paret d'abaix en l'eix Y
        } else if (this.posicio.getY() > PanellCercles.MARGE_Y_PANELL) {
            //  si es aixi passam la pilota a l'altre banda 
            this.posicio.setY(0);
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
        tmpMouse.calcularUnitari();
        tmpMouse.multiplicacio(this.factorMouse);
        return tmpMouse;
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
