package Ejercicios;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Ej_45 {

	public static void main(String[] args) {
		// Crear un objeto ObjectMapper
		ObjectMapper mapper = new ObjectMapper();

		try {
			// Leer el fichero JSON y convertirlo a un objeto de tipo Persona
			Persona persona = mapper.readValue("{ \"dni\": \"12345678A\", \"nombre\": \"Juan\", \"edad\": 30 }",
					Persona.class);

			// Imprimir el objeto Persona
			System.out.println(persona);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
