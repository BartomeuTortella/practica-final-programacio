/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treballfinalprogii;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author mery
 */
public class PanellCercles extends JPanel{
    
    private Ellipse2D.Float cercle = new Ellipse2D.Float(0, 0, 500, 500);
    private Rectangle2D.Double cuadre = new Rectangle2D.Double(30, 30, 440, 440);
    private Line2D.Float linia1 = new Line2D.Float(0, 0, 500, 500);
    private Line2D.Float linia2 = new Line2D.Float(0, 500, 500, 0);

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setBackground(Color.YELLOW);//el fons es veu quan s'esborra una zona
        g2d.clearRect(0, 0, 500, 500);
        g2d.setColor(Color.RED);
        g2d.draw(cercle);
        g2d.setColor(Color.BLUE);
        g2d.draw(cuadre);
        g2d.setColor(Color.GREEN);
        g2d.draw(linia1);
        g2d.draw(linia2);
    }
    
}
