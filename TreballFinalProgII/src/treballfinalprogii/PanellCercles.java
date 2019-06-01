/*
 * Bartomeu Tortella Garcias i Maria Orell Monserrat
 *
 */

package treballfinalprogii;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/**
 *
 * @author mery
 */
public class PanellCercles extends JPanel implements MouseMotionListener {

    private Cercle[] cercles;
    private boolean teLimits = false;
    private boolean seguirRatoli = false;
    private Vector posicioMouse;

    public PanellCercles(int numeroBolles) {
        this.cercles = crearCercles(numeroBolles);
        this.addMouseMotionListener(this);
    }

    private Cercle[] crearCercles(int numCercles) {
        Cercle[] cercles = new Cercle[numCercles];
        for (int i = 0; i < numCercles; i++) {
            cercles[i] = new Cercle(Vector.generarPosicioAleatoria());
        }
        return cercles;
    }

    public void comencarJoc() {

        //al main de la classe main he de cridar akest metode perque tot se posi enmarxa (amb el while true)
        while (true) {
            for (int i = 0; i < cercles.length; i++) {
                //g.fillOval(cercle.getPosicio().getX(), cercle.getPosicio().getY(), cercle.getDiamtre(), cercle.getDiamtre());
                cercles[i].moureCercle(this.teLimits, this.seguirRatoli, this.posicioMouse);
                //millor si tot lo de pintar els cercles ho feim al a classe cercle i aixi queda aqui més net
            }
            repaint();
            try {
                Thread.sleep(1000 / 30);  // milliseconds
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }

    public boolean teLimits() {
        return teLimits;
    }

    public void setTeLimits(boolean teLimits) {
        this.teLimits = teLimits;
    }

    public boolean getSeguirRatoli() {
        return seguirRatoli;
    }

    public void setSeguirRatoli(boolean seguirRatoli) {
        this.seguirRatoli = seguirRatoli;
    }

    public void setNumeroBolles(int numeroBolles) {
        this.cercles = crearCercles(numeroBolles);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        // Draw the box
        g.setColor(java.awt.Color.LIGHT_GRAY);
        g.fillRect(0, 0, Panell.margeXPanellCercles, Panell.margeYPanellCercles);
        // Draw the ball
        for (int i = 0; i < cercles.length; i++) {
            //g.fillOval(cercle.getPosicio().getX(), cercle.getPosicio().getY(), cercle.getDiamtre(), cercle.getDiamtre());
            //millor si tot lo de pintar els cercles ho feim al a classe cercle i aixi queda aqui més net
            cercles[i].pintarCercle(g);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //no s'utiltiza
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //nomes fer-ho en cas de que el checkbox estigui activat
        if (this.seguirRatoli) {
            this.posicioMouse = new Vector(e.getPoint().x, e.getPoint().y);
        }

    }

}
