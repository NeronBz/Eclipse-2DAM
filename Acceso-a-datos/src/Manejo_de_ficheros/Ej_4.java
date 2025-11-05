package Manejo_de_ficheros;

import java.io.File;
import java.util.Scanner;

public class Ej_4 {

	public static void main(String[] args) {
		// 4. Crear una carpeta cuyo nombre se pide por teclado en la ruta por defecto.
		// Comprobar
		// antes de crear comprobar que la carpeta no existe.

		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce el nombre de la carpeta: ");
		String nombreCarpeta = teclado.nextLine();

		String rutaActual = System.getProperty("user.dir");

		File carpeta = new File(rutaActual, nombreCarpeta);

		if (!carpeta.exists()) {
			carpeta.mkdir();
		} else {
			System.out.println("Ya existe esa carpeta");
		}

	}

}
