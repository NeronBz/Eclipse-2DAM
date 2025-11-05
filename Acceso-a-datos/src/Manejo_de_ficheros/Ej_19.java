package Manejo_de_ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Ej_19 {

	public static void main(String[] args) {
		// 19. A partir de un fichero cotizaciones.txt que contiene 5 líneas con
		// información de cada
		// empresa. Queremos generar un fichero cotizaciones2.txt con el nombre de la
		// empresa y el
		// precio de la acción que se encuentran en la línea 2 y 3 respectivamente, para
		// la siguiente
		// empresa en la línea 7 y 8 y así sucesivamente. Para dar con las líneas de
		// información
		// debes calcular el modulo o resto de dividir esa línea por 5.

		File cotizaciones1 = new File("src/Ejercicios/ej19_cotizacion.txt");
		File cotizaciones2 = new File("src/Ejercicios/ej19_cotizacion2.txt");

		try (BufferedReader br = new BufferedReader(new FileReader(cotizaciones1));
				BufferedWriter bw = new BufferedWriter(new FileWriter(cotizaciones2))) {

			String linea;
			int contador = 1;

			while ((linea = br.readLine()) != null) {
				if (contador % 5 == 2) {
					bw.write(linea + ";");
				} else if (contador % 5 == 3) {
					bw.write(linea);
					bw.newLine();
				}
				contador++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
