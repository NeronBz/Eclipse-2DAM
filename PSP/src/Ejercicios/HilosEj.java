package Ejercicios;

public class HilosEj extends Thread {

	public void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.println("Ejecutando hilo: " + i);
		}
	}

}