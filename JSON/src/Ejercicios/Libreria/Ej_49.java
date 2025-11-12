package Ejercicios.Libreria;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ej_49 {

	public static void main(String[] args) {
		final String FICHERO = "datosPaqui.json";
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<Libro> libros = new ArrayList<>();
		File archivo = new File(FICHERO);

		// Leer datos si el fichero existe
		if (archivo.exists()) {
			try {
				LibrosContenedor contenedor = mapper.readValue(archivo, LibrosContenedor.class);
				if (contenedor.getLibros() != null)
					libros = new ArrayList<>(contenedor.getLibros());
			} catch (IOException e) {
				System.out.println("Error leyendo datos: " + e.getMessage());
			}
		}

		Scanner sc = new Scanner(System.in);
		int opcion;
		do {
			System.out.println("1. Nuevo libro");
			System.out.println("2. Modificar libro");
			System.out.println("3. Borrar libro");
			System.out.println("4. Salir");
			opcion = Integer.parseInt(sc.nextLine());
			switch (opcion) {
			case 1:
				Libro libro = new Libro();
				System.out.print("Título: ");
				libro.setTitulo(sc.nextLine());
				System.out.print("Autor: ");
				libro.setAutor(sc.nextLine());
				System.out.print("Editorial: ");
				libro.setEditorial(sc.nextLine());
				System.out.print("ISBN: ");
				libro.setIsbn(sc.nextLine());
				libros.add(libro);
				LibrosContenedor contenedor1 = new LibrosContenedor();
				contenedor1.setLibros(libros);
				try {
					mapper.writeValue(archivo, contenedor1);
					System.out.println("Guardado\n");
				} catch (IOException e) {
					System.out.println("Error guardando: " + e.getMessage());
				}
				break;
			case 2:
				System.out.print("ISBN a modificar: ");
				String isbnMod = sc.nextLine();
				for (Libro l : libros) {
					if (l.getIsbn().equals(isbnMod)) {
						System.out.print("Nuevo título: ");
						l.setTitulo(sc.nextLine());
						System.out.print("Nuevo autor: ");
						l.setAutor(sc.nextLine());
						System.out.print("Nueva editorial: ");
						l.setEditorial(sc.nextLine());
						break;
					}
				}
				LibrosContenedor contenedor2 = new LibrosContenedor();
				contenedor2.setLibros(libros);
				try {
					mapper.writeValue(archivo, contenedor2);
					System.out.println("Modificado y guardado\n");
				} catch (IOException e) {
					System.out.println("Error guardando: " + e.getMessage());
				}
				break;
			case 3:
				System.out.print("ISBN a borrar: ");
				String isbnBorrar = sc.nextLine();
				for (int i = 0; i < libros.size(); i++) {
					if (libros.get(i).getIsbn().equals(isbnBorrar)) {
						libros.remove(i);
						break;
					}
				}
				LibrosContenedor contenedor3 = new LibrosContenedor();
				contenedor3.setLibros(libros);
				try {
					mapper.writeValue(archivo, contenedor3);
					System.out.println("Borrado y guardado\n");
				} catch (IOException e) {
					System.out.println("Error guardando: " + e.getMessage());
				}
				break;
			case 4:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción no válida");
			}
		} while (opcion != 4);
		sc.close();
	}

}
