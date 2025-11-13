package Ej_final;

import java.io.*;
import java.util.LinkedHashMap;

public class Ej3 {

	public static void main(String[] args) {
		LinkedHashMap<String, String> lista = new LinkedHashMap<>();
		File fichero = new File("src/Ej_final/personas1.obj");
		try {
			BufferedReader br = new BufferedReader(new FileReader(fichero));
			String linea;
			BufferedWriter bw = new BufferedWriter(new FileWriter("src/Ej_final/personas.obj"));
			while ((linea = br.readLine()) != null) {
				String[] textoSeparado = linea.split(",");
				for (String f : textoSeparado) {
					System.out.println(f);
				}
				System.out.println(linea);
				bw.write(linea + "\n");
			}
			br.close();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		File fichero2 = new File("src/Ej_final/personas2.obj");
		try {
			BufferedReader br = new BufferedReader(new FileReader(fichero2));
			String linea;
			BufferedWriter bw = new BufferedWriter(new FileWriter("src/Ej_final/personas.obj", true));
			while ((linea = br.readLine()) != null) {
				String[] textoSeparado = linea.split(",");
				for (String f : textoSeparado) {
					System.out.println(f);
				}
				System.out.println(linea);
				bw.write(linea + "\n");
			}
			br.close();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
