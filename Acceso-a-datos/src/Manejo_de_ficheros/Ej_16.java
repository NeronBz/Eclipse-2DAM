package Manejo_de_ficheros;

import java.io.*;
import java.util.Scanner;

public class Ej_16 {

	public static void main(String[] args) {
		// 16. Realiza un programa que permita borrar los datos de un fichero.
		// El programa mostrará el fichero y pedirá al usuario qué línea quiere borrar.
		// El usuario introducirá un número de línea, modificará el fichero y mostrará
		// el fichero modificado.

		Scanner teclado = new Scanner(System.in);

		File fichero = new File("/home/diurno/Escritorio/AWS/Alumnos/alumnos.txt");

		if (fichero.exists() && fichero.isFile()) {
			try {
				// Mostrar contenido con número de línea
				BufferedReader br = new BufferedReader(new FileReader(fichero));
				String linea;
				int numLinea = 1;

				System.out.println("Contenido del fichero:");
				while ((linea = br.readLine()) != null) {
					System.out.println(numLinea + ": " + linea);
					numLinea++;
				}
				br.close();

				// Pedir línea a borrar
				System.out.print("\n¿Qué línea desea borrar? ");
				int lineaBorrar = Integer.parseInt(teclado.nextLine());

				// Crear archivo temporal
				File temp = new File("/home/diurno/Escritorio/AWS/Alumnos/temp.txt");
				br = new BufferedReader(new FileReader(fichero));
				BufferedWriter bw = new BufferedWriter(new FileWriter(temp));

				int lineaActual = 1;
				while ((linea = br.readLine()) != null) {
					if (lineaActual != lineaBorrar) {
						bw.write(linea);
						bw.newLine();
					}
					lineaActual++;
				}

				br.close();
				bw.close();

				// Reemplazar fichero original por el temporal
				if (fichero.delete()) {
					if (temp.renameTo(fichero)) {
						System.out.println("\nLínea borrada correctamente. Nuevo contenido:\n");
						BufferedReader nuevo = new BufferedReader(new FileReader(fichero));
						while ((linea = nuevo.readLine()) != null) {
							System.out.println(linea);
						}
						nuevo.close();
					} else {
						System.out.println("No se pudo renombrar el fichero temporal.");
					}
				} else {
					System.out.println("No se pudo borrar el fichero original.");
				}

			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		} else {
			System.out.println("El fichero no existe o no es válido.");
		}

		teclado.close();
	}
}
