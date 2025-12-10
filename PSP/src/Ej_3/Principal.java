package Ej_3;

public class Principal {
	public static void main(String[] args) {
		Contador c = new Contador();

		Runnable cliente = () -> {
			while (true) {
				boolean ok = c.retirar(50);
				if (!ok) {
					break;
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread cliente1 = new Thread(cliente, "Cliente 1");
		Thread cliente2 = new Thread(cliente, "Cliente 2");
		Thread cliente3 = new Thread(cliente, "Cliente 3");

		cliente1.start();
		cliente2.start();
		cliente3.start();

		try {
			cliente1.join();
			cliente2.join();
			cliente3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Dinero final en la cuenta: " + c.getValor() + "€");
	}
}
