package Manejo_de_ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ej_12 {

	public static void main(String[] args) {
		// 12. Realiza un programa que añada información a un fichero como el que se
		// muestra en la
		// imagen. El programa deberá pedir el nombre de fichero y los datos de varias
		// personas. Si el
		// fichero no existe, se creará. Si existe se añadirán registros.
		Scanner teclado = new Scanner(System.in);

		System.out.println("Introduce el nombre del fichero:");
		String nombreFichero = teclado.nextLine();
		File fichero = new File(nombreFichero);

		try {
			if (!fichero.exists()) {
				if (fichero.createNewFile()) {
					System.out.println("El fichero " + nombreFichero + " se ha creado.");
				}
			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, true))) {
				boolean seguir = true;

				while (seguir) {
					System.out.println("¿Quieres añadir una persona? (si/no):");
					String respuesta = teclado.nextLine();

					if (!respuesta.equalsIgnoreCase("si")) {
						seguir = false;
					} else {
						System.out.println("Nombre:");
						String nombre = teclado.nextLine();
						System.out.println("Apellido:");
						String apellido = teclado.nextLine();
						System.out.println("Número:");
						String num = teclado.nextLine();

						bw.write(nombre + ";" + apellido + ";" + num);
						bw.newLine();
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			teclado.close();
		}
	}
}
