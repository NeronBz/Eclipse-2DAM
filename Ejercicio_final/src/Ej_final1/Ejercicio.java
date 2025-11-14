package Ej_final1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
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
		File archivoJSON = new File("src/personas.json");
		File archivoXML = new File("src/personas.xml");
		File archivoCSV = new File("src/Ej_final1_Archivos/ropa.csv");
		File archivoBin = new File("src/Ej_final1_Archivos/ropa.bin");
		File archivo3OBJ = new File("src/personas.obj");
		File contactos = new File("src/contactos.csv");
		File telefonos = new File("src/telefonos.bin");

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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoBin))) {
					for (Prenda p1 : p) {
						oos.writeInt(p1.getId());
						oos.writeUTF(p1.getNombre());
						oos.writeUTF(p1.getTalla());
						oos.writeUTF(p1.getColor());
						oos.writeInt(p1.getStock());
						oos.writeInt(p1.getPrecio());
						oos.writeInt(p1.getCoste());
						oos.writeUTF(p1.getEstado());
						oos.writeInt(p1.getDescuento());
					}

				} catch (IOException e) {
					System.out.println("Error al escribir: " + e.getMessage());
				}

				try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoBin))) {
					Prenda prendaLeida = (Prenda) ois.readObject();
					System.out.println("Prenda leído desde el fichero:");
					System.out.println(prendaLeida);
				} catch (IOException | ClassNotFoundException e) {
					System.out.println("Error al leer: " + e.getMessage());
				}
			} else {
				System.err.println("Falta el archivo");
			}
			break;

		case 2:

			break;

		case 3:

			break;
		case 4:

			break;

		case 5:

			break;

		default:
			System.out.println("Opción no válida");
		}
		sc.close();

	}

}
