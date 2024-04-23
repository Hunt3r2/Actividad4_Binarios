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

    public AñadirLibro(Frame ventana) {
    	//para que no te deje acceder a la ventana anterior
        super(ventana, "Añadir Libro", true);
        //icono bien fresco para la ventana
        setIconImage(Toolkit.getDefaultToolkit().getImage(AñadirLibro.class.getResource("/ejercicio2/imagenes/nicolas-cage-net-worth-through-the-years.jpg")));
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
        
        JPanel panel_titulo = new JPanel();
        panel_titulo.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        panel_titulo.setBackground(new Color(173, 216, 230));
        panel_titulo.setBounds(90, 50, 67, 30);
        panel.add(panel_titulo);
        
        JLabel lblTitulo = new JLabel("Título:");
        panel_titulo.add(lblTitulo);
                        
        JPanel panel_autor = new JPanel();
        panel_autor.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        panel_autor.setBackground(new Color(173, 216, 230));
        panel_autor.setBounds(90, 91, 67, 30);
        panel.add(panel_autor);
                        
        JLabel lblAutor = new JLabel("Autor:");
        panel_autor.add(lblAutor);
                        
        JPanel panel_año = new JPanel();
        panel_año.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        panel_año.setBackground(new Color(173, 216, 230));
        panel_año.setBounds(90, 132, 67, 30);
        panel.add(panel_año);
                        
        JLabel lblAño = new JLabel("Año:");
        panel_año.add(lblAño);
                        
        //un fondo muy serio para pensar (épico)
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
		btnGuardar.setBorder(new LineBorder(new Color(72, 209, 204), 3, true));
		btnGuardar.setBackground(new Color(64, 224, 208));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//guardo los datos 
				String titulo = textFieldTitulo.getText();
				String autor = textFieldAutor.getText();
				int año = Integer.parseInt(textFieldAño.getText());
				//guardar el libro en la clase libro
				libro = new Libro(titulo, autor, año);
				dispose();
			}
        });
        panelBotones.add(btnGuardar);                                       
                                        
      JButton btnCancelar = new JButton("Cancelar");
      btnCancelar.setBorder(new LineBorder(new Color(72, 209, 204), 3, true));
      btnCancelar.setBackground(new Color(64, 224, 208));
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
