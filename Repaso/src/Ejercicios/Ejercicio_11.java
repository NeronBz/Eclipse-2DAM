package Ejercicios;
//Raúl Blázquez Ibáñez

import java.util.Scanner;

public class Ejercicio_11 {

	public static void main(String[] args) {
		// Pedir un número del 1 al 7 e indicar el día de la semana

		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un número del 1 al 7: ");
		int num1 = Integer.parseInt(teclado.nextLine());

		switch (num1) {
		case 1:
			System.out.println("Lunes");
			break;
		case 2:
			System.out.println("Martes");
			break;
		case 3:
			System.out.println("Miércoles");
			break;
		case 4:
			System.out.println("Jueves");
			break;
		case 5:
			System.out.println("Viernes");
			break;
		case 6:
			System.out.println("Sábado");
			break;
		case 7:
			System.out.println("Domingo");
			break;
		default:
			System.out.println("Número no válido");
		}
	}

}
