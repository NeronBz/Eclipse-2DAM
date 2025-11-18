package Ej_final;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Ejercicio {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File archivoJSON = new File("src/Ej_final2_Archivos/personas.json");
		File archivoXML = new File("src/Ej_final2_Archivos/personas.xml");
		File archivo1OBJ = new File("src/Ej_final2_Archivos/persona1.obj");
		File archivo2OBJ = new File("src/Ej_final2_Archivos/persona2.obj");
		File archivo3OBJ = new File("src/Ej_final2_Archivos/personas.obj");
		File contactos = new File("src/Ej_final2_Archivos/contactos.csv");
		File telefonos = new File("src/Ej_final2_Archivos/telefonos.bin");

		TreeMap<String, Persona> personasXML = new TreeMap<>();
		TreeMap<String, Persona> personasJSON = new TreeMap<>();
		TreeMap<String, Persona> personasTotal = new TreeMap<>();

		ObjectMapper mapper = new ObjectMapper();

		if (archivoJSON.exists() && archivoXML.exists()) {
			System.out.println("1. Leer del JSON\n2. Leer del XML\n3. Unificar ficheros\n4. Generar fichero CSV\n"
					+ "5. Generar fichero de acceso aleatorio\n6. Buscar en fichero de acceso aleatorio\n7. Salir\nSelecciona una opción: ");
			int opcion = Integer.parseInt(sc.nextLine());
			switch (opcion) {
			case 1:
				try {
					Personas listaPersonas = mapper.readValue(archivoJSON, Personas.class);
					escribirPersonasEnObj(archivo1OBJ, listaPersonas.getPersonas());
					leerYMostrarPersonasDeObj(archivo1OBJ);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case 2:
				JAXBContext jaxbContext;
				Personas personas = new Personas();
				try {
					jaxbContext = JAXBContext.newInstance(Personas.class);
					Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
					personas = (Personas) unmarshaller.unmarshal(archivoXML);
				} catch (JAXBException e) {
					e.printStackTrace();
				}
				escribirPersonasEnObj(archivo2OBJ, personas.getPersonas());
				leerYMostrarPersonasDeObj(archivo2OBJ);
				break;

			case 3:
				try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo1OBJ))) {
					while (true) {
						try {
							Persona persona = (Persona) ois.readObject();
							personasJSON.put(persona.getDni(), persona);
						} catch (EOFException e) {
							break;
						} catch (ClassNotFoundException e) {
							System.out.println("Clase no encontrada: " + e.getMessage());
							break;
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

				try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo2OBJ))) {
					while (true) {
						try {
							Persona persona = (Persona) ois.readObject();
							personasXML.put(persona.getDni(), persona);
						} catch (EOFException e) {
							break;
						} catch (ClassNotFoundException e) {
							System.out.println("Clase no encontrada: " + e.getMessage());
							break;
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

				personasTotal = fusionarPersonasPorCampos(personasJSON, personasXML);

				for (Persona p : personasTotal.values()) {
					System.out.println(p);
				}

				try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo3OBJ))) {
					for (Persona persona : personasTotal.values()) {
						oos.writeObject(persona);
					}
				} catch (IOException e) {
					System.out.println("Error al escribir en obj: " + e.getMessage());
				}

				break;
			case 4:
				try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo3OBJ));
						BufferedWriter bw = new BufferedWriter(new FileWriter(contactos, true))) {
					while (true) {
						try {
							Persona persona = (Persona) ois.readObject();
							System.out.println(persona);
							bw.write(persona.getNombre() + ", " + persona.getEmail());
							bw.newLine();
						} catch (EOFException e) {
							break;
						} catch (ClassNotFoundException e) {
							System.out.println("Clase no encontrada: " + e.getMessage());
							break;
						}
					}
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

				break;

			case 5:

				try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo3OBJ));
						RandomAccessFile archivo = new RandomAccessFile(telefonos, "rw")) {
					archivo.setLength(0); // Limpiar archivo antes de escribir

					int i = 0;
					while (true) {
						try {
							Persona persona = (Persona) ois.readObject();
							System.out.println(persona);
							// Escribir
							escribirDniYTlf(archivo, persona.getDni(), persona.getTelefono());
							// Leer
							leerDniYTlf(archivo, i);
							i++;
						} catch (EOFException e) {
							break;
						} catch (ClassNotFoundException e) {
							System.out.println("Clase no encontrada: " + e.getMessage());
							break;
						}
					}

				} catch (IOException e) {
					e.printStackTrace();
				}

				break;

			case 6:
				int telefono = 0;
				System.out.println("Dime el DNI para buscar el teléfono que quieras: ");
				String dniSolicitado = sc.nextLine();
				int i = 0;
				try {
					RandomAccessFile archivo = new RandomAccessFile(telefonos, "r");

					archivo.seek(i);
					while (true) {
						// Leer el dni
						byte[] dniBytes = new byte[9]; // creamos temporalmente un array de x bytes
						archivo.readFully(dniBytes); // leemos ese array de byte
						String dni = new String(dniBytes).trim(); // Eliminar espacios en blanco a derecha/izquierda
						if (dni.equalsIgnoreCase(dniSolicitado)) {
							telefono = archivo.readInt();
							break;
						} else {
							archivo.seek((i + 13));
						}
					}
					System.out.println("El teléfono de " + dniSolicitado + " es: " + telefono);
					archivo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("Opción no válida");
			}
			sc.close();

		} else {
			System.err.println("Falta algún archivo");
		}

	}

	private static void escribirPersonasEnObj(File archivoObj, ArrayList<Persona> listaPersonas) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoObj))) {
			for (Persona persona : listaPersonas) {
				oos.writeObject(persona);
			}
		} catch (IOException e) {
			System.out.println("Error al escribir en obj: " + e.getMessage());
		}
	}

	private static void leerYMostrarPersonasDeObj(File archivoObj) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoObj))) {
			while (true) {
				try {
					Persona persona = (Persona) ois.readObject();
					System.out.println(persona);
				} catch (EOFException e) {
					break;
				} catch (ClassNotFoundException e) {
					System.out.println("Clase no encontrada: " + e.getMessage());
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static TreeMap<String, Persona> fusionarPersonasPorCampos(TreeMap<String, Persona> mapaJSON,
			TreeMap<String, Persona> mapaXML) {
		TreeMap<String, Persona> resultado = new TreeMap<>(mapaJSON);

		for (Map.Entry<String, Persona> entrada : mapaXML.entrySet()) {
			String dni = entrada.getKey();
			Persona personaXML = entrada.getValue();

			if (resultado.containsKey(dni)) {
				Persona personaJSON = resultado.get(dni);

				// Combina todos los campos: usa los datos de XML para campos que JSON no tiene
				personaJSON.setTelefono(personaXML.getTelefono());
				personaJSON.setEmail(personaXML.getEmail());

				resultado.put(dni, personaJSON);
			} else {
				// Si no está en JSON, agrega el que viene de XML
				resultado.put(dni, personaXML);
			}
		}

		return resultado;
	}

	private static void escribirDniYTlf(RandomAccessFile archivo, String dni, int tlf) {
		try {
			archivo.writeBytes(dni); // Dni //writeBytes cada caracter no Unicode ocupa 1 byte
			archivo.writeInt(tlf); // Teléfono
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void leerDniYTlf(RandomAccessFile archivo, int indice) {
		try {
			// Mover el puntero del archivo a la posición correspondiente del registro
			archivo.seek(indice * 13);

			// Leer el dni
			byte[] dniBytes = new byte[9]; // creamos temporalmente un array de x bytes
			archivo.readFully(dniBytes); // leemos ese array de byte
			String dni = new String(dniBytes).trim(); // Eliminar espacios en blanco a derecha/izquierda

			int tlf = archivo.readInt();

			System.out.println("DNI: " + dni);
			System.out.println("Teléfono: " + tlf);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
