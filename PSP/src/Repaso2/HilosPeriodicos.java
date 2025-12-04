package Repaso2;

public class HilosPeriodicos extends Thread { // ★ Patrón HilosEj.java

	private static volatile boolean ejecutando = true; // ★ FLAG VOLATILE CRÍTICO
	private final int tipoHilo;

	public HilosPeriodicos(int tipo) {
		this.tipoHilo = tipo;
	}

	@Override
	public void run() { // ★ SOBREESCRIBIR run()
		try {
			while (ejecutando) { // ★ CONTROL CON FLAG (Carrera.java)
				switch (tipoHilo) {
				case 1 -> {
					System.out.println("⏰ " + java.time.LocalTime.now());
					Thread.sleep(1000); // ★ 1 segundo
				}
				case 2 -> {
					System.out.println("💾 Guardando datos...");
					Thread.sleep(2000); // ★ 2 segundos
				}
				case 3 -> {
					int cpu = (int) (Math.random() * 100) + 1;
					System.out.println("⚡ CPU: " + cpu);
					Thread.sleep(3000); // ★ 3 segundos
				}
				}
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt(); // ★ BUENA PRÁCTICA
		}
		System.out.println("✅ Hilo " + tipoHilo + " TERMINADO");
	}

	public static void main(String[] args) throws InterruptedException {
		// ★ CREAR Y LANZAR - Patrón HilosEj2.java
		HilosPeriodicos reloj = new HilosPeriodicos(1);
		HilosPeriodicos backup = new HilosPeriodicos(2);
		HilosPeriodicos cpu = new HilosPeriodicos(3);

		reloj.start();
		backup.start();
		cpu.start();

		Thread.sleep(10000); // ★ 10 SEGUNDOS TOTAL

		// ★ PARADA ORDENADA - CRÍTICO EXAMEN
		ejecutando = false; // Señal a todos

		reloj.join(); // Esperar finalización
		backup.join();
		cpu.join();

		System.out.println("🎉 TODOS LOS HILOS FINALIZADOS");
	}
}
