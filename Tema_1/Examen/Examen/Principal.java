package Examen;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.bind.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Principal {

	public static void main(String[] args) throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		File archivoCSV = new File("src/Examen_Archivos/NavalFood.csv");
		File archivoBin = new File("src/Examen_Archivos/restaurantes.dat");
		File popularidadFile = new File("src/Examen_Archivos/popularidad.dat");
		File archivoJSON = new File("src/Examen_Archivos/restaurante.json");
		File archivoXML = new File("src/Examen_Archivos/restaurante.xml");

		ComidaXML cx = new ComidaXML();
		ComidaJSON cj = new ComidaJSON();
		RestauranteXML rXml = new RestauranteXML();
		RestauranteJSON rJson = new RestauranteJSON();
		ArrayList<Comida> c = new ArrayList<Comida>();
		ObjectMapper mapper = new ObjectMapper();

		boolean continuar = true;

		do {
			System.out.println(
					"1. Leer del CSV, crear lista de objetos y guardar en binario\n2. Generar popularidad con RandomAccess\n"
							+ "3. Saber dieta con RandomAccess\n4. Generar fichero XML\n"
							+ "5. Generar fichero JSON\n6. Salir\nSelecciona una opción: ");
			int opcion = Integer.parseInt(sc.nextLine());
			switch (opcion) {
			case 1:
				ejercicio1(archivoCSV, c, archivoBin);
				break;

			case 2:
				ejercicio2(archivoBin, popularidadFile);
				break;

			case 3:
				ejercicio3(sc, popularidadFile);
				break;

			case 4:
				ejercicio4(c, cx, rXml, archivoXML);
				break;

			case 5:
				ejercicio5(c, cj, rJson, archivoJSON, mapper);
				break;
			case 6:
				System.out.println("Saliendo...");
				continuar = false;
				break;

			default:
				System.out.println("Opción no válida\n");
			}
		} while (continuar);
		sc.close();
	}

	private static void ejercicio1(File archivoCSV, ArrayList<Comida> c, File archivoBin) {
		if (archivoCSV.exists()) {
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(archivoCSV));
				String linea;
				while ((linea = br.readLine()) != null) {
					String[] partes = linea.split("#");
					c.add(new Comida(Integer.parseInt(partes[0]), partes[1], partes[2], Integer.parseInt(partes[3]),
							Double.parseDouble(partes[4]), Integer.parseInt(partes[5]), partes[6]));
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoBin))) {
				for (Comida comida : c) {
					oos.writeObject(comida);
				}
				System.out.println("Guardado en restaurantes.dat\n");
			} catch (IOException e) {
				System.out.println("Error al escribir: " + e.getMessage());
			}

		} else {
			System.err.println("Falta el archivo");
		}
	}

	private static void ejercicio2(File archivoBin, File popularidadFile) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoBin));
				RandomAccessFile archivo = new RandomAccessFile(popularidadFile, "rw")) {
			archivo.setLength(0); // Limpiar archivo antes de escribir
			int i = 0;
			while (true) {
				try {
					Comida comida = (Comida) ois.readObject();
					System.out.println(comida);
					// Escribir
					try {
						archivo.writeInt(comida.getId());
						archivo.writeDouble(comida.getValoracion());
						archivo.writeInt(comida.getNumPedidos());

						// Mover el puntero del archivo a la posición correspondiente del registro
						archivo.seek(i * 16);

						int id = archivo.readInt();
						double valoracion = archivo.readDouble();
						int numPedidos = archivo.readInt();

						System.out.println("ID: " + id);
						System.out.println("Valoración: " + valoracion);
						System.out.println("Número de pedidos: " + numPedidos);
					} catch (IOException e) {
						e.printStackTrace();
					}
					i++;
				} catch (EOFException e) {
					break;
				} catch (ClassNotFoundException e) {
					System.out.println("Clase no encontrada: " + e.getMessage());
					break;
				}
			}
		} catch (IOException e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
		System.out.println();
	}

	private static void ejercicio3(Scanner sc, File popularidadFile) {
		System.out.println("Dime el ID para buscar: ");
		int idSolicitado = Integer.parseInt(sc.nextLine());
		double popularidad = 0;
		int i = 0;
		try {
			RandomAccessFile archivo = new RandomAccessFile(popularidadFile, "r");

			while (true) {
				archivo.seek(i);
				// Leer el dni
				int id = archivo.readInt();
				if (id == idSolicitado) {
					double valoracion = archivo.readDouble();
					int numPedidos = archivo.readInt();
					String numPedidos2 = String.valueOf(numPedidos);

					popularidad = Double.parseDouble(numPedidos2) * valoracion;
					break;
				} else {
					i += 16;
				}
			}
			System.out.println("La popularidad de " + idSolicitado + " es: " + popularidad + "\n");
			archivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void ejercicio4(ArrayList<Comida> c, ComidaXML cx, RestauranteXML rXml, File archivoXML) {
		for (Comida comida : c) {
			cx = new ComidaXML(comida.getNombre(), comida.getTipoComida(), comida.getDescripcion());
			rXml.aniadirComida(cx);
		}

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(RestauranteXML.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(rXml, archivoXML);
			System.out.println("XML creado\n");
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	private static void ejercicio5(ArrayList<Comida> c, ComidaJSON cj, RestauranteJSON rJson, File archivoJSON,
			ObjectMapper mapper) {
		for (Comida comida : c) {
			cj = new ComidaJSON(comida.getId(), comida.getTiempoEntrega(), comida.getValoracion(),
					comida.getNumPedidos());
			rJson.aniadirComida(cj);
		}
		try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(archivoJSON, rJson.getlistaRestauranteJson());
			System.out.println("JSON creado\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
