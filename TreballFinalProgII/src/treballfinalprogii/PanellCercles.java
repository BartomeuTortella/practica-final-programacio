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
            //millor si tot lo de pintar els cercles ho feim al a classe cercle i aixi queda aqui més net
            cercles[i].pintarCercle(g);

        }

    }

}
