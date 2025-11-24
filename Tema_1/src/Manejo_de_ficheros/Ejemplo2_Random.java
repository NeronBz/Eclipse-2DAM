package Manejo_de_ficheros;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejemplo2_Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		try {
			// Crear o abrir un archivo para escribir
			RandomAccessFile archivo = new RandomAccessFile("numeros.txt", "rw");

			// Escribir datos en el archivo
			archivo.writeInt(1);
			archivo.writeDouble(5.5);

			archivo.writeInt(2);
			archivo.writeDouble(7.7);

			archivo.writeInt(3);
			archivo.writeDouble(9.9);

			// Variables
			int numPosicion;
			double valor;

			// Solicitar al usuario el nombre del fichero
			System.out.println("Introduce el orden de la nota a buscar: ");
			int numeroLeer = Integer.parseInt(sc.nextLine());

			// Ir al inicio del archivo
			archivo.seek(0);

			// Bucle para leer todos los datos
			try {
				while (true) {
					// Leer hasta el final del archivo
					numPosicion = archivo.readInt();
					valor = archivo.readDouble();
					if (numPosicion == numeroLeer) {
						System.out.println("Número encontrado: " + numPosicion + ", valor: " + valor);
						break;
					}
				}
			} catch (EOFException e) {
				// Llegamos al final del archivo
				System.out.println("Fin del archivo");
			}

			// Cerramos el archivo
			archivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
