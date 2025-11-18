package Ej_final3;

import java.io.*;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.xml.bind.*;

public class Ejercicio {
	private static final String JSON_FILE = "src/recetas.json";
	private static final String CSV_FILE = "src/recetas.csv";
	private static final String XML_FILE = "src/recetas.xml";
	private static ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

	public static void main(String[] args) throws Exception {
		RecetasContenedor contenedor = cargarRecetas();
		Scanner sc = new Scanner(System.in);

		boolean salir = false;
		while (!salir) {
			System.out.println("\n--- RECETARIO ---");
			System.out.println("1. Listar recetas");
			System.out.println("2. Añadir receta");
			System.out.println("3. Exportar recetas a CSV");
			System.out.println("4. Exportar recetas a XML");
			System.out.println("5. Salir");
			System.out.print("Elige una opción: ");
			String opcion = sc.nextLine().trim();

			switch (opcion) {
			case "1" -> listarRecetas(contenedor);
			case "2" -> {
				añadirReceta(contenedor, sc);
				guardarRecetas(contenedor);
			}
			case "3" -> exportarCSV(contenedor);
			case "4" -> exportarXML(contenedor);
			case "5" -> salir = true;
			default -> System.out.println("Opción no válida.");
			}
		}
		sc.close();
	}

	private static RecetasContenedor cargarRecetas() {
		try {
			File archivo = new File(JSON_FILE);
			if (archivo.exists()) {
				return mapper.readValue(archivo, RecetasContenedor.class);
			}
		} catch (IOException e) {
			System.out.println("No se pudo cargar el archivo JSON, empezando con lista vacía.");
		}
		RecetasContenedor contenedor = new RecetasContenedor();
		contenedor.setRecetas(new ArrayList<>());
		return contenedor;
	}

	private static void guardarRecetas(RecetasContenedor contenedor) {
		try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File(JSON_FILE), contenedor);
			System.out.println("Recetas guardadas en JSON correctamente.");
		} catch (IOException e) {
			System.err.println("Error al guardar en JSON: " + e.getMessage());
		}
	}

	private static void listarRecetas(RecetasContenedor contenedor) {
		if (contenedor.getRecetas().isEmpty()) {
			System.out.println("No hay recetas guardadas.");
			return;
		}
		for (Receta receta : contenedor.getRecetas()) {
			System.out.println("\nNombre: " + receta.getNombre());
			System.out.println("Tipo: " + receta.getTipo());
			System.out.println("Origen: " + receta.getOrigen().getPais() + " (" + receta.getOrigen().getRegion() + ")");
			System.out.println("Ingredientes:");
			for (Ingrediente ing : receta.getIngredientes()) {
				System.out.println(" - " + ing.getNombre() + ": " + ing.getCantidad());
			}
		}
	}

	private static void añadirReceta(RecetasContenedor contenedor, Scanner sc) {
		System.out.println("Introduce los datos de la nueva receta:");

		System.out.print("Nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Tipo: ");
		String tipo = sc.nextLine();

		System.out.print("País de origen: ");
		String pais = sc.nextLine();
		System.out.print("Región de origen: ");
		String region = sc.nextLine();
		Origen origen = new Origen(pais, region);

		List<Ingrediente> ingredientes = new ArrayList<>();
		String respuesta;
		do {
			System.out.print("Ingrediente nombre: ");
			String ingNombre = sc.nextLine();
			System.out.print("Cantidad: ");
			String ingCantidad = sc.nextLine();
			ingredientes.add(new Ingrediente(ingNombre, ingCantidad));
			System.out.print("¿Otro ingrediente? (s/n): ");
			respuesta = sc.nextLine();
		} while (respuesta.equalsIgnoreCase("s"));

		Receta nueva = new Receta(nombre, tipo, origen, ingredientes);
		contenedor.getRecetas().add(nueva);
		System.out.println("Receta añadida.");
	}

	private static void exportarCSV(RecetasContenedor contenedor) {
		try (PrintWriter pw = new PrintWriter(CSV_FILE)) {
			pw.println("Nombre,Tipo,Pais,Region,Ingrediente,Cantidad");
			for (Receta receta : contenedor.getRecetas()) {
				for (Ingrediente ing : receta.getIngredientes()) {
					pw.println(String.join(",", receta.getNombre(), receta.getTipo(), receta.getOrigen().getPais(),
							receta.getOrigen().getRegion(), ing.getNombre(), ing.getCantidad()));
				}
			}
			System.out.println("Recetas exportadas a " + CSV_FILE);
		} catch (IOException e) {
			System.err.println("No se pudo exportar a CSV: " + e.getMessage());
		}
	}

	private static void exportarXML(RecetasContenedor contenedor) {
		try {
			JAXBContext context = JAXBContext.newInstance(RecetasContenedor.class, Receta.class, Origen.class,
					Ingrediente.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(contenedor, new File(XML_FILE));
			System.out.println("Recetas exportadas a " + XML_FILE);
		} catch (JAXBException e) {
			System.err.println("No se pudo exportar a XML: " + e.getMessage());
		}
	}
}