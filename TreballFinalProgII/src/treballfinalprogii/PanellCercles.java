/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treballfinalprogii;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author mery
 */
public class PanellCercles extends JPanel {

    private Cercle[] cercles;
    private boolean teLimits = false;

    public PanellCercles(int numeroBolles) {
        this.cercles = crearCercles(numeroBolles);
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
//        try {
//
//            Thread.sleep(1);
//            repaint();
//
//        } catch (InterruptedException ex) {
//            Logger.getLogger(PanellCercles.class.getName()).log(Level.SEVERE, null, ex);
//        }

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
        }
    }

    public boolean teLimits() {
        return teLimits;
    }

    public void setTeLimits(boolean teLimits) {
        this.teLimits = teLimits;
    }

    public void setNumeroBolles(int numeroBolles) {
        this.cercles = crearCercles(numeroBolles);
    }

    @Override 
    public void paintComponent(Graphics g) {
        System.out.println("paint");
        Graphics2D g2d = (Graphics2D) g;
        // Draw the box
        g.setColor(java.awt.Color.LIGHT_GRAY);
        g.fillRect(0, 0, 500, 700);
        // Draw the ball
        for (int i = 0; i < cercles.length; i++) {
            //g.fillOval(cercle.getPosicio().getX(), cercle.getPosicio().getY(), cercle.getDiamtre(), cercle.getDiamtre());
            cercles[i].moureCercle(this.teLimits);
            //millor si tot lo de pintar els cercles ho feim al a classe cercle i aixi queda aqui més net
            cercles[i].pintarCercle(g);

        }

    }


}
