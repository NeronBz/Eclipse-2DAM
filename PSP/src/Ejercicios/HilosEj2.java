package Ejercicios;

public class HilosEj2 {

	public static void main(String[] args) {
		HilosEj h1 = new HilosEj();
		HilosEj h2 = new HilosEj();
		h1.start();
		h2.start();
	}

}
