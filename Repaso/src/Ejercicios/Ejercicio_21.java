package Ejercicios;
//Raúl Blázquez Ibáñez

import java.util.Scanner;

public class Ejercicio_21 {

	public static void main(String[] args) {
		// Escribe un programa que permita al usuario ingresar un número y muestre su
		// tabla de
		// multiplicar del 1 al 10. Luego, pregunta si el usuario quiere calcular otra
		// tabla y repite el
		// proceso si responde "sí".

		Scanner teclado = new Scanner(System.in);
		boolean bool = false;

		do {
			try {
				System.out.printf("Introduce un número: ");
				int num = Integer.parseInt(teclado.nextLine());
				for (int i = 1; i < 11; i++) {
					System.out.println(num + "x" + i + "=" + (num * i));
				}
				System.out.println("¿Quieres calcular otra tabla?");
				String respuesta = teclado.nextLine().toLowerCase();

				if (respuesta.equals("si")) {
					bool = true;
				} else {
					bool = false;
				}
				respuesta = "a";
			} catch (Exception e) {
				System.out.println("Pon un número");
			}

		} while (bool);

	}

}
