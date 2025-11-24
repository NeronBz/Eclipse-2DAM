package Manejo_de_ficheros;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class Ej_10 {

	public static void main(String[] args) {
		// 10. Crea un programa que solicita por teclado una ruta, verifica que la ruta
		// es válida y nos
		// mostrará los archivos que contiene dicho directorio ordenador por tamaño.

		Scanner teclado = new Scanner(System.in);
		System.out.println("Indica la ruta: ");
		String ruta = teclado.nextLine();
		TreeSet<String> archivos = new TreeSet<String>();

		File validarRuta = new File(ruta);

		if (validarRuta.exists()) {
			if (validarRuta.isFile() || validarRuta.isDirectory()) {
				File[] hijos = validarRuta.listFiles();
				if (hijos != null) {
					Arrays.sort(hijos, Comparator.comparingLong(File::length));

					// Mostrar resultados
					for (File archivo : hijos) {
						System.out.println(archivo.getName() + " - " + archivo.length() + " bytes");
					}

				} else {
				}
			}

		}
	}

}
