package Ejercicios;
//Raúl Blázquez Ibáñez

import java.util.Scanner;

public class Ejercicio_10 {

	public static void main(String[] args) {
		// Recuerda las mates nº naturales: 1, 2, 3… nº enteros ..-2,-1,0,1,2.. Pedir un
		// número entero
		// y ver primero si es positivo. Si es positivo, se verifica si es par o impar
		// dentro del primer if.
		// Si el número es negativo, se imprime "El número es negativo".

		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un número: ");
		int num1 = Integer.parseInt(teclado.nextLine());

		if (num1 > 0) {
			if (num1 % 2 == 0) {
				System.out.println("El número es par");
			} else {
				System.out.println("El número es impar");
			}
		} else {
			System.out.println("El número es negativo");
		}

	}

}
