package Multiprocesos;

import java.io.*;

public class FiltroProceso {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Uso: java FiltroProceso <archivo>");
			return;
		}
		String archivo = args[0];

		try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				if (linea.toLowerCase().contains("java")) {
					System.out.println(linea);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
