package Ejercicios;

import java.util.HashSet;

public class Ejercicio_31 {

	public static void main(String[] args) {
		// Crea una lista de nombres de los profesores sin duplicados, añade cinco
		// nombres y
		// muestra su contenido.

		HashSet<String> nombres = new HashSet<String>();
		nombres.add("Pepe");
		nombres.add("Juan");
		nombres.add("Paco");
		nombres.add("Lucía");
		nombres.add("Julian");

		for (String a : nombres) {
			System.out.println(a);

		}

	}

}
