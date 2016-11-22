
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Berserker
 */


/**
 *  1) crear un archivo llamado holamundo.txt
 *  2) crear la ruta /develop/projects/tallerjava
 *  3) Guardar el archivo holamundo.txt en la ruta anterior
 *  4) verificar si el archivo exite y si no crearlo
 *  imprimir si es un archivo o un directorio
 *  5) leer una cadena desde consola y guardarla en el archivo holamundo.txt
 *  6) leer el archivo e imprimirlo en consola
 */
public class Archivos {

    /**
     * @param args the command line arguments
     */
    
    static String ruta = "C:\\Users\\Berserker\\Documents\\PruebaJava\\";
    static String nombreArchivo = "holaMundo.txt";
    
    public static void main(String[] args) {
        try {
            String rutaCompleta = ruta+nombreArchivo;
            crearArchivo(rutaCompleta);
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
    
    public static void crearArchivo(String ruta) throws Exception{
        File archivo = new File(ruta);
        BufferedWriter bw;        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if (archivo.isDirectory()) {
            System.out.println("La ruta especificada es un directorio\n\n");
        }else{
            System.out.println("La ruta especificada es un archivo\n\n");
            if (archivo.exists()) {
                bw = new BufferedWriter(new FileWriter(archivo, true));
                System.out.print("Texto  a guardar: ");
                bw.newLine();
                bw.append(br.readLine());
                bw.close();
                br.close();
            }else{
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.write("Archivo nuevo");
                System.out.println("El archivo se ha creado con exito");
                bw.close();
                br.close();
            }
            
            leerArchivo(ruta);
        }        
    }

    public static void leerArchivo(String ruta) throws Exception{
        String cadena;
        FileReader f = new FileReader(ruta);
        BufferedReader br = new BufferedReader(f);
        System.out.println("El archivo en la ruta: "+ruta);
        System.out.println("Contiene el siguiente texto\n");
        while ((cadena = br.readLine())!= null){            
            System.out.println(cadena);
        }
        br.close();
    }
}
