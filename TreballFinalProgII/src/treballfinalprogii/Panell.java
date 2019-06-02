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

    private JLabel textNumBolles;           // etiqueta o texto no editable
    private JLabel textWithWalls;
    private JLabel textFollowMouse;
    private JTextField caixaNumeroBolles;        // caja de texto, para insertar datos
    private JCheckBox activarLimits;
    private JCheckBox activarRatoli;

    private PanellCercles panellCercles;
    private int numeroBolles = 2;
    public static final int margeXFinestra = 1000;
    public static final int margeYFinestra = 700;
    public static final int margeXPanellCercles = 800;
    public static final int margeYPanellCercles = 700;

    public Panell() {
        super();                    // usamos el contructor de la clase padre JFrame
        configurarFinestra();        // configuramos la ventana
    }

    public static void main(String[] args) {
        Panell finestra = new Panell();      // creamos una ventana
        finestra.setPanellCercles(finestra.getNumeroBolles());
        finestra.inicializarComponentes();   // inicializamos los atributos o componentes
        finestra.setVisible(true);
        finestra.panellCercles.comencarJoc();
    }

    private void configurarFinestra() {
        this.setTitle("Bolles");                                // colocamos titulo a la ventana
        this.setSize(margeXFinestra, margeYFinestra);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
        this.getContentPane().setBackground(Color.GRAY);
    }

    private void inicializarComponentes() {
        this.getContentPane().add(panellCercles);
        this.panellCercles.setBounds(0, 0, margeXPanellCercles, margeYPanellCercles);

        this.caixaNumeroBolles = new JTextField();
        this.caixaNumeroBolles.setBounds(margeXPanellCercles + 50, 150, 100, 25);
        this.caixaNumeroBolles.setText(Integer.toString(this.numeroBolles));
        this.getContentPane().add(this.caixaNumeroBolles);
        this.caixaNumeroBolles.addActionListener(this);

        this.activarLimits = new JCheckBox();
        this.activarLimits.setBounds(margeXPanellCercles + 20, 200, 25, 25);
        this.getContentPane().add(this.activarLimits);
        this.activarLimits.addActionListener(this);

        this.activarRatoli = new JCheckBox();
        this.activarRatoli.setBounds(margeXPanellCercles + 20, 250, 25, 25);
        this.getContentPane().add(this.activarRatoli);
        this.activarRatoli.addActionListener(this);

        //Caract de l'etiqueta
        this.textNumBolles = new JLabel();
        this.textNumBolles.setText("# Balls:");
        this.textNumBolles.setFont(new Font("Serif", Font.BOLD, 28));
        this.textNumBolles.setBounds(margeXPanellCercles + 50, 100, 150, 30);
        this.textNumBolles.setLayout(null);
        this.getContentPane().add(this.textNumBolles);

        this.textWithWalls = new JLabel();
        this.textWithWalls.setText("With walls");
        this.textWithWalls.setBounds(margeXPanellCercles + 50, 200, 100, 25);
        this.textWithWalls.setLayout(null);
        this.getContentPane().add(this.textWithWalls);

        this.textFollowMouse = new JLabel();
        this.textFollowMouse.setText("Follow mouse");
        this.textFollowMouse.setBounds(margeXPanellCercles + 50, 250, 100, 25);
        this.textFollowMouse.setLayout(null);
        this.getContentPane().add(this.textFollowMouse);

    }

    public void setPanellCercles(int numeroBolles) {
        this.panellCercles = new PanellCercles(numeroBolles);
    }

    public int getNumeroBolles() {
        return numeroBolles;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        this.panellCercles.setTeLimits(this.activarLimits.isSelected());
        this.panellCercles.setSeguirRatoli(this.activarRatoli.isSelected());

        try {
            int tempNumBolles = Integer.parseInt(caixaNumeroBolles.getText());// obtenemos el contenido de la caja de texto
            if (tempNumBolles != this.numeroBolles) {
                this.numeroBolles = tempNumBolles;
                this.panellCercles.setNumeroBolles(numeroBolles);
            }

        } catch (Exception exe) {
            System.out.println(exe);
        }

    }

}
