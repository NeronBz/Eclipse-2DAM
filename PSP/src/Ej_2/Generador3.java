package Ej_2;

import java.util.Random;

public class Generador3 {
	public static void main(String[] args) {
		Random random = new Random();
		while (true) {
			int num1 = random.nextInt(50);
			System.out.println(num1);
			System.out.flush();

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				break;
			}
		}
	}

}
