package Manejo_de_ficheros;

import java.io.File;

public class Ej_1 {

	public static void main(String[] args) {
		// 1. Mostrar la ruta absoluta de la carpeta actual.
		String rutaActual = new File(".").getAbsolutePath();
		System.out.println(rutaActual);

	}

}
