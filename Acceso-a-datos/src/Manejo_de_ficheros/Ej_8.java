package Manejo_de_ficheros;

import java.io.File;
import java.util.Scanner;

public class Ej_8 {

	public static void listarArchivos(File carpeta) {
		if (carpeta.exists()) {
			File[] hijos = carpeta.listFiles();

			if (hijos != null) {
				for (File hijo : hijos) {
					System.out.println(hijo);

					if (hijo.isDirectory()) {
						listarArchivos(hijo);
					}
				}
			}
		} else {
			System.out.println("La carpeta no existe");
		}
	}

	public static void main(String[] args) {
		// 8. Realiza un programa que pida por teclado una ruta de carpeta y si existe
		// muestre su
		// contenido y el contenido de todos sus hijos tantos directos como indirectos.
		// Tal y como
		// muestra la imagen.

		Scanner teclado = new Scanner(System.in);
		System.out.println("Indica ruta de carpeta: ");
		String ruta = teclado.nextLine();

		File rutaCarpeta = new File(ruta);
		listarArchivos(rutaCarpeta);

	}

}
