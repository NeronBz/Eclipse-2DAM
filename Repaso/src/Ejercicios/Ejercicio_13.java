package Ejercicios;
//Raúl Blázquez Ibáñez

import java.util.Scanner;

public class Ejercicio_13 {

	public static void main(String[] args) {
		// Pedir la calificación numérica y decir si es un sobresaliente, notable, bien,
		// suficiente o
		// insuficiente (usando el switch)

		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce una calificación: ");
		int num = Integer.parseInt(teclado.nextLine());

		switch (num) {
		case 1, 2, 3, 4:
			System.out.println("Insuficiente");
			break;
		case 5:
			System.out.println("Suficiente");
			break;
		case 6:
			System.out.println("Bien");
			break;
		case 7, 8:
			System.out.println("Notable");
			break;
		case 9, 10:
			System.out.println("Sobresaliente");
			break;
		default:
			System.out.println("Número no válido");
		}
	}

}
