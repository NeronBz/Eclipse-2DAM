package Manejo_de_ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejemplo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * FileReader fichero = null;
		 * 
		 * try { fichero = new FileReader("nombref.txt");
		 * 
		 * char letra; int caracter;
		 * 
		 * while ((caracter = fichero.read()) != -1) { letra = (char) caracter;
		 * System.out.print(letra); } } catch (FileNotFoundException e) {
		 * System.out.println("Fichero no encontrado"); e.printStackTrace(); } catch
		 * (IOException e) { System.out.println("Error al leer"); e.printStackTrace(); }
		 * finally { try { fichero.close(); } catch (IOException e) {
		 * e.printStackTrace(); } }
		 */

		/*
		 * BufferedReader fichero = null;
		 * 
		 * try { fichero = new BufferedReader(new FileReader("nombref.txt")); String
		 * linea; System.out.println("Contenido del fichero :"); while ((linea =
		 * fichero.readLine()) != null) { System.out.println(linea); } } catch
		 * (Exception e) { System.out.println("Error al abrir el fichero");
		 * e.getMessage(); e.printStackTrace(); } finally { try { fichero.close(); }
		 * catch (IOException e) { e.printStackTrace(); } }
		 */

		// Validamos si existe el fichero
		String nombreFichero = "fichero0.txt";
		File fichero = new File(nombreFichero);
		if (fichero.exists())
			System.out.println("El fichero " + nombreFichero + " ya existe");
		else {
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero));
				// Escribimos 10 filas
				for (int x = 0; x < 10; x++) {
					bw.write("Fila numero " + x + "\n");
				}
				bw.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

		}

	}

	public class EjemploSplit {
		public static void main(String[] args) {
			String frutas = "Fresa#Pera#Manzana#Platano#Naranja";
			String[] textoSeparado = frutas.split("#");
			for (String f : textoSeparado) {
				System.out.println(f);
			}
		}
	}
}
