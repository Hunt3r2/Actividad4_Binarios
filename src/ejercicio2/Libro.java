package ejercicio2;

import java.io.Serializable;

public class Libro implements Serializable {
    private static final long serialVersionUID = 1L;
    private String titulo;
    private String autor;
    private int año;

    public Libro(String titulo, String autor, int año) {
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAño() {
        return año;
    }
}
