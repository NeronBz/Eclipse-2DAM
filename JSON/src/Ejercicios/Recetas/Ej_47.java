package Ejercicios.Recetas;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Ej_47 {

	public static void main(String[] args) {
		boolean continuar = true;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("1 - Ver datos de las recetas");
			System.out.println("2 - Nueva receta");
			System.out.println("3 - Borrar receta");
			System.out.println("4 - Salir");
			System.out.print("Elige una opción (1-4): ");
			int opcion = Integer.parseInt(sc.nextLine());

			switch (opcion) {
			case 1:
				try {
					ObjectMapper mapper = new ObjectMapper();
					RecetasContenedor contenedor = mapper.readValue(new File("src/recetas.json"),
							RecetasContenedor.class);
					for (Receta receta : contenedor.getRecetas()) {
						System.out.println("Receta: " + receta.getNombre());
						for (Ingrediente ingrediente : receta.getIngredientes()) {
							System.out.println("- " + ingrediente.getNombre() + ": " + ingrediente.getCantidad());
						}
					}

				} catch (IOException e) {
					e.printStackTrace();
				}

				break;

			case 2:

				System.out.println("Introduce el nombre de la receta: ");
				String nombre = sc.nextLine();
				System.out.println("Introduce el tipo de la receta: ");
				String tipo = sc.nextLine();
				System.out.println("Introduce el país de la receta: ");
				String pais = sc.nextLine();
				System.out.println("Introduce la región de la receta: ");
				String region = sc.nextLine();
				boolean continuar2 = true;
				do {
					System.out.println("Introduce el nombre del ingrediente: ");
					String nombreI = sc.nextLine();
					System.out.println("Introduce el nombre de la receta: ");
					String cantidad = sc.nextLine();
					System.out.println("¿Quieres añadir otro ingrediente?: ");
					String respuesta = sc.nextLine();
					if (!respuesta.equalsIgnoreCase("si")) {
						continuar2 = false;
					}
				} while (continuar2);

				break;

			case 3:

				break;

			case 4:
				System.out.println("Saliendo...");
				continuar = false;
				break;

			default:
				System.out.println("Opción no válida");
			}
		} while (continuar);

	}

}
