package Ej_final;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
				for (Persona persona : contenedor.getPersonas()) {
					bw.write("Persona: " + persona.getNombre());
					bw.write(", ");
					System.out.println("Persona: " + persona.getNombre());
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
