package Ejercicios;

import java.util.LinkedHashSet;

public class Ejercicio_32 {

	public static void main(String[] args) {
		// Crea una lista de niveles educativos que se imparten en el centro sin
		// duplicados y
		// ordenados por el orden de inserción, añade cinco niveles y muestra su
		// contenido.

		LinkedHashSet<String> niveles = new LinkedHashSet<String>();
		niveles.add("ESO");
		niveles.add("GM-SMR");
		niveles.add("GS-DAM");
		niveles.add("GS-DAW");
		niveles.add("BACH");

		for (String a : niveles) {
			System.out.println(a);

		}

	}

}
