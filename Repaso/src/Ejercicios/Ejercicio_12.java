package Ejercicios;
//Raúl Blázquez Ibáñez

import java.util.Scanner;

public class Ejercicio_12 {

	public static void main(String[] args) {
		// Pedir la calificación numérica y decir si es un sobresaliente, notable, bien,
		// suficiente o
		// insuficiente (usando el if)

		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce una calificación: ");
		double num = Double.parseDouble(teclado.nextLine());

		if (num < 5) {
			System.out.println("Suspenso");
		} else if (num >= 5 && num < 6) {
			System.out.println("Suficiente");
		} else if (num >= 6 && num < 7) {
			System.out.println("Bien");
		} else if (num >= 7 && num < 9) {
			System.out.println("Notable");
		} else {
			System.out.println("Sobresaliente");
		}
	}

}
