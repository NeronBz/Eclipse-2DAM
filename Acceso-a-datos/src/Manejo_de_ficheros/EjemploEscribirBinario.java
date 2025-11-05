package Manejo_de_ficheros;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EjemploEscribirBinario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String nombreArchivo = "datos.bin";

		try (FileOutputStream fos = new FileOutputStream(nombreArchivo);
				DataOutputStream dos = new DataOutputStream(fos)) {

			// Escribir algunos datos binarios
			dos.writeInt(123);
			dos.writeDouble(45.67);
			dos.writeBoolean(true);
			dos.writeUTF("Hola mundo");

			System.out.println("Datos escritos correctamente en " + nombreArchivo);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
