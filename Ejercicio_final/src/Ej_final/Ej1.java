package Ej_final;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Ej1 {

	public static void main(String[] args) {
		// Crear un objeto ObjectMapper
		ObjectMapper mapper = new ObjectMapper();

		try {
			// Leer el fichero JSON y convertirlo a un objeto de tipo Persona
			PersonaContenedor contenedor = mapper.readValue(new File("src/Ej_final/personas.json"),
					PersonaContenedor.class);
			File archivo = new File("src/Ej_final/personas1.obj");

			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
				for (Persona persona : contenedor.getPersonas()) {
					oos.writeObject(persona);
				}
			} catch (IOException e) {
				System.out.println("Error al escribir el empleado: " + e.getMessage());
			}

			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
				PersonaContenedor contenedor2 = (PersonaContenedor) ois.readObject();
				for (Persona persona : contenedor.getPersonas()) {
				}
				System.out.println("Empleado leído desde el fichero:");
				System.out.println(contenedor2);
			} catch (IOException | ClassNotFoundException e) {
				System.out.println("Error al leer el empleado: " + e.getMessage());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
