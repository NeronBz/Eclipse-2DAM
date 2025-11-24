package Ejercicios;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Ejercicio_38 {

	public static void main(String[] args) {
		// Crea una lista de dni-alumno sin duplicados y ordenados por orden de
		// inserción,
		// añade cinco niveles y muestra su contenido. Debes utilizar la clase Alumno ya
		// definida en
		// un ejercicio anterior.

		LinkedHashMap<String, Alumno> lista = new LinkedHashMap<String, Alumno>();
		Alumno a1 = new Alumno(17350395, "Raúl", "Blázquez", new ArrayList<Double>());
		a1.anadirNota(7);
		Alumno a2 = new Alumno(38572213, "Paco", "Micro", new ArrayList<Double>());
		a2.anadirNota(6);
		Alumno a3 = new Alumno(62208953, "Alberto", "Rodriguez", new ArrayList<Double>());
		a3.anadirNota(2.12);
		Alumno a4 = new Alumno(12986491, "Perico", "Palotes", new ArrayList<Double>());
		a4.anadirNota(10);
		Alumno a5 = new Alumno(06316734, "Juan", "Ymedio", new ArrayList<Double>());
		a5.anadirNota(4.5);

		lista.put("12345678A", a1);
		lista.put("87654321B", a2);
		lista.put("67359816C", a3);
		lista.put("13571139D", a4);
		lista.put("81571035F", a5);

		for (Alumno a : lista.values()) {
			System.out.println(a);
		}

	}

}
