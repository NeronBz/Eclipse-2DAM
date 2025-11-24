package Manejo_de_ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ej_13 {

	public static void main(String[] args) {
		// 13. Muestra en pantalla el contenido de un fichero de texto cuya ruta se pasa
		// por consola.
		// Leeremos por carácter.
		Scanner teclado = new Scanner(System.in);

		System.out.println("Escribe la ruta: ");
		String ruta = teclado.nextLine();

		File fichero = new File(ruta);

		if (fichero.exists() && fichero.isFile()) {
			try {
				FileReader fr = new FileReader(fichero);
				int c;
				while ((c = fr.read()) != -1) {
					System.out.print((char) c);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
