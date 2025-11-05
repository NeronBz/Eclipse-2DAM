package Manejo_de_ficheros;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ej_5 {

	public static void main(String[] args) {
		// 5. Crear un fichero cuyo nombre se pide por teclado en la ruta por defecto.
		// Comprobar antes
		// de crear que el fichero no existe.

		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce el nombre del archivo: ");
		String nombreArchivo = teclado.nextLine();

		String rutaActual = System.getProperty("user.dir");

		File archivo = new File(rutaActual, nombreArchivo);

		if (!archivo.exists()) {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Ya existe esa carpeta");
		}

	}

}
