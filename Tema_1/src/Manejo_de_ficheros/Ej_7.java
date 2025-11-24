package Manejo_de_ficheros;
//Raúl Blázquez Ibáñez

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Ej_7 {

	public static void main(String[] args) {
		// 7. Realiza un programa en java que pida por teclado nombres de ficheros que
		// iremos
		// guardando en una lista. Finalizada la lista, para cada uno de esos ficheros
		// devolverá la
		// siguiente información:
		//  Si existe
		//  Si es un fichero o una carpeta
		//  La ruta absoluta
		//  Propiedades de lectura, escritura y ejecutar
		//  El tamaño

		Scanner teclado = new Scanner(System.in);
		ArrayList<String> nombres = new ArrayList<String>();
		String nombre = "";

		while (!nombre.equalsIgnoreCase("salir")) {
			System.out.print("Pon el nombre de un ruta (o 'salir' para terminar): ");
			nombre = teclado.nextLine();

			if (!nombre.equalsIgnoreCase("salir")) {
				nombres.add(nombre);
			}
		}

		for (String n : nombres) {
			File ruta = new File(n);
			System.out.println("----- Información de: " + n + " -----");

			if (ruta.exists()) {
				System.out.println("La ruta " + "existe");

				if (ruta.isDirectory()) {
					System.out.println("Es una carpeta");
				} else if (ruta.isFile()) {
					System.out.println("Es un archivo");
				}
				System.out.println("Ruta absoluta: " + ruta.getAbsolutePath());
				String permisos = "";
				permisos += ruta.canRead() ? "r" : "-";
				permisos += ruta.canWrite() ? "w" : "-";
				permisos += ruta.canExecute() ? "x" : "-";
				System.out.println("Permisos: " + permisos);

				System.out.println("Tamaño: " + ruta.length() + " bytes");
			} else {
				System.out.println("La ruta " + n + " no existe");
			}
		}

	}

}
