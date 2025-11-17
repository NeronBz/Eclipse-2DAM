package Ej_final1;

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

public class Ejercicio {

	public static void main(String[] args) throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		File archivoCSV = new File("src/Ej_final1_Archivos/ropa.csv");
		File archivoBin = new File("src/Ej_final1_Archivos/ropa.dat");
		File precios = new File("src/Ej_final1_Archivos/precio.dat");

		RopaXML ropa = new RopaXML();
		RopaJSON ropa2 = new RopaJSON();
		ArrayList<Prenda> p = new ArrayList<Prenda>();
		ObjectMapper mapper = new ObjectMapper();

		System.out.println(
				"1. Leer del CSV, crear lista de objetos y guardar en binario\n2. Saber precio final con RandomAccess\n"
						+ "3. Saber beneficio con RandomAccess\n4. Generar fichero XML\n"
						+ "5. Generar fichero JSON\n6. Salir\nSelecciona una opción: ");
		int opcion = Integer.parseInt(sc.nextLine());
		switch (opcion) {
		case 1:
			if (archivoCSV.exists()) {
				BufferedReader br;
				try {
					br = new BufferedReader(new FileReader(archivoCSV));
					String linea;
					while ((linea = br.readLine()) != null) {
						String[] partes = linea.split(";");
						p.add(new Prenda(Integer.parseInt(partes[0]), partes[1], partes[2], partes[3], partes[4],
								partes[5], Integer.parseInt(partes[6]), Integer.parseInt(partes[7]),
								Integer.parseInt(partes[8]), partes[9], Integer.parseInt(partes[10])));
					}
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

				try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoBin))) {
					for (Prenda prenda : p) {
						oos.writeObject(prenda);
					}
				} catch (IOException e) {
					System.out.println("Error al escribir: " + e.getMessage());
				}

			} else {
				System.err.println("Falta el archivo");
			}
			break;

		case 2:
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoBin));
					RandomAccessFile archivo = new RandomAccessFile(precios, "rw")) {
				archivo.setLength(0); // Limpiar archivo antes de escribir
				int i = 0;
				while (true) {
					try {
						Prenda prenda = (Prenda) ois.readObject();
						System.out.println(prenda);
						// Escribir
						try {
							archivo.writeInt(prenda.getId());
							archivo.writeInt(prenda.getPrecio());
							archivo.writeInt(prenda.getCoste());
							archivo.writeInt(prenda.getDescuento());

							// Mover el puntero del archivo a la posición correspondiente del registro
							archivo.seek(i * 16);

							int id = archivo.readInt();
							int precio = archivo.readInt();
							int coste = archivo.readInt();
							int descuento = archivo.readInt();

							System.out.println("ID: " + id);
							System.out.println("precio: " + precio);
							System.out.println("coste: " + coste);
							System.out.println("descuento: " + descuento);
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
			break;

		case 3:
			System.out.println("Dime el ID para buscar: ");
			int idSolicitado = Integer.parseInt(sc.nextLine());
			int beneficio = 0;
			int i = 0;
			try {
				RandomAccessFile archivo = new RandomAccessFile(precios, "r");

				while (true) {
					archivo.seek(i);
					// Leer el dni
					int id = archivo.readInt();
					if (id == idSolicitado) {
						int precio = archivo.readInt();
						int coste = archivo.readInt();
						int descuento = archivo.readInt();

						beneficio = precio - (precio * descuento / 100) - coste;
						break;
					} else {
						i += 16;
					}
				}
				System.out.println("El beneficio de " + idSolicitado + " es: " + beneficio);
				archivo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 4:
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoBin))) {
				while (true) {
					try {
						Prenda prenda = (Prenda) ois.readObject();

						// Crear DTO para solo los campos que quieres exportar y añadirlo a ropa
						PrendaXML px = new PrendaXML(prenda.getNombre(), prenda.getTalla(), prenda.getColor(),
								prenda.getPrecio(), prenda.getEstado());

						ropa.aniadirPrenda(px);

						System.out.println(prenda);

					} catch (EOFException e) {
						break; // Fin normal de lectura
					} catch (ClassNotFoundException e) {
						System.out.println("Clase no encontrada: " + e.getMessage());
						break;
					}
				}

			} catch (IOException e) {
				System.out.println("Error al leer: " + e.getMessage());
			}

			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(RopaXML.class);
				Marshaller marshaller = jaxbContext.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				marshaller.marshal(ropa, new File("src/Ej_final1_Archivos/ropa.xml"));
			} catch (JAXBException e) {
				e.printStackTrace();
			}

			break;

		case 5:
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoBin))) {
				while (true) {
					try {
						Prenda prenda = (Prenda) ois.readObject();
						PrendaJSON pj = new PrendaJSON(prenda.getId(), prenda.getPrecio());
						System.out.println(ropa);

						ropa2.aniadirPrenda(pj);
					} catch (EOFException e) {
						break; // Fin normal de lectura
					} catch (ClassNotFoundException e) {
						System.out.println("Clase no encontrada: " + e.getMessage());
						break;
					}
				}
			} catch (IOException e) {
				System.out.println("Error al leer: " + e.getMessage());
			}
			try {
				mapper.writeValue(new File("src/Ej_final1_Archivos/ropa.json"), ropa2.getListaRopaJson());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			System.out.println("Opción no válida");
		}
		sc.close();

	}

}
