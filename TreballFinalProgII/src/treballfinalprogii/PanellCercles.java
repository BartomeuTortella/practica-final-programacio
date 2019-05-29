/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treballfinalprogii;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author mery
 */
public class PanellCercles extends JPanel {

    private Cercle[] cercles;
    private boolean teLimits = false;

    public PanellCercles() {
        this.cercles = crearCercles(5);
        comencarJoc(); //aixo millor si ho crida la classe Panell
    }

    private Cercle[] crearCercles(int numCercles) {
        Cercle[] cercles = new Cercle[numCercles];
        for (int i = 0; i < numCercles; i++) {
            cercles[i] = new Cercle(Vector.generarPosicioAleatoria());
        }
        return cercles;
    }

    private void comencarJoc() {
        Thread gameThread = new Thread() { //aixo millor llevar-ho, per emprar nomes el fil de propi progrmaa primcila
            //al main de la classe main he de cridar akest metode perque tot se posi enmarxa (amb el while true)
            public void run() { //fora
                while (true) {
                    repaint();
                    try {
                        Thread.sleep(1000 / 30);  // milliseconds
                    } catch (InterruptedException ex) {
                        System.out.println(ex);
                    }
                }
            }
        };
        gameThread.start();  // Callback run() //tb sen ha danar
    }

    public boolean teLimits() {
        return teLimits;
    }

    public void setTeLimits(boolean teLimits) {
        this.teLimits = teLimits;
    }

    @Override

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        // Draw the box
        g.setColor(java.awt.Color.LIGHT_GRAY);
        g.fillRect(0, 0, 500, 700);
        // Draw the ball
        for (int i = 0; i < cercles.length; i++) {
            //g.fillOval(cercle.getPosicio().getX(), cercle.getPosicio().getY(), cercle.getDiamtre(), cercle.getDiamtre());
            cercles[i].moureCercle();
            calcularDireccio(cercles[i]);
            //millor si tot lo de pintar els cercles ho feim al a classe cercle i aixi queda aqui més net
            cercles[i].pintarCercle(g);

        }

    }

    private void calcularDireccio(Cercle cercle) {
        if (this.teLimits) {
            this.calcularDireccioRebot(cercle.getPosicio(), cercle);
        } else {
            this.calcularDireccioContinu(cercle.getPosicio(), cercle);
        }
    }

    private void comprovarAcceleracioLimit(Cercle cercle) {
        Vector velocitatAmbNovaAcceleracio = calcularVelocitat(cercle);
        if (cercle.getVelocitat().getX() < 10) {
            cercle.getVelocitat().setX(velocitatAmbNovaAcceleracio.getX());
        }
        if (cercle.getVelocitat().getY() < 10) {
            cercle.getVelocitat().setY(velocitatAmbNovaAcceleracio.getY());
        }
    }

    private void calcularDireccioRebot(Vector posicio, Cercle cercle) {
        comprovarAcceleracioLimit(cercle);
        //////////////////////////////////////////////////
        if (posicio.getX() >= -3 && posicio.getX() <= 3) {
            cercle.getVelocitat().setX(-cercle.getVelocitat().getX());
        } else if (posicio.getX() >= 458 && posicio.getX() <= 463) {
            cercle.getVelocitat().setX(-cercle.getVelocitat().getX());
        }
        if (posicio.getY() >= -3 && posicio.getY() <= 3) {
            cercle.getVelocitat().setY(-cercle.getVelocitat().getY());
        } else if (posicio.getY() >= 630 && posicio.getY() <= 637) {
            cercle.getVelocitat().setY(-cercle.getVelocitat().getY());
        }
    }

    private void calcularDireccioContinu(Vector posicio, Cercle cercle) {
        comprovarAcceleracioLimit(cercle);
        if (posicio.getX() >= -10 && posicio.getX() <= -5) {
            cercle.getPosicio().setX(490);
        } else if (posicio.getX() >= 495 && posicio.getX() <= 505) {
            cercle.getPosicio().setX(-4);
        }

        if (posicio.getY() >= -10 && posicio.getY() <= -5) {
            cercle.getPosicio().setY(632);
        } else if (posicio.getY() >= 685 && posicio.getY() <= 695) {
            cercle.getPosicio().setY(-4);
        }

    }

    private Vector calcularVelocitat(Cercle cercle) {
        Vector velocitatTemp = new Vector(0, 0);
        if (cercle.getVelocitat().getX() > 0) {
            velocitatTemp.setX((cercle.getVelocitat().getX() + cercle.getAcceleracio().getX()));
        } else {
            velocitatTemp.setX((cercle.getVelocitat().getX() + cercle.getAcceleracio().getX()));
        }

        if (cercle.getVelocitat().getY() > 0) {
            velocitatTemp.setY((cercle.getVelocitat().getY() + cercle.getAcceleracio().getY()));
        } else {
            velocitatTemp.setY((cercle.getVelocitat().getY() + cercle.getAcceleracio().getY()));
        }
        return velocitatTemp;
    }
}
