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

    public static final int MARGE_X_PANELL = 800;   //declaració del marge X del panell cercles
    public static final int MARGE_Y_PANELL = 700;   //declaració del marge Y del panell cercles

    private Cercle[] cercles;   // definim l'array de cercles
    private boolean teLimits = false;   //definim i iniciam el valor de teLimits
    private boolean seguirRatoli = false;   //definim i inicial el valor de seguirRatoli
    private Vector posicioMouse;    //definim el vecotr de la posició del mouse 

    public PanellCercles(int numeroBolles) {
        super();
        this.cercles = crearCercles(numeroBolles); // iniciam l'array de cercles cridant al metode crearCercles
        this.addMouseMotionListener(this);  //afegim el mouse listener 
    }

    private Cercle[] crearCercles(int numCercles) {
        //metode que ens serveix per crear un array de cercles en posicions aleatories 
        //iniciam l'array de cercles segons el numero de cercles que ens han passat per parametres
        Cercle[] cercles = new Cercle[numCercles];
        //recorrem l'array de cercles
        for (int i = 0; i < cercles.length; i++) {
            //posam un cercle a cada posició de l'array a una posició aletoria del panell de cercles
            cercles[i] = new Cercle(Vector.generarPosicioAleatoria());
        }
        //retornam el cercle
        return cercles;
    }

    public void comencarJoc() {
        // while que fa correr el joc sempre
        while (true) {
            //recorrem l'array de cercles
            for (int i = 0; i < cercles.length; i++) {
                // comprovam que seguir ratoli estigui activat
                if (this.seguirRatoli) {
                    //revisam si els limits del panell estan activats
                    if (this.teLimits) {
                        // si té limits cridam a calcularDirreccióRebot amb un parametre de posició mouse
                        cercles[i].calcularDireccioRebot(this.posicioMouse);
                    } else {
                        // si no té limits cridam a calcularDireccioContinu amb un parametre de posició mouse
                        cercles[i].calcularDireccioContinu(this.posicioMouse);
                    }
                } else {
                    //revisam si els limits del panell estan activats
                    if (this.teLimits) {
                        // si té limits cridam a calcularDirreccióRebot
                        cercles[i].calcularDireccioRebot();
                    } else {
                        // si no té limits cridam a calcularDireccioContinu 
                        cercles[i].calcularDireccioContinu();
                    }
                }
            }
            //repintam
            repaint();
            try {
                //feim que java esperi
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
        // posam color a la caixa
        g.setColor(java.awt.Color.WHITE);

        //definim la caixa amb les seves mides i la pintam
        g.fillRect(0, 0, this.MARGE_X_PANELL, this.MARGE_Y_PANELL);
        // recorrem tots els cercles
        for (int i = 0; i < cercles.length; i++) {
            // cridam al metode pintar cercle de cada cercle
            cercles[i].pintarCercle(g);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //no s'utiltiza
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //agafam la posició actual del ratolí
        this.posicioMouse = new Vector(e.getX(), e.getY());
    }

}
