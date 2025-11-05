package Manejo_de_ficheros;

import java.io.File;
import java.util.Scanner;

public class Ej_3 {

	public static void main(String[] args) {
		// 3. Mostrar el contenido de una carpeta cuya ruta se pide por teclado
		// comprobando que
		// existe y que es una carpeta. Del contenido se debe mostrar el nombre, si es
		// fichero o
		// carpeta, y las propiedades rwx.
		
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce una ruta: ");
		String ruta = teclado.nextLine();

		File carpeta = new File(ruta);

		if (carpeta.exists()) {
			if (carpeta.isDirectory()) {
				System.out.println("Es un directorio");
				File[] archivos = carpeta.listFiles();

				if (archivos != null) {
					for (File f : archivos) {
						String permisos = "";
						permisos += f.canRead() ? "r" : "-";
						permisos += f.canWrite() ? "w" : "-";
						permisos += f.canExecute() ? "x" : "-";
						if (f.isDirectory()) {
							System.out.println(f.getName() + " - " + " es una carpeta con permisos: " + permisos);
						} else if (f.isFile()) {
							System.out.println(f.getName() + " - " + " es un archivo con permisos: " + permisos);
						}
					}
				}
			}
		} else {
			System.out.println("No existe la ruta");
		}

	}

}
