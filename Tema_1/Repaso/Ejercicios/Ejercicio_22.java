package Ejercicios;
//Raúl Blázquez Ibáñez

public class Ejercicio_22 {

	public static void main(String[] args) {
		// Crea un array con cinco números enteros y muestra después su contenido.

		int[] numeros = { 10, 20, 30, 40, 50 };

		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Elemento en posición " + i + ": " + numeros[i]);
		}
		for (int num : numeros) {

			System.out.println(num);
		}

	}

}
