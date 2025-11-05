package Ejercicios;
//Raúl Blázquez Ibáñez

import java.util.Random;
import java.util.Scanner;

public class Ejercicio_20 {

	public static void main(String[] args) {
		// Escribe un programa que permita al usuario adivinar un número entre 1 y 100.
		// El programa
		// debe guiar al usuario diciéndole si el número es mayor o menor que el que
		// ingresó.

		Scanner teclado = new Scanner(System.in);

		int num = 0;
		Random random = new Random();
		int numeroRandom = random.nextInt(100 + 1);

		do {
			try {
				System.out.printf("Introduce un número: ");
				num = Integer.parseInt(teclado.nextLine());

				if (numeroRandom > num) {
					System.out.println("El número es mayor");
				} else if (numeroRandom < num) {
					System.out.println("El número es menor");
				} else {
					System.out.println("El número es correcto");
				}
			} catch (Exception e) {
				System.out.println("Error al leer del teclado");
			}
		} while (num != numeroRandom);

	}

}
