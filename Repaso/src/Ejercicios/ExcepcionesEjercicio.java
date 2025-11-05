package Ejercicios;
//Raúl Blázquez Ibáñez

import java.util.*;

public class ExcepcionesEjercicio {
	public static void main(String[] args) {

		// 1. Conversión inválida de String a int
		try {
			String invalido = "abc";
			int numero = Integer.parseInt(invalido);
		} catch (NumberFormatException e) {
			System.out.println("Error: Intento de convertir una cadena no numérica a entero");
		}

		// 2. División por cero
		try {
			int resultado = 10 / 0;
		} catch (ArithmeticException e) {
			System.out.println("Error: División por cero no permitida");
		}

		// 3. Operación sobre variable null
		try {
			String texto = null;
			int longitud = texto.length();
		} catch (NullPointerException e) {
			System.out.println("Error: Intento de operar sobre una referencia nula");
		}

		// 4. Acceso a índice inválido en lista
		try {
			List<String> lista = new ArrayList<>();
			lista.add("A");
			String valor = lista.get(2);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Error: Índice fuera de rango en la lista");
		}

		// 5. Modificación de colección durante iteración
		try {
			List<String> nombres = new ArrayList<>();
			nombres.add("Ana");
			nombres.add("Luis");

			for (String nombre : nombres) {
				if (nombre.equals("Ana")) {
					nombres.remove(nombre);
				}
			}
		} catch (ConcurrentModificationException e) {
			System.out.println("Error: Intento de modificar la colección mientras se está iterando sobre ella");
		}
	}
}
