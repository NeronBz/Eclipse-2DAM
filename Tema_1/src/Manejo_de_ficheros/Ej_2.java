package Manejo_de_ficheros;

import java.io.File;
import java.util.Scanner;

public class Ej_2 {

	public static void main(String[] args) {
		// 2. Pedir por teclado una ruta de fichero o carpeta y mostrar si lo que se ha
		// introducido existe,
		// si es un fichero o una carpeta y el tamaño.
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce una ruta: ");
		String ruta = teclado.nextLine();

		File archivo = new File(ruta);

		if (archivo.exists()) {
			if (archivo.isFile()) {
				System.out.println("Es un archivo");
				System.out.println("Tamaño: " + archivo.length() + " bytes");
			} else if (archivo.isDirectory()) {
				System.out.println("Es un directorio");
				System.out.println("Tamaño: " + archivo.length() + " bytes");
			}
		} else {
			System.out.println("No existe la ruta");
		}

	}

}
