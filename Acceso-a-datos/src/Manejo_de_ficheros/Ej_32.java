package Manejo_de_ficheros;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ej_32 {

	public static void main(String[] args) {
		/*
		 * 32. Crea un programa en Java que simule el acceso y modificación de registros
		 * en un archivo binario que contiene información de productos. Cada registro
		 * almacenado en el archivo tiene un tamaño fijo y contiene los siguientes
		 * campos: 1. Código del producto, un número entero. 2. Nombre del producto,
		 * máximo 20 caracteres. 3. Precio del producto, un número con decimales. 4.
		 * Cantidad en stock, un número entero.
		 */
		try {
			RandomAccessFile archivo = new RandomAccessFile("productos.dat", "rw");

			// Escribimos 3 productos
			escribirProducto(archivo, 1, "Leche", 1.50, 100);
			escribirProducto(archivo, 2, "Pan", 8.75, 200);
			escribirProducto(archivo, 3, "Zumo", 15.30, 50);

			// Leemos el producto 2
			leerProducto(archivo, 1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	private static void escribirProducto(RandomAccessFile archivo, int c, String n, double p, int s) {
		// Para leer el nombre del producto ocupe los 20 carácteres
		if (n.length() < 20) {
			while (n.length() < 20) {
				n += " "; // Si es más corto, añadimos espacios al final
			}
		}

		try {
			archivo.writeInt(c); // Código
			archivo.writeBytes(n); // Nombre //writeBytes cada caracter no Unicode ocupa 1 byte
			// archivo.writeChars(n); //writeChars array de caracteres
			// archivo.writeUTF(n); //cada caracter ocpa 2 bytes, pero utiliza los 2 bytes
			// primero para indicar
			archivo.writeDouble(p); // Precio del producto
			archivo.writeInt(s); // Cantidad en stock
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void leerProducto(RandomAccessFile archivo, int indice) {
		try {
			// Mover el puntero del archivo a la posición correspondiente del registro
			archivo.seek(indice * 36);

			// Leer el código
			int codigo = archivo.readInt();

			// Leer el nombre
			byte[] nombreBytes = new byte[20]; // creamos temporalmente un array de x bytes
			archivo.read(nombreBytes); // leemos ese array de byte
			String nombre = new String(nombreBytes); // Convertimos el array de byte a String
			nombre.trim(); // Quitar los espacios en blanco

			double precio = archivo.readDouble();
			int stock = archivo.readInt();

			System.out.println("Producto: " + codigo);
			System.out.println("Nombre: " + nombre);
			System.out.println("Precio: " + precio);
			System.out.println("Stock: " + stock);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
