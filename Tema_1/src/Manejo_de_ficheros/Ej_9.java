package Manejo_de_ficheros;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ej_9 {

	public static void borrarArchivo(File archivo, Scanner teclado) {
		if (archivo.exists()) {
			System.out.println("¿Estás seguro de borrarlo? (si/no)");
			String respuesta = teclado.nextLine();

			if (respuesta.equalsIgnoreCase("si")) {
				if (archivo.delete()) {
					System.out.println("Se ha eliminado el archivo correctamente");
				} else {
					System.out.println("No se pudo eliminar el archivo");
				}
			} else {
				System.out.println("Cancelado. El archivo no se borró");
			}
		} else {
			System.out.println("El archivo no existe");
		}
	}

	public static void crearArchivo(File archivo) {
		if (archivo.exists()) {
			System.out.println("Este archivo ya existe: " + archivo.getAbsolutePath());
		} else {
			try {
				if (archivo.createNewFile()) {
					System.out.println("Archivo creado: " + archivo.getAbsolutePath());
				} else {
					System.out.println("No se pudo crear el archivo");
				}
			} catch (IOException e) {
				System.err.println("Ocurrió un error al crear el archivo: " + e.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		// 9. Realiza un programa que borre un fichero que se pasa por parámetro. Antes
		// de borrar se
		// debe chequear que el fichero existe y pedir una confirmación de si realmente
		// se quiere
		// borrar.

		Scanner teclado = new Scanner(System.in);

		System.out.print("Introduce la ruta del archivo a crear/borrar: ");
		String ruta = teclado.nextLine();

		File archivo = new File(ruta);

		crearArchivo(archivo);
		borrarArchivo(archivo, teclado);

		teclado.close();
	}
}
