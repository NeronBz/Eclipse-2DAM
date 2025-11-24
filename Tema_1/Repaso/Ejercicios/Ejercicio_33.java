package Ejercicios;

import java.util.TreeSet;

public class Ejercicio_33 {

	public static void main(String[] args) {
		// Crea una lista de grupos que hay en el centro sin duplicados y ordenados por
		// el grupo,
		// añade cinco grupos y muestra su contenido.
		
		TreeSet<String> grupos = new TreeSet<String>();
		grupos.add("1ESOA");
		grupos.add("4ESOC");
		grupos.add("2DAM");
		grupos.add("1FPB");
		grupos.add("2BACHB");

		for (String a : grupos) {
			System.out.println(a);

		}

	}

}
