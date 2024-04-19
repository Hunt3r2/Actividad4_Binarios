package ejercicio1;

import java.io.*;

public class CopiaImagen {
    public static void main(String[] args) throws IOException {
        LectorEscritorFicheroBinario lectorEscritorBin = new LectorEscritorFicheroBinario();

        
        
        lectorEscritorBin.lecturaFicheroBinario("src" + File.separator + "fotos" + File.separator + "lebron.gif");
        lectorEscritorBin.escribirFicheroBinario("src" + File.separator + "fotos" + File.separator + "lebron.gif", "src" + File.separator + "fotos"+File.separator+"fotos2"+File.separator+"lebron_copia.gif");
        
        
    }
}
    
    class LectorEscritorFicheroBinario {

    public void lecturaFicheroBinario(String pathFichero) throws IOException
    {
        try
        {
        	//comprobamos que exista la subcarpeta, sino, que la cree
        	File subCarpeta = new File("src"+File.separator+"fotos"+File.separator+"fotos2");
            if (!subCarpeta.exists()) {
            	subCarpeta.mkdir();
            }
            
        	//
            FileInputStream lectorFB = new FileInputStream(new File(pathFichero));
            int valor = lectorFB.read();
            // int lectura
            while (valor != -1) {
                valor = lectorFB.read();
            }
            // Cerrar
            lectorFB.close();
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
  
    
    
    private void rellenarVector(int[] datos, String pathFicheroOrigen) {
        try {
            // Abrir
            FileInputStream lectorFB = new FileInputStream(new File(pathFicheroOrigen));
            //leo el archivo
            int valor = lectorFB.read();
            int contador = 0;
            //este bucle es para que este leyendo todos los bytes de la imagen
            while (valor != -1) {
            	datos[contador] = valor;
                valor = lectorFB.read();
                contador++;
            }
            //lo cierro
            lectorFB.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void escribirFicheroBinario(String pathFicheroOrigen, String pathFicheroDestino) {
        try {
        	
        	//creo el archivo
        	File miFichero = new File(pathFicheroDestino);
        	miFichero.createNewFile();
            // Abrir
            FileOutputStream escritorFB = new FileOutputStream(new File(pathFicheroDestino));
            
            //escribo en el los bytes que hay en la foto
            int cantidadBytes = this.contarBytes(pathFicheroOrigen);
            int[] datos = new int[cantidadBytes];
            this.rellenarVector(datos, pathFicheroOrigen);
            
            for(int i = 0; i < datos.length; i++) {
            	escritorFB.write(datos[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    private int contarBytes(String pathFicheroOrigen) {
    	int numBytes = 0;
    	try {
            // Abrir
            FileInputStream lectorFB = new FileInputStream(new File(pathFicheroOrigen));
            // Lectura
            int valor = lectorFB.read();
            // int lectura
            int posicion = 0;
            while (valor != -1) {
            	numBytes++;
                valor = lectorFB.read();
            }
            //lo cierro
            lectorFB.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    	
    	return numBytes;
    }
    }
