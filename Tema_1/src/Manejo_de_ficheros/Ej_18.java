package Manejo_de_ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Ej_18 {

	public static void main(String[] args) {
		// Realiza un programa al que pida el nombre de un fichero de texto y genere
		// otro fichero
		// exactamente igual, pero con las letras del alfabeto en mayúsculas
		// transformadas en
		// minúsculas y viceversa. Si en el fichero original aparece el texto Hola, en
		// el fichero final
		// debe aparecer hOLA.

		Scanner sc = new Scanner(System.in);

		// Pedir fichero y generar otro igual
		System.out.println("Escribe el nombre de un fichero: ");
		String ruta = sc.nextLine();

		File archivo = new File(ruta);
		File temp = new File("/home/diurno/Escritorio/AWS/Alumnos/otroFichero.txt");
		String linea;
		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
			int c;
			while ((c = br.read()) != -1) {
				char caracter = (char) c;

				if (Character.isUpperCase(caracter)) {
					caracter = Character.toLowerCase(caracter);
				} else if (Character.isLowerCase(caracter)) {
					caracter = Character.toUpperCase(caracter);
				}

				bw.write(caracter);
			}
			
			br.close();
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
