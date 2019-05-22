/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treballfinalprogii;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author mery
 */
public class PanellCercles extends JPanel {

    private Cercle[] cercles;

    public PanellCercles() {
        this.cercles = crearCercles(1);
        comencarJoc();
    }

    private Cercle[] crearCercles(int numCercles) {
        Cercle[] cercles = new Cercle[numCercles];
        for (int i = 0; i < numCercles; i++) {
            cercles[i] = new Cercle();
        }
        return cercles;
    }

    private void comencarJoc() {
        Thread gameThread = new Thread() {
            public void run() {
                while (true) {
                    repaint();
                    try {
                        Thread.sleep(1000 / 30);  // milliseconds
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };
        gameThread.start();  // Callback run()
    }

    @Override

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < cercles.length; i++) {
            // Draw the box
            g.setColor(java.awt.Color.LIGHT_GRAY);
            g.fillRect(0, 0, 500, 700);

            // Draw the ball
            g.setColor(java.awt.Color.BLUE);
            //g.fillOval(cercle.getPosicio().getX(), cercle.getPosicio().getY(), cercle.getDiamtre(), cercle.getDiamtre());
            cercles[i].moureCercle();
            g.fillOval(
                    ((Double) cercles[i].getPosicio().getX()).intValue(),
                    ((Double) cercles[i].getPosicio().getY()).intValue(),
                    cercles[i].getDiamtre(),
                    cercles[i].getDiamtre());
        }

    }

}
