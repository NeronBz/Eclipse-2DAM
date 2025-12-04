package Multiprocesos;

import java.io.*;

public class PadreFiltros {
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("Uso: java PadreFiltros <archivo1> <archivo2> <salida>");
			return;
		}

		String archivo1 = args[0];
		String archivo2 = args[1];
		String salida = args[2];

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(salida))) {
			// Proceso 1
			ProcessBuilder pb1 = new ProcessBuilder("java", "FiltroProceso", archivo1);
			Process p1 = pb1.start();
			BufferedReader br1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));

			String linea;
			while ((linea = br1.readLine()) != null) {
				bw.write(linea);
				bw.newLine();
			}
			p1.waitFor();
			br1.close();

			// Proceso 2
			ProcessBuilder pb2 = new ProcessBuilder("java", "FiltroProceso", archivo2);
			Process p2 = pb2.start();
			BufferedReader br2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));

			while ((linea = br2.readLine()) != null) {
				bw.write(linea);
				bw.newLine();
			}
			p2.waitFor();
			br2.close();

			System.out.println("Filtros combinados escritos en " + salida);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
