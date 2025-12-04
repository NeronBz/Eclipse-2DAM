package Repaso2;

import java.io.*;

public class FiltroProceso {
	public static void main(String[] args) {
		// ★ HIJO INDEPENDIENTE - Escribe a stdout (padre lo lee)
		try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				if (linea.toLowerCase().contains("java")) {
					System.out.println(linea); // ★ SALIDA ESTÁNDAR
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
