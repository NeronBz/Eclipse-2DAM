package Ejercicios;
//Raúl Blázquez Ibáñez

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Ejercicio_39 {

	public static void main(String[] args) {
		// Crea una aplicación con un menú de operaciones que nos permita trabajar con
		// el ejercicio
		// anterior.

		Boolean bool = true;
		LinkedHashMap<String, Alumno> alumnos = new LinkedHashMap<String, Alumno>();

		do {
			Scanner teclado = new Scanner(System.in);
			System.out.println("1 - Añadir elemento");
			System.out.println("2 - Buscar elemento");
			System.out.println("3 - Borrar elemento");
			System.out.println("4 - Listar");
			System.out.println("5 - Salir");
			System.out.println("Elige una opción del menú (1-5):");
			int opcion = Integer.parseInt(teclado.nextLine());

			switch (opcion) {
			case 1:
				Alumno a1 = new Alumno();

				System.out.println("DNI del Alumno: ");
				String dni = teclado.nextLine().toUpperCase();

				System.out.println("Nombre del Alumno: ");
				String nombre = teclado.nextLine();

				System.out.println("Apellidos del Alumno: ");
				String apellidos = teclado.nextLine();

				System.out.println("Expediente del Alumno: ");
				int expediente = Integer.parseInt(teclado.nextLine());

				Boolean seguirPidiendoNotas = true;

				while (seguirPidiendoNotas) {
					System.out.print("¿Quieres añadir una nota? (si/no): ");
					String respuesta = teclado.nextLine().trim().toLowerCase();

					if (respuesta.equals("si")) {
						try {
							System.out.print("Introduce la nota (0-10): ");
							double nota = Double.parseDouble(teclado.nextLine());
							if (nota >= 0 && nota <= 10) {
								a1.anadirNota(nota);
							} else {
								System.out.println("La nota debe estar entre 0 y 10");
							}
						} catch (NumberFormatException e) {
							System.out.println("Eso no es un número válido.");
						}
					} else if (respuesta.equals("no")) {
						seguirPidiendoNotas = false;
					} else {
						System.out.println("Respuesta no válida. Escribe 'si' o 'no'");
					}
				}

				a1.setNombre(nombre);
				a1.setApellidos(apellidos);
				a1.setExpediente(expediente);
				alumnos.put(dni, a1);
				break;

			case 2:
				System.out.println("DNI del alumno: ");
				String buscarDNI = teclado.nextLine().toUpperCase();
				if (alumnos.containsKey(buscarDNI)) {
					System.out.println("DNI: " + buscarDNI);
					System.out.println("Alumno: " + alumnos.get(buscarDNI));
				} else {
					System.out.println("Ese alumno no está matriculado");
				}
				break;

			case 3:
				System.out.println("¿Qué alumno quieres borrar? Proporciona DNI: ");
				String borrarDNI = teclado.nextLine().toUpperCase();

				if (alumnos.containsKey(borrarDNI)) {
					alumnos.remove(borrarDNI);
					System.out.println("Alumno borrado");
				} else {
					System.out.println("Ese alumno no está matriculado");
				}
				break;

			case 4:
				if (alumnos.isEmpty()) {
					System.out.println("No hay ningún alumno matriculado");
				} else {
					for (Alumno al : alumnos.values()) {
						System.out.println(al);
						System.out.println("Media de notas: " + al.calcularNota());
						System.out.println("----------------------------");
					}
				}
				break;

			case 5:
				System.out.println("Saliendo...");
				bool = false;
				break;

			default:
				System.out.println("Opción no válida. Elige un número entre 1 y 5.");
				break;
			}

		} while (bool);

	}

}
