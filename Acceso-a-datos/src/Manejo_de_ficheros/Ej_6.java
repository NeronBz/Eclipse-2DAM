package Manejo_de_ficheros;

import java.io.File;
import java.util.Scanner;

public class Ej_6 {

	public static void main(String[] args) {
		// 6. Pedir por teclado una ruta de fichero y un nuevo nombre de fichero. El
		// programa deberá
		// renombrar el fichero original con el nuevo nombre en la carpeta original.
		// Comprobar que
		// el fichero original existe y que el nuevo no existe.

		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce la ruta completa del archivo: ");
		String ruta = teclado.nextLine();
		System.out.print("Introduce el nuevo nombre del archivo: ");
		String nombreArchivo = teclado.nextLine();

		File archivo = new File(ruta);

		if (!archivo.exists()) {
			System.out.println("El archivo original no existe.");
			return;
		}

		String directorioPadre = archivo.getParent();

		File archivoNuevo = new File(directorioPadre, nombreArchivo);

		if (archivoNuevo.exists()) {
			System.out.println("El archivo con el nuevo nombre ya existe.");
			return;
		}

		boolean exito = archivo.renameTo(archivoNuevo);

		if (exito) {
			System.out.println("Archivo renombrado correctamente.");
		} else {
			System.out.println("No se pudo renombrar el archivo.");
		}
	}
}
