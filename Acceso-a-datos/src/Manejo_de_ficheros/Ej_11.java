package Manejo_de_ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ej_11 {

	public static void main(String[] args) {
		// 11. Realiza un programa que cree un fichero y añada un texto. El programa
		// pedirá el nombre
		// del fichero y el texto.

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el nombre del fichero:");
		String nombreFichero = teclado.nextLine();
		System.out.println("Introduce texto:");
		String texto = teclado.nextLine();

		File fichero = new File(nombreFichero);
		if (fichero.exists())
			System.out.println("El fichero " + nombreFichero + " ya existe");
		else {
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero));
				bw.write(texto);
				bw.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

		}

	}

}
