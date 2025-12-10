package Ej_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {

	public static void main(String[] args) {
		try {
			Process generador;
			Process generador2;
			Process generador3;

			int proceso1 = 0;
			int proceso2 = 0;
			int proceso3 = 0;

			String resultado = "El ganador final es el proceso ";
			int contador = 1;

			while (true) {
				ProcessBuilder pbGenerador = new ProcessBuilder("java", "src/Examen/Generador1.java");
				generador = pbGenerador.start();
				BufferedReader generadorOut = new BufferedReader(new InputStreamReader(generador.getInputStream()));

				ProcessBuilder pbGenerador2 = new ProcessBuilder("java", "src/Examen/Generador2.java");
				generador2 = pbGenerador2.start();
				BufferedReader generadorOut2 = new BufferedReader(new InputStreamReader(generador2.getInputStream()));

				ProcessBuilder pbGenerador3 = new ProcessBuilder("java", "src/Examen/Generador3.java");
				generador3 = pbGenerador3.start();
				BufferedReader generadorOut3 = new BufferedReader(new InputStreamReader(generador3.getInputStream()));

				int num1 = Integer.parseInt(generadorOut.readLine());
				int num2 = Integer.parseInt(generadorOut2.readLine());
				int num3 = Integer.parseInt(generadorOut3.readLine());

				System.out.println("Ronda " + contador);
				System.out.println("Proceso 1 -> " + num1);
				System.out.println("Proceso 2 -> " + num2);
				System.out.println("Proceso 3 -> " + num3);

				if (num1 > num2 && num1 > num3) {
					proceso1++;
					System.out.println("Ganador de la ronda: proceso 1");
				} else if (num2 > num1 && num2 > num3) {
					proceso2++;
					System.out.println("Ganador de la ronda: proceso 2");
				} else if (num3 > num1 && num3 > num2) {
					proceso3++;
					System.out.println("Ganador de la ronda: proceso 3");
				}
				contador++;

				if (proceso1 == 5) {
					resultado += "1";
					break;
				} else if (proceso2 == 5) {
					resultado += "2";
					break;
				} else if (proceso3 == 5) {
					resultado += "3";
					break;
				}
			}

			generador.destroy();
			generador2.destroy();
			generador3.destroy();

			System.out.println(resultado);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
