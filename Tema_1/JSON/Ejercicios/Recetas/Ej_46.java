package Ejercicios.Recetas;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Ej_46 {

	public static void main(String[] args) {
		// Crear un objeto ObjectMapper
		ObjectMapper mapper = new ObjectMapper();

		try {
			// Leer el archivo JSON y convertirlo a un objeto Receta
			RecetasContenedor contenedor = mapper.readValue(new File("src/recetas.json"), RecetasContenedor.class);
			for (Receta receta : contenedor.getRecetas()) {
				System.out.println("Receta: " + receta.getNombre());
				for (Ingrediente ingrediente : receta.getIngredientes()) {
					System.out.println("- " + ingrediente.getNombre() + ": " + ingrediente.getCantidad());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
