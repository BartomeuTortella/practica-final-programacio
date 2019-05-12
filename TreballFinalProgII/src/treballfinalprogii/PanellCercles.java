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

    public PanellCercles(int numCercles) {
        this.cercles = crearCercles(numCercles);
    }

    private Cercle[] crearCercles(int numCercles) {
        Cercle[] cercles = new Cercle[numCercles];
        int temp = 20;
        for (int i = 0; i < numCercles; i++) {
            cercles[i] = new Cercle(temp);
            temp += 20;
        }
        return cercles;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setBackground(Color.YELLOW);//el fons es veu quan s'esborra una zona
        g2d.clearRect(0, 0, 500, 700);
        for (Cercle cercle : cercles) {
            g2d.draw(cercle.getCercle());
        }
    }

}
