package Manejo_de_ficheros;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Ej_33 {

	public static void main(String[] args) {
		/*
		 * 33. Modifica el ejercicio anterior para añadir las siguientes funciones: 1.
		 * Dar de alta un producto 2. Mostrar un listar de todos los productos 3.
		 * Modificar el stock de un producto 4. Borrar producto Para este ejercicio es
		 * importante: - El modificar solicitara el código del producto. - El borrado
		 * será marcando el registro con *.
		 */

		boolean continuar = true;
		Scanner teclado = new Scanner(System.in);

		do {
			System.out.println("1 - Dar de alta un producto");
			System.out.println("2 - Listar");
			System.out.println("3 - Modificar stock");
			System.out.println("4 - Borrar producto (poner asterisco en el codigo)");
			System.out.println("5 - Salir");
			System.out.print("Elige una opción (1-5): ");
			int opcion = Integer.parseInt(teclado.nextLine());

			switch (opcion) {
			case 1:
				int codigo;
				String nombre;
				double precio;
				int stock;
				System.out.println("\n--- Dar de alta producto ---");
				System.out.print("Nombre del producto: ");
				nombre = teclado.nextLine();

				System.out.print("Precio del producto: ");
				precio = Double.parseDouble(teclado.nextLine());

				System.out.print("Stock del empleado: ");
				stock = Integer.parseInt(teclado.nextLine());

				if (nombre.length() < 20) {
					while (nombre.length() < 20) {
						nombre += " "; // Si es más corto, añadimos espacios al final
					}
				}

				try {
					RandomAccessFile archivo = new RandomAccessFile("productosMenu.dat", "rw");

					long numRegistros = archivo.length() / 36;
					if (numRegistros == 0) {
						codigo = 1;
					} else {
						archivo.seek((numRegistros - 1) * 36);
						int ultimoCodigo = archivo.readInt();
						codigo = ultimoCodigo + 1;
					}
					archivo.seek(archivo.length());

					archivo.writeInt(codigo); // Código
					archivo.writeBytes(nombre); // Nombre //writeBytes cada caracter no Unicode ocupa 1 byte
					// archivo.writeChars(n); //writeChars array de caracteres
					// archivo.writeUTF(n); //cada caracter ocpa 2 bytes, pero utiliza los 2 bytes
					// primero para indicar
					archivo.writeDouble(precio); // Precio del producto
					archivo.writeInt(stock); // Cantidad en stock
					archivo.close();

					System.out.println("Producto añadido con código: " + codigo);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case 2:
				try {
					RandomAccessFile archivo = new RandomAccessFile("productosMenu.dat", "r");
					System.out.println("\n--- LISTADO DE PRODUCTOS ---");

					// Cada registro ocupa 36 bytes
					long numRegistros = archivo.length() / 36;

					if (numRegistros == 0) {
						System.out.println("No hay productos registrados");
					} else {
						for (int i = 0; i < numRegistros; i++) {
							archivo.seek(i * 36); // Ir al inicio del registro i

							codigo = archivo.readInt();

							byte[] nombreBytes = new byte[20];
							archivo.read(nombreBytes);
							nombre = new String(nombreBytes).trim();

							precio = archivo.readDouble();
							stock = archivo.readInt();

							System.out.printf("Código: %d | Nombre: %-20s | Precio: %.2f € | Stock: %d\n", codigo,
									nombre, precio, stock);
						}
					}

					archivo.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case 3:
				System.out.println("\n--- MODIFICAR STOCK ---");
				System.out.print("¿Qué producto quieres modificar? ");
				int modProducto = Integer.parseInt(teclado.nextLine());

				System.out.print("¿Qué nuevo stock quieres ponerle? ");
				int nuevoStock = Integer.parseInt(teclado.nextLine());

				try {
					RandomAccessFile archivo = new RandomAccessFile("productosMenu.dat", "rw");

					// Cada registro ocupa 36 bytes
					long numRegistros = archivo.length() / 36;

					boolean encontrado = false;

					for (int i = 0; i < numRegistros; i++) {
						archivo.seek(i * 36);
						codigo = archivo.readInt();

						// Si el código coincide, actualizamos el stock
						if (codigo == modProducto) {
							archivo.seek((i * 36) + 32); // posición exacta del campo stock (4+20+8 = 32)
							archivo.writeInt(nuevoStock);
							System.out.println("Stock actualizado a " + nuevoStock);
							encontrado = true;
							break;
						}
					}

					if (!encontrado) {
						System.out.println("No se encontró ningún producto con ese código");
					}

					archivo.close();

				} catch (IOException e) {
					e.printStackTrace();
				}

				break;

			case 4:

				break;
			case 5:
				System.out.println("Saliendo...");
				continuar = false;
				break;

			default:
				System.out.println("Opción no válida");
			}
		} while (continuar);

	}

}
