package ejercicio2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.Arrays;

public class Menu_principal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JFrame frame;
    private Libro[] libros = new Libro[10];
    private int contadorLibros = 0;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menu_principal frame = new Menu_principal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Menu_principal() {
    	//icono bien fresco para la ventana
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Menu_principal.class.getResource("/ejercicio2/imagenes/nicolas-cage-net-worth-through-the-years.jpg")));
    	setTitle("Menú principal :D");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 626, 429);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblBaile2 = new JLabel("");
        lblBaile2.setBorder(new LineBorder(new Color(255, 215, 0), 3, true));
        lblBaile2.setIcon(new ImageIcon(Menu_principal.class.getResource("/ejercicio2/imagenes/skeleton.gif")));
        lblBaile2.setBounds(10, 288, 83, 91);
        contentPane.add(lblBaile2);
        lblBaile2.setVisible(false);
        
        JLabel lblBaile1 = new JLabel("");
        lblBaile1.setBorder(new LineBorder(new Color(255, 215, 0), 3, true));
        lblBaile1.setIcon(new ImageIcon(Menu_principal.class.getResource("/ejercicio2/imagenes/skeleton.gif")));
        lblBaile1.setBounds(517, 288, 83, 91);
        contentPane.add(lblBaile1);
        lblBaile1.setVisible(false);

        JButton btnAñadir = new JButton("Añadir");
        btnAñadir.setFont(new Font("Century Gothic", Font.PLAIN, 11));
        btnAñadir.setBackground(new Color(176, 196, 222));
        btnAñadir.setBorder(new LineBorder(new Color(0, 206, 209), 3, true));
        btnAñadir.setFocusable(false);
        btnAñadir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//cuando le de al boton de añadir, que lo mande al metodo para abrir el JDialog
                abrirDialogoAñadirLibro();
            }
        });
        btnAñadir.setBounds(232, 283, 161, 23);
        contentPane.add(btnAñadir);

        //lo pongo aqui pero es igual que en todos, esto es una cosita que se activa cuando pasas el raton
        //por encima de algun boton, compruebalo ;D
        btnAñadir.addMouseListener(new MouseAdapter() {
        	@Override
        	 public void mouseEntered(MouseEvent e) {
                lblBaile1.setIcon(new ImageIcon(Menu_principal.class.getResource("/ejercicio2/imagenes/skeleton.gif")));
                lblBaile2.setIcon(new ImageIcon(Menu_principal.class.getResource("/ejercicio2/imagenes/skeleton.gif")));
             	lblBaile1.setVisible(true);
             	lblBaile2.setVisible(true);
             }
        	
        	public void mouseExited(MouseEvent e) {
             	lblBaile1.setVisible(false);
             	lblBaile2.setVisible(false);
             } 
        });

        JButton btnGuardar = new JButton("Guardar en fichero");
        btnGuardar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
        btnGuardar.setBackground(new Color(176, 196, 222));
        btnGuardar.setBorder(new LineBorder(new Color(0, 206, 209), 3, true));
        btnGuardar.setFocusable(false);
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
					guardarEnFichero();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        btnGuardar.setBounds(232, 317, 161, 23);
        contentPane.add(btnGuardar);
        
        btnGuardar.addMouseListener(new MouseAdapter() {
        	@Override
        	 public void mouseEntered(MouseEvent e) {
                lblBaile1.setIcon(new ImageIcon(Menu_principal.class.getResource("/ejercicio2/imagenes/racoon-raccoon.gif")));
                lblBaile2.setIcon(new ImageIcon(Menu_principal.class.getResource("/ejercicio2/imagenes/racoon-raccoon.gif")));
                lblBaile1.setVisible(true);
             	lblBaile2.setVisible(true);
             }
        	
        	public void mouseExited(MouseEvent e) {
             	lblBaile1.setVisible(false);
             	lblBaile2.setVisible(false);
             } 
        });

        JButton btnCargar = new JButton("Cargar en fichero");
        btnCargar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
        btnCargar.setBackground(new Color(176, 196, 222));
        btnCargar.setBorder(new LineBorder(new Color(0, 206, 209), 3, true));
        btnCargar.setFocusable(false);
        btnCargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
					cargarDeFichero();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        btnCargar.setBounds(232, 351, 161, 23);
        contentPane.add(btnCargar);
        
        btnCargar.addMouseListener(new MouseAdapter() {
        	@Override
        	 public void mouseEntered(MouseEvent e) {
                lblBaile1.setIcon(new ImageIcon(Menu_principal.class.getResource("/ejercicio2/imagenes/doot-dance.gif")));
                lblBaile2.setIcon(new ImageIcon(Menu_principal.class.getResource("/ejercicio2/imagenes/doot-dance.gif")));
             	lblBaile1.setVisible(true);
             	lblBaile2.setVisible(true);
             }
        	
        	public void mouseExited(MouseEvent e) {
             	lblBaile1.setVisible(false);
             	lblBaile2.setVisible(false);
             } 
        });

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new LineBorder(new Color(135, 206, 235), 3, true));
        scrollPane.setBounds(118, 11, 382, 261);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setBorder(new LineBorder(new Color(135, 206, 250), 2, true));
        table.setBackground(new Color(240, 248, 255));
        table.setGridColor(new Color(176, 196, 222));
        //para que no se pueda editar 
        table.setDefaultEditor(Object.class, null);        
        scrollPane.setViewportView(table);

        //fondo de pantalla bien profundo para pensar
        JLabel lblFondo = new JLabel("");
        lblFondo.setIcon(new ImageIcon(Menu_principal.class.getResource("/ejercicio2/imagenes/ezgif-7-1b1133c0f2.gif")));
        lblFondo.setBounds(0, 0, 610, 390);
        contentPane.add(lblFondo);
    }

    private void abrirDialogoAñadirLibro() {
    	//si se han introducido mas de 10 libros, que no me deje meter más
    	if (contadorLibros >= libros.length) {
            JOptionPane.showMessageDialog(frame, "No se pueden agregar más libros. La capacidad máxima es de " + libros.length + " libros.");
            return;
        }
    	
    	//llamo a la clase de añadir libro y la hago visible
        AñadirLibro dialog = new AñadirLibro(frame);
        dialog.setVisible(true);
        //para que se añada el libro a la tabla y llamo al metodo de actualizar 
        //la tabla para que salgan los libros en la tabla
        if (dialog.getLibro() != null && contadorLibros < libros.length) {
            libros[contadorLibros] = dialog.getLibro();
            contadorLibros++;
            actualizarTabla();
        }
    }

    private void actualizarTabla() {
    	//creo las columnas
        String[] nombreColumnas = {"Título", "Autor", "Año"};
        DefaultTableModel model = new DefaultTableModel(nombreColumnas, 0);
        //meto los libros en la tabla
        for (int i = 0; i < contadorLibros; i++) {
            Libro libro = libros[i];
            if (libro != null) {
                Object[] fila = {libro.getTitulo(), libro.getAutor(), libro.getAño()};
                model.addRow(fila);
            }
        }
        table.setModel(model);
    }

    private void guardarEnFichero() throws IOException {
    	FileOutputStream flujoSalida = new FileOutputStream("src"+ File.separator+"fichero" + File.separator + "libros.txt");
        try (ObjectOutputStream oos = new ObjectOutputStream(flujoSalida)) {
            for (int i = 0; i < contadorLibros; i++) {
                oos.writeObject(libros[i]);
            }
            JOptionPane.showMessageDialog(this, "Libros guardados en fichero correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void cargarDeFichero() throws IOException, ClassNotFoundException {
        File file = new File("src"+ File.separator+"fichero" + File.separator + "libros.txt");
        if (file.exists()) {
        	FileInputStream flujoSalida = new FileInputStream("src"+ File.separator+"fichero" + File.separator + "libros.txt");
            try (ObjectInputStream ois = new ObjectInputStream(flujoSalida)) {
                contadorLibros = 0;
                while (true) {
                    Libro libro = (Libro) ois.readObject();
                    if (libro != null) {
                        libros[contadorLibros++] = libro;
                    }
                }
            } catch (EOFException e) {
                // End of file reached, do nothing
            } catch (IOException e) {
                e.printStackTrace();
            }
            actualizarTabla();
            JOptionPane.showMessageDialog(this, "Libros cargados correctamente.");
        }
    }

}
