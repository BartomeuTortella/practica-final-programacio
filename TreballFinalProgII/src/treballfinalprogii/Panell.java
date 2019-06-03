/*
 * Bartomeu Tortella Garcias i Maria Orell Monserrat
 *
 */
package treballfinalprogii;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Panell extends JFrame implements ActionListener {

    public static final int MARGE_X_FINESTRA = 1000; // constant per saber on és el marge X del JFrame
    public static final int MARGE_Y_FINESTRA = 700;  // constant per saber on és el marge Y del JFrame

    private JLabel textNumBolles;           //text per indicar el titol de numero de bolles
    private JLabel textWithWalls;           //text per indicar el titol de posar o no parets
    private JLabel textFollowMouse;         //text per indicar el titol de seguir o no el ratolí
    private JTextField caixaNumeroBolles;   //caixa de text per poder posar el numero de bolles
    private JCheckBox activarLimits;        //checkbox per activar o no les parets
    private JCheckBox activarRatoli;        //checkbox per activar o no el seguiment ratolí

    private PanellCercles panellCercles;    //definim el PanellCercles 

    private int numeroBolles = 5;           //variable que controla el numero de bolles en joc

    public Panell() {
        super();                    // cridada al constructor del JFrame
        configurarFinestra();        // configuram la finestra
    }

    public static void main(String[] args) {
        Panell finestra = new Panell();      //cream la finsestra
        finestra.setPanellCercles(finestra.getNumeroBolles()); //inicialitzam el panell de cercles de la finestra amb el numero de bolles que ha de tenir
        finestra.inicializarComponentes();   // iniciam els components de la finestra
        finestra.setVisible(true);          // feim que sigui visible
        finestra.panellCercles.comencarJoc();   // començam el joc
    }

    private void configurarFinestra() {
        this.setTitle("Simulació del moviment de les bolles");                                // posam el titol a la finestra
        this.setSize(MARGE_X_FINESTRA, MARGE_Y_FINESTRA);           //  posam els marges de la finestra
        this.setLocationRelativeTo(null);                       // posam la finestra al centre de la pantalla
        this.setLayout(null);                                   // no posam un layout ja que així podem donar posicions als components
        this.setResizable(false);                               // feim que la finsestra no es pugui ridimensionar
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // feim que un cop es tanqui la finestra l'execució s'aturi 
        this.getContentPane().setBackground(Color.LIGHT_GRAY);        // posam el color de fons
    }

    private void inicializarComponentes() {
        this.getContentPane().add(panellCercles); // afegim el panellCercles a la finestra
        this.panellCercles.setBounds(0, 0, PanellCercles.MARGE_X_PANELL, PanellCercles.MARGE_Y_PANELL); //el col·locam a la posició que volem

        this.caixaNumeroBolles = new JTextField(); // inicialitzam la caixa del numero de bolles
        this.caixaNumeroBolles.setBounds(PanellCercles.MARGE_X_PANELL + 50, 150, 100, 25); //el col·locam a la posició que volem 
        this.caixaNumeroBolles.setText(Integer.toString(this.numeroBolles)); //posam el text per defecte el numero de bolles inicials
        this.getContentPane().add(this.caixaNumeroBolles);  //afegim la caixa a la finestra 
        this.caixaNumeroBolles.addActionListener(this);     //afegim l'action listener

        this.activarLimits = new JCheckBox(); // inicialitzam el checkbox
        this.activarLimits.setBounds(PanellCercles.MARGE_X_PANELL + 20, 200, 25, 25); //el col·locam a la posició que volem
        this.getContentPane().add(this.activarLimits);  //afegim el checkbox a la finestra 
        this.activarLimits.addActionListener(this); //afegim l'action listener

        this.activarRatoli = new JCheckBox(); // inicialitzam el checkbox
        this.activarRatoli.setBounds(PanellCercles.MARGE_X_PANELL + 20, 250, 25, 25); //el col·locam a la posició que volem
        this.getContentPane().add(this.activarRatoli); //afegim el checkbox a la finestra 
        this.activarRatoli.addActionListener(this); //afegim l'action listener

        this.textNumBolles = new JLabel(); // inicialitzam el titol 
        this.textNumBolles.setText("# Balls:");  // posam el text del titol
        this.textNumBolles.setFont(new Font("Serif", Font.BOLD, 28)); //posam l'estil de la font 
        this.textNumBolles.setBounds(PanellCercles.MARGE_X_PANELL + 50, 100, 150, 30); //el col·locam a la posició que volem
        this.textNumBolles.setLayout(null);
        this.getContentPane().add(this.textNumBolles); // ho afegim a la finestra

        this.textWithWalls = new JLabel(); // inicialitzam el titol 
        this.textWithWalls.setText("With walls"); // posam el text del titol
        this.textWithWalls.setBounds(PanellCercles.MARGE_X_PANELL + 50, 200, 100, 25); //el col·locam a la posició que volem
        this.textWithWalls.setLayout(null);
        this.getContentPane().add(this.textWithWalls); // ho afegim a la finestra

        this.textFollowMouse = new JLabel(); // inicialitzam el titol 
        this.textFollowMouse.setText("Follow mouse"); // posam el text del titol
        this.textFollowMouse.setBounds(PanellCercles.MARGE_X_PANELL + 50, 250, 100, 25); //el col·locam a la posició que volem
        this.textFollowMouse.setLayout(null);
        this.getContentPane().add(this.textFollowMouse); // ho afegim a la finestra

    }

    public void setPanellCercles(int numeroBolles) {
        //metode que ens permet crear el panell de cercles segons el numero de bolles
        this.panellCercles = new PanellCercles(numeroBolles);
    }

    public int getNumeroBolles() {
        //metode que ens retorna  el numero de bolles
        return numeroBolles;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        //miram si el check box dels limits està activat
        this.panellCercles.setTeLimits(this.activarLimits.isSelected());
        // miram si el check box de seguir el ratolí està activat
        this.panellCercles.setSeguirRatoli(this.activarRatoli.isSelected());

        try {
            // miram el valor de la caixa i ho passam a int per tenir el numero de bolles i en cas de que no ho sigui ens tirarà una excepció 
            int tempNumBolles = Integer.parseInt(caixaNumeroBolles.getText());
            //comprovam que el numero de bolles no sigui el mateix que ja hi havia
            if (tempNumBolles != this.numeroBolles) {
                //posam el valor temporal de les bolles dins el numero de bolles
                this.numeroBolles = tempNumBolles;
                // i canviam el numero de bolles del panellCercle
                this.panellCercles.setNumeroBolles(numeroBolles);
            }

        } catch (Exception exe) {
            //control de l'excepció
            System.out.println(exe);
        }

    }

}
