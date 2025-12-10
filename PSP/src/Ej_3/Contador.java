package Ej_3;

public class Contador {
	private int valor = 1000;

	public synchronized boolean retirar(int cantidad) {
		if (valor >= cantidad) {
			System.out.println(Thread.currentThread().getName() + " retira " + cantidad + "€");
			valor -= cantidad;
			System.out.println("Saldo restante: " + valor + "€");
			return true;
		} else {
			return false;
		}
	}

	public int getValor() {
		return valor;
	}
}
