package ejercicio2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    	setTitle("Menú principal :D");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 626, 429);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnAñadir = new JButton("Añadir");
        btnAñadir.setFont(new Font("Century Gothic", Font.PLAIN, 11));
        btnAñadir.setBackground(new Color(176, 196, 222));
        btnAñadir.setBorder(new LineBorder(new Color(0, 206, 209), 3, true));
        btnAñadir.setFocusable(false);
        btnAñadir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirDialogoAñadirLibro();
            }
        });
        btnAñadir.setBounds(232, 283, 161, 23);
        contentPane.add(btnAñadir);

        JButton btnGuardar = new JButton("Guardar en fichero");
        btnGuardar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
        btnGuardar.setBackground(new Color(176, 196, 222));
        btnGuardar.setBorder(new LineBorder(new Color(0, 206, 209), 3, true));
        btnGuardar.setFocusable(false);
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarEnFichero();
            }
        });
        btnGuardar.setBounds(232, 317, 161, 23);
        contentPane.add(btnGuardar);

        JButton btnCargar = new JButton("Cargar en fichero");
        btnCargar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
        btnCargar.setBackground(new Color(176, 196, 222));
        btnCargar.setBorder(new LineBorder(new Color(0, 206, 209), 3, true));
        btnCargar.setFocusable(false);
        btnCargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarDesdeFichero();
            }
        });
        btnCargar.setBounds(232, 351, 161, 23);
        contentPane.add(btnCargar);

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

        JLabel lblFondo = new JLabel("");
        lblFondo.setIcon(new ImageIcon(Menu_principal.class.getResource("/ejercicio2/imagenes/ezgif-7-1b1133c0f2.gif")));
        lblFondo.setBounds(0, 0, 610, 390);
        contentPane.add(lblFondo);
    }

    private void abrirDialogoAñadirLibro() {
        AñadirLibro dialog = new AñadirLibro(frame);
        dialog.setVisible(true);

        if (dialog.getLibro() != null && contadorLibros < libros.length) {
            libros[contadorLibros] = dialog.getLibro();
            contadorLibros++;
            actualizarTabla();
        }
    }

    private void actualizarTabla() {
        String[] columnNames = {"Título", "Autor", "Año"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (int i = 0; i < contadorLibros; i++) {
            Libro libro = libros[i];
            if (libro != null) {
                Object[] row = {libro.getTitulo(), libro.getAutor(), libro.getAño()};
                model.addRow(row);
            }
        }
        table.setModel(model);
    }

    private void guardarEnFichero() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("libros.txt"))) {
            Libro[] librosAGuardar = Arrays.copyOf(libros, contadorLibros);
            oos.writeObject(librosAGuardar);
            JOptionPane.showMessageDialog(frame, "Libros guardados en fichero correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error al guardar en fichero.");
        }
    }

    private void cargarDesdeFichero() {
        File file = new File("libros.txt");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                libros = (Libro[]) ois.readObject();
                contadorLibros = libros.length;
                actualizarTabla();
                JOptionPane.showMessageDialog(frame, "Libros cargados desde fichero correctamente.");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error al cargar desde fichero.");
            }
        }
    }
}
