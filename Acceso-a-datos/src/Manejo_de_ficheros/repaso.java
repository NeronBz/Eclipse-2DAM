package Manejo_de_ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;


public class repaso {

    /*
     * Ejemplos de métodos agrupados por funcionalidad
     */

    Scanner sc = new Scanner(System.in);

    // Listas con diferentes características:
    ArrayList<String> nombres = new ArrayList<>();               // Lista con duplicados
    HashSet<String> casas = new HashSet<>();                     // Lista sin duplicados
    LinkedHashSet<String> niveles = new LinkedHashSet<>();       // Sin duplicados y orden de inserción
    TreeSet<String> archivos = new TreeSet<>();                  // Sin duplicados y orden natural
    TreeMap<String, Persona> personas = new TreeMap<>();         // Clave-valor sin duplicados y orden natural
    LinkedHashMap<String, Alumno> lista = new LinkedHashMap<>(); // Clave-valor sin duplicados y orden de inserción
    
    boolean - 1 byte
    char - 2 bytes
    byte - 1 byte
    short - 2 bytes
    int - 4 bytes
    float - 4 bytes
    long - 8 bytes
    double - 8 bytes

    // Ejemplo de uso de File para comprobar permisos y tipo de archivo
    public void mostrarPermisosYTipo(File[] archivos) {
        for (File f : archivos) {
            String permisos = "";
            permisos += f.canRead() ? "r" : "-";
            permisos += f.canWrite() ? "w" : "-";
            permisos += f.canExecute() ? "x" : "-";
            if (f.isDirectory()) {
                System.out.println(f.getName() + " - es una carpeta con permisos: " + permisos);
            } else if (f.isFile()) {
                System.out.println(f.getName() + " - es un archivo con permisos: " + permisos);
            }
        }
    }

    // Ordenar archivos por tamaño (usando Arrays.sort y Comparator)
    public void ordenarPorTamanio(File[] hijos) {
        java.util.Arrays.sort(hijos, java.util.Comparator.comparingLong(File::length));
    }

    // Escribir texto en fichero (agregando contenido)
    public void escribirTextoBuffered(String nombreFichero, String texto) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero, true));
        bw.write(texto);
        bw.close();
    }

    // Leer fichero carácter a carácter
    public void leerFicheroCharPorChar(String fichero) throws IOException {
        FileReader fr = new FileReader(fichero);
        int c;
        while ((c = fr.read()) != -1) {
            System.out.print((char) c);
        }
        fr.close();
    }

    // Leer fichero línea a línea
    public void leerFicheroLineas(String fichero) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fichero));
        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }
        br.close();
    }

    // Escritura de byte con DataOutputStream
    public void escribirByteDataStream(File archivo, byte num) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(archivo))) {
            dos.writeByte(num);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Lectura de byte con DataInputStream
    public void leerByteDataStream(File archivo) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(archivo))) {
            char caracter = (char) dis.readByte();
            System.out.println("Caracter en la tabla ASCII: " + caracter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Escritura de objeto con ObjectOutputStream
    public void escribirObjeto(String ruta, Empleado empInicial) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(empInicial);
            System.out.println("Empleado guardado correctamente en " + ruta);
        } catch (IOException e) {
            System.out.println("Error al escribir el empleado: " + e.getMessage());
        }
    }

    // Lectura de objeto con ObjectInputStream
    public void leerObjeto(String ruta) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            Empleado empLeido = (Empleado) ois.readObject();
            System.out.println("Empleado leído desde el fichero:");
            System.out.println(empLeido);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el empleado: " + e.getMessage());
        }
    }

}
