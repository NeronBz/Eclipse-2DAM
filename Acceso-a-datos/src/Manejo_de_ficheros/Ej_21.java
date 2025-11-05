package Manejo_de_ficheros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ej_21 {

	public static void main(String[] args) {
		// 21. Crea un programa que genere un fichero binario que almacene un número
		// entero entre el
		// 32 y el 126. Se pedirá al usuario la ruta del fichero y el número que desea
		// almacenar. Si el
		// fichero existe se sobrescribirá. Visualiza el fichero creado. Compara el
		// resultado con la
		// tabla ASCII.

		Scanner sc = new Scanner(System.in);

		System.out.println("Ruta: ");
		String ruta = sc.nextLine();

		System.out.println("Número del 32 al 126: ");
		int num = Integer.parseInt(sc.nextLine());

		File archivo = new File(ruta);

		if (num >= 32 && num <= 126) {
			try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(archivo))) {
				dos.writeByte(num);
			} catch (IOException e) {
				e.printStackTrace();
			}

			try (DataInputStream dis = new DataInputStream(new FileInputStream(archivo))) {
				char caracter = (char) dis.readByte();
				System.out.println("Caracter en la tabla Ascii: " + caracter);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Número incorrecto");
		}

	}

}
