package Manejo_de_ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Ej_15 {

	public static void main(String[] args) {
		// 15. Realiza un programa que lea y muestre un fichero de texto que contiene el
		// nombre, los
		// apellidos y número de teléfono de personas, separados por el carácter
		// ;.También, deberá
		// mostrar el número de personas que hay en el fichero. El nombre del fichero se
		// pedirá por
		// teclado.

		Scanner teclado = new Scanner(System.in);

		System.out.println("Escribe la ruta: ");
		String ruta = teclado.nextLine();

		File fichero = new File(ruta);

		if (fichero.exists() && fichero.isFile()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(fichero));
				String linea;
				int contador = 0;

				while ((linea = br.readLine()) != null) {
					String[] textoSeparado = linea.split(";");
					System.out.println("Nombre: " + textoSeparado[0]);
					System.out.println("Apellidos: " + textoSeparado[1]);
					System.out.println("Teléfono: " + textoSeparado[2]);
					System.out.println("----------------------");
					contador++;

				}

                System.out.println("Total de personas: " + contador);
                br.close();
			} catch (Exception e) {
				e.getMessage();
				e.printStackTrace();
			}
		}

	}

}
