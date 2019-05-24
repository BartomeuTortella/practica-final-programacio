/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treballfinalprogii;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JPanel;

/**
 *
 * @author mery
 */
public class PanellCercles extends JPanel {

    private Cercle[] cercles;

    public PanellCercles() {
        this.cercles = crearCercles(20);
        comencarJoc();
    }

    private Cercle[] crearCercles(int numCercles) {
        Cercle[] cercles = new Cercle[numCercles];
        for (int i = 0; i < numCercles; i++) {
            cercles[i] = new Cercle(generarPosicioAleatoria());
        }
        return cercles;
    }

    private Vector generarPosicioAleatoria() {

        int randomNumX = ThreadLocalRandom.current().nextInt(0, 460 + 1);
        int randomNumY = ThreadLocalRandom.current().nextInt(0, 634 + 1);
        Vector vector = new Vector(randomNumX, randomNumY);
        return vector;
    }

    private void comencarJoc() {
        Thread gameThread = new Thread() {
            public void run() {
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
        gameThread.start();  // Callback run()
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
            g.setColor(Color.YELLOW); //definim color de la bolla
            //pintam la bolla
            g.fillOval(
                    ((Double) cercles[i].getPosicio().getX()).intValue(),
                    ((Double) cercles[i].getPosicio().getY()).intValue(),
                    cercles[i].getDiamtre(),
                    cercles[i].getDiamtre());
            g.setColor(Color.BLACK); //definim el color del costat
            //pintam el costat
            g.drawOval(
                    ((Double) cercles[i].getPosicio().getX()).intValue(),
                    ((Double) cercles[i].getPosicio().getY()).intValue(),
                    cercles[i].getDiamtre(),
                    cercles[i].getDiamtre());

        }

    }

}
