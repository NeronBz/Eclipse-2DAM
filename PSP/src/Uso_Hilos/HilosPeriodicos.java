package Uso_Hilos;

public class HilosPeriodicos extends Thread {

	private static volatile boolean running = true;
	private final int tipo;

	public HilosPeriodicos(int tipo) {
		this.tipo = tipo;
	}

	public void run() {
		try {
			while (running) {
				switch (tipo) {
				case 1:
					System.out.println("Hora actual: " + java.time.LocalTime.now());
					Thread.sleep(1000);
					break;
				case 2:
					System.out.println("Guardando datos...");
					Thread.sleep(2000);
					break;
				case 3:
					int n = (int) (Math.random() * 100) + 1;
					System.out.println("CPU simulada: " + n);
					Thread.sleep(3000);
					break;
				}
			}
		} catch (InterruptedException e) {
			// Thread interrumpido
		}
		System.out.println("Hilo " + tipo + " terminado.");
	}

	public static void main(String[] args) throws InterruptedException {
		HilosPeriodicos h1 = new HilosPeriodicos(1);
		HilosPeriodicos h2 = new HilosPeriodicos(2);
		HilosPeriodicos h3 = new HilosPeriodicos(3);

		h1.start();
		h2.start();
		h3.start();

		Thread.sleep(10000); // Ejecutar 10 segundos

		running = false; // señal para parar

		h1.join();
		h2.join();
		h3.join();

		System.out.println("Programa finalizado ordenadamente.");
	}
}
