package treballfinalprogii;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Panell extends JFrame implements ActionListener {

    private JLabel texto;           // etiqueta o texto no editable
    private JTextField caixaNumeroBolles;        // caja de texto, para insertar datos
    private JCheckBox activarLimits;
    private JButton boton;          // boton con una determinada accion
    private PanellCercles panellCercles;
    private int numeroBolles = 5;

    public Panell() {
        super();                    // usamos el contructor de la clase padre JFrame
        configurarVentana();        // configuramos la ventana
        panellCercles = new PanellCercles();
        inicializarComponentes();   // inicializamos los atributos o componentes
    }

    public static void main(String[] args) {
        Panell finestra = new Panell();      // creamos una ventana
        finestra.setVisible(true);
    }

    private void configurarVentana() {
        this.setTitle("Bolles");                                // colocamos titulo a la ventana
        this.setSize(700, 700);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
        this.getContentPane().setBackground(Color.GRAY);
    }

    private void inicializarComponentes() {
        this.getContentPane().add(panellCercles);
        this.panellCercles.setBounds(0, 0, 500, 700);
        this.caixaNumeroBolles = new JTextField();
        this.caixaNumeroBolles.setBounds(550, 150, 100, 25);
        this.caixaNumeroBolles.setText(Integer.toString(this.numeroBolles));
        this.getContentPane().add(this.caixaNumeroBolles);
        this.caixaNumeroBolles.addActionListener(this);
        this.activarLimits = new JCheckBox();
        this.activarLimits.setBounds(547, 200, 25,25);
        this.getContentPane().add(this.activarLimits);
        this.activarLimits.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println(this.activarLimits.isSelected());
        
        try {
            int nom = Integer.parseInt(caixaNumeroBolles.getText());// obtenemos el contenido de la caja de texto
            System.out.println(nom);
        } catch (Exception exe) {
            System.out.println(exe);
        }

    }

}
