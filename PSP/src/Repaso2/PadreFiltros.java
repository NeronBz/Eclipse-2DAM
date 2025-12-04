package Repaso2;

import java.io.*;
import java.util.Arrays;

public class PadreFiltros {
	public static void main(String[] args) {
		// ★ EXAMEN: Siempre validar argumentos
		if (args.length != 3) {
			System.out.println("Uso: java PadreFiltros <in1.txt> <in2.txt> <salida.txt>");
			return;
		}

		try (BufferedWriter salida = new BufferedWriter(new FileWriter(args[2]))) {

			// ★ PROCESSBUILDER - Patrón Ej_4.java y Controlador.java
			ProcessBuilder pb1 = new ProcessBuilder("java", "FiltroProceso", args[0]);
			ProcessBuilder pb2 = new ProcessBuilder("java", "FiltroProceso", args[1]);

			// redirectErrorStream = UNE stdout+stderr (Ej_4.java)
			pb1.redirectErrorStream(true);
			pb2.redirectErrorStream(true);

			Process hijo1 = pb1.start(); // ★ LANZAR PROCESO
			Process hijo2 = pb2.start();

			// ★ LEER SALIDA PROCESOS - Patrón Ej_2.java
			leerYGuardar(hijo1, salida);
			leerYGuardar(hijo2, salida);

			// ★ ESPERAR TERMINACIÓN - CRÍTICO EXAMEN
			hijo1.waitFor();
			hijo2.waitFor();

			System.out.println("✅ Fichero unificado: " + args[2]);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ★ MÉTODO AUXILIAR - Patrón reutilizable (Ej_2.java)
	static void leerYGuardar(Process p, BufferedWriter bw) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) { // ★ CLAVE EXAMEN
			String linea;
			while ((linea = br.readLine()) != null) {
				bw.write(linea);
				bw.newLine();
			}
		}
	}
}
