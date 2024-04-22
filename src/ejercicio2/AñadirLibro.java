package ejercicio2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;

public class AñadirLibro extends JDialog {
    private JTextField textFieldTitulo;
    private JTextField textFieldAutor;
    private JTextField textFieldAño;
    private Libro libro;

    public AñadirLibro(Frame parent) {
        super(parent, "Añadir Libro", true);
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 377, 299);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 361, 219);
        getContentPane().add(panel);
        panel.setLayout(null);

        textFieldTitulo = new JTextField();
        textFieldTitulo.setBounds(192, 50, 77, 30);
        panel.add(textFieldTitulo);
        textFieldTitulo.setColumns(10);

        textFieldAutor = new JTextField();
        textFieldAutor.setBounds(192, 91, 77, 30);
        panel.add(textFieldAutor);
        textFieldAutor.setColumns(10);

        textFieldAño = new JTextField();
        textFieldAño.setBounds(192, 132, 77, 30);
        panel.add(textFieldAño);
        textFieldAño.setColumns(10);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        panel_1.setBackground(new Color(173, 216, 230));
        panel_1.setBounds(90, 50, 67, 30);
        panel.add(panel_1);
        
                JLabel lblTitulo = new JLabel("Título:");
                panel_1.add(lblTitulo);
                        
                        JPanel panel_1_1 = new JPanel();
                        panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
                        panel_1_1.setBackground(new Color(173, 216, 230));
                        panel_1_1.setBounds(90, 91, 67, 30);
                        panel.add(panel_1_1);
                        
                                JLabel lblAutor = new JLabel("Autor:");
                                panel_1_1.add(lblAutor);
                        
                        JPanel panel_1_1_1 = new JPanel();
                        panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
                        panel_1_1_1.setBackground(new Color(173, 216, 230));
                        panel_1_1_1.setBounds(90, 132, 67, 30);
                        panel.add(panel_1_1_1);
                        
                                JLabel lblAño = new JLabel("Año:");
                                panel_1_1_1.add(lblAño);
                        
                        JLabel lblFondo = new JLabel("");
                        lblFondo.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
                        lblFondo.setIcon(new ImageIcon(AñadirLibro.class.getResource("/ejercicio2/imagenes/jaajajajaajjajja.gif")));
                        lblFondo.setBounds(0, 0, 361, 219);
                        panel.add(lblFondo);
                        
                                JPanel panelBotones = new JPanel();
                                panelBotones.setBackground(new Color(176, 224, 230));
                                panelBotones.setBorder(new LineBorder(new Color(70, 130, 180), 3, true));
                                panelBotones.setBounds(0, 220, 361, 39);
                                getContentPane().add(panelBotones);
                                
                                        JButton btnGuardar = new JButton("Guardar");
                                        btnGuardar.addActionListener(new ActionListener() {
                                            public void actionPerformed(ActionEvent e) {
                                                String titulo = textFieldTitulo.getText();
                                                String autor = textFieldAutor.getText();
                                                int año = Integer.parseInt(textFieldAño.getText());
                                                libro = new Libro(titulo, autor, año);
                                                dispose();
                                            }
                                        });
                                        panelBotones.add(btnGuardar);
                                        
                                                JButton btnCancelar = new JButton("Cancelar");
                                                btnCancelar.addActionListener(new ActionListener() {
                                                    public void actionPerformed(ActionEvent e) {
                                                        dispose();
                                                    }
                                                });
                                                panelBotones.add(btnCancelar);
    }

    public Libro getLibro() {
        return libro;
    }
}
