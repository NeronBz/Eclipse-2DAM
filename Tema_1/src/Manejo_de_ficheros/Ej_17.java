package Manejo_de_ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Ej_17 {

	public static void main(String[] args) {
		// 17. Realiza un programa que permita modificar los datos de un fichero. El
		// programa mostrará
		// el fichero y pedirá al usuario qué línea quiere modificar. El usuario
		// introducirá un número
		// de línea y el programa le pedirá los datos de la nueva línea. Por último, el
		// programa
		// modificará el fichero y mostrará el fichero modificado.

		Scanner teclado = new Scanner(System.in);

		File fichero = new File("/home/diurno/Escritorio/AWS/Alumnos/alumnos.txt");

		if (fichero.exists() && fichero.isFile()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(fichero));
				String linea;
				int numLinea = 1;

				System.out.println("Contenido del fichero:");
				while ((linea = br.readLine()) != null) {
					System.out.println(numLinea + ": " + linea);
					numLinea++;
				}
				br.close();

				System.out.print("\n¿Qué línea desea modificar? ");
				int lineaModificar = Integer.parseInt(teclado.nextLine());
				
				System.out.println("Introduce los nuevos datos separados por *;*");
				String nuevosDatos=teclado.nextLine();

				File temp = new File("/home/diurno/Escritorio/AWS/Alumnos/temp.txt");
				br = new BufferedReader(new FileReader(fichero));
				BufferedWriter bw = new BufferedWriter(new FileWriter(temp));

				int lineaActual = 1;
				while ((linea = br.readLine()) != null) {
					if (lineaActual != lineaModificar) {
						bw.write(linea);
						bw.newLine();
					}else {
						bw.write(nuevosDatos);
						bw.newLine();
					}
					lineaActual++;
				}

				br.close();
				bw.close();

				if (fichero.delete()) {
					if (temp.renameTo(fichero)) {
						System.out.println("\nLínea modificada correctamente. Nuevo contenido:\n");
						BufferedReader nuevo = new BufferedReader(new FileReader(fichero));
						while ((linea = nuevo.readLine()) != null) {
							System.out.println(linea);
						}
						nuevo.close();
					} else {
						System.out.println("No se pudo renombrar el fichero temporal.");
					}
				} else {
					System.out.println("No se pudo modificar el fichero original.");
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
