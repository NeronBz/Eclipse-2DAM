package Manejo_de_ficheros;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejemplo_Random {
	public static void main(String[] args) {
		try {
			// Crear o abrir un archivo para escribir
			RandomAccessFile archivo = new RandomAccessFile("líneas.txt", "rw");
			// Escribir datos en el archivo
			archivo.writeBytes("Primera línea de ejemplo.\n");
			archivo.writeBytes("Segunda línea de ejemplo.\n");
			archivo.writeBytes("Tercera línea de ejemplo.\n");
			archivo.writeBytes("Cuarta línea de ejemplo.\n");
			// Ir al inicio del archivo
			archivo.seek(0);
			// Leer el archivo línea por línea y contar la posición dinámica
			String linea;
			long posicion = 0;
			int numeroDeLinea = 3; // Queremos leer la tercera línea
			int contadorDeLineas = 1;
			// Variable para guardar el contenido de la tercera línea
			String terceraLinea = null;
			long posicionTerceraLinea = -1;
			// Bucle para leer todas las líneas
			while ((linea = archivo.readLine()) != null) {
				if (contadorDeLineas == numeroDeLinea) {
					terceraLinea = linea; // Guardar la 3º línea
					posicionTerceraLinea = posicion; // Guardar la posición 3º línea
				}
				posicion = archivo.getFilePointer(); // Actualizar la posición
				contadorDeLineas++;
			}
			if (terceraLinea != null) {
				System.out.println("Posición de la 3ºlínea: " + posicionTerceraLinea);
				System.out.println("Contenido de la 3º línea: " + terceraLinea);
			} else {
				System.out.println("No se encontró la tercera línea.");
			}
			// Cerrar el archivo
			archivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
