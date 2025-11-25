package Repaso;

class Buzon {
	private int mensaje;
	private boolean disponible = false;

	public synchronized void enviar(int valor) {
		while (disponible) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		mensaje = valor;
		disponible = true;
		notifyAll();
	}

	public synchronized int recibir() {
		while (!disponible) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		disponible = false;
		notifyAll();
		return mensaje;
	}
}
