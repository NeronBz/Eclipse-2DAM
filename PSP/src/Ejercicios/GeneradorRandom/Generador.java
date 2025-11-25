-*package Ejercicios.GeneradorRandom;

import java.util.Random;

public class Generador {
	public static void main(String[] args) {
		Random random = new Random();
		while (true) {
			int num1 = random.nextInt(10);
			int num2 = random.nextInt(10);
			System.out.println(num1 + " " + num2); // Separamos por espacio
			System.out.flush();

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				break;
			}
		}
	}

}
