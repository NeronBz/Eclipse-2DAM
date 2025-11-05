package Manejo_de_ficheros;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ej_24 {

	public static void main(String[] args) {
		// 24. Realiza un programa que muestre los registros del fichero del ejercicio
		// anterior.

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce la ruta: ");
		String ruta = sc.nextLine();
		File archivo = new File(ruta);

		try (DataInputStream dis = new DataInputStream(new FileInputStream(archivo))) {
			while (true) {
				int expediente = dis.readInt();
				float nota = dis.readFloat();
				String nombre = dis.readUTF();

				System.out.println("Expediente: " + expediente);
				System.out.println("Nota: " + nota);
				System.out.println("Nombre: " + nombre);
				System.out.println("----------------------------");
			}
		} catch (EOFException e) {
			System.out.println("Fin del fichero.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
