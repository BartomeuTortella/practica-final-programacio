/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treballfinalprogii;

import java.awt.Color;
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
    }

    private Cercle[] crearCercles(int numCercles) {
        Cercle[] cercles = new Cercle[numCercles];
        int temp = 20;
        for (int i = 0; i < numCercles; i++) {
            cercles[i] = new Cercle();
            temp += 20;
        }
        return cercles;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        this.cercles = crearCercles(1);

        for (Cercle cercle : cercles) {
            // Draw the box
            g.setColor(java.awt.Color.LIGHT_GRAY);
            g.fillRect(0, 0, 500, 700);

            // Draw the ball
            g.setColor(java.awt.Color.BLUE);
            g.fillOval(cercle.getPosicio().getX(), cercle.getPosicio().getY(), cercle.getDiamtre(), cercle.getDiamtre());
        }
    }

}
