package Ej_final;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Ej4 {

	public static void main(String[] args) {
		File fichero = new File("src/Ej_final/personas.obj");
		try {
			BufferedReader br = new BufferedReader(new FileReader(fichero));
			String linea;
			BufferedWriter bw = new BufferedWriter(new FileWriter("src/Ej_final/contactos.obj", true));
			while ((linea = br.readLine()) != null) {
				String[] textoSeparado = linea.split(",");
				if(linea.contains("Nombre")) {
					for (String f : textoSeparado) {
						System.out.println(f);
					}
				}
				System.out.println(linea);
			}
			br.close();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
