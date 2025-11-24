package Manejo_de_ficheros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ej_22 {

	public static void main(String[] args) {
		// 22. Realiza un programa que muestre el número del fichero generado en el
		// ejercicio anterior.

		Scanner sc = new Scanner(System.in);

		System.out.println("Ruta: ");
		String ruta = sc.nextLine();

		File archivo = new File(ruta);

		try (DataInputStream dis = new DataInputStream(new FileInputStream(archivo))) {
			System.out.println(dis.readByte());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
