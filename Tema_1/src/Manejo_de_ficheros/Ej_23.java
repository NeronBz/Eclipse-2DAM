package Manejo_de_ficheros;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ej_23 {

	public static void main(String[] args) {
		// 23. Realiza un programa que permita generar un fichero con las notas de los
		// alumnos de AD. El
		// programa solicitará al usuario que introduzca el número de expediente del
		// alumno, el
		// nombre y la nota del alumno. El fichero tendrá la siguiente estructura:
		// • int expediente
		// • double nota
		// • String Nombre_Alumno: Los String tienen que acabar con \n para que se pueda
		// saber
		// el tamaño del String y leer después con el método readChar(). La longitud del
		// String es variable y el fin lo marca el \n. Podría usarse cualquier otro
		// separador

		Scanner sc = new Scanner(System.in);

		System.out.println("Número de expediente: ");
		int expediente = Integer.parseInt(sc.nextLine());

		System.out.println("Nombre: ");
		String nombre = sc.nextLine();

		System.out.println("Nota: ");
		float nota = Float.parseFloat(sc.nextLine());

		File archivo = new File("/home/diurno/Escritorio/ej23.txt");

		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(archivo, true))) {
			dos.writeInt(expediente);
			dos.writeFloat(nota);
			dos.writeUTF(nombre + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
