package Manejo_de_ficheros;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ej_26 {

	public static void main(String[] args) {
		// 26. Implementa la clase Empleado con los atributos dni, nombre y sueldo. Como
		// métodos
		// tendrá los constructores, getters y setters y el toString. La clase debe
		// implementar la
		// interface Serializable. Ahora, crea un programa que cree un empleado
		// pasándole
		// directamente los valores por parámetros, se guarde en el fichero empleado.bin
		// Después
		// crea otro programa que lea y muestre por pantalla el objeto del fichero
		// empleado.bin.

		String ruta = "empleados.bin";

		Empleado empInicial = new Empleado("12345678A", "Paco", 3000);

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
			oos.writeObject(empInicial);
			System.out.println("Empleado guardado correctamente en " + ruta);
		} catch (IOException e) {
			System.out.println("Error al escribir el empleado: " + e.getMessage());
		}

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
			Empleado empLeido = (Empleado) ois.readObject();
			System.out.println("Empleado leído desde el fichero:");
			System.out.println(empLeido);
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al leer el empleado: " + e.getMessage());
		}
	}

}
