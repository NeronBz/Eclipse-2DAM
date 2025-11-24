package Manejo_de_ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ej_14 {

	public static void main(String[] args) {
		// 14. Modifica el ejercicio anterior para leer por línea.

		Scanner teclado = new Scanner(System.in);

		System.out.println("Escribe la ruta: ");
		String ruta = teclado.nextLine();

		File fichero = new File(ruta);

		if (fichero.exists() && fichero.isFile()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(fichero));
				String linea;
				while ((linea = br.readLine()) != null) {
					System.out.println(linea);
				}
			} catch (Exception e) {
				e.getMessage();
				e.printStackTrace();

			}
		}

	}

}
