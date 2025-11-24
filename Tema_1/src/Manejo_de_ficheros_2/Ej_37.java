package Manejo_de_ficheros_2;

import java.util.Scanner;
import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

import org.w3c.dom.*;

public class Ej_37 {

	public static void main(String[] args) {
		/*
		 * 37. Crea un programa que nos solicite por consola el expediente, nombre del
		 * alumno y su nota hasta que le indiquemos salir. Los datos no tendrán
		 * duplicados y estarán ordenados por expediente. Para mantener la persistencia
		 * de los datos se guardarán en un fichero notasAlumno.xml con el siguiente
		 * resultado:
		 */

		TreeMap<Integer, Alumno> datos = new TreeMap<Integer, Alumno>();
		Scanner sc = new Scanner(System.in);
		boolean continuar = true;
		try {
			// Creamos la factoría
			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
			// Creamos el DocumentBuilder
			DocumentBuilder db = factoria.newDocumentBuilder();
			// Creamos un DOM vacío
			Document documento = db.newDocument();
			// Establecemos la versión
			documento.setXmlVersion("1.0");
			// Creamos elementos y añadimos al DOM
			Element elemento1 = documento.createElement("alumnos");
			documento.appendChild(elemento1);

			do {
				System.out.println("Indica el expediente: ");
				int expediente = Integer.parseInt(sc.nextLine());
				System.out.println("Indica el nombre del alumno: ");
				String nombre = sc.nextLine();
				System.out.println("Indica la nota: ");
				double nota = Double.parseDouble(sc.nextLine());

				datos.put(expediente, new Alumno(expediente, nombre, nota));

				System.out.println("¿Quieres crear otro alumno?: ");
				String respuesta = sc.nextLine();

				if (!respuesta.equalsIgnoreCase("si")) {
					continuar = false;
				}
			} while (continuar);

			for (Alumno a : datos.values()) {
				Element eAlumno = documento.createElement("alumno");
				Element eExpediente = documento.createElement("numExpediente");
				Element eNombre = documento.createElement("nombreAlumno");
				Element eNota = documento.createElement("nota");

				Text tExpediente = documento.createTextNode(Integer.toString(a.getExpediente()));
				Text tNombre = documento.createTextNode(a.getNombre());
				Text tNota = documento.createTextNode(Double.toString(a.getNota()));

				elemento1.appendChild(eAlumno);
				eAlumno.appendChild(eExpediente);
				eAlumno.appendChild(eNombre);
				eAlumno.appendChild(eNota);
				eExpediente.appendChild(tExpediente);
				eNombre.appendChild(tNombre);
				eNota.appendChild(tNota);
			}
			sc.close();

			//Guardar en XML
			DOMSource fuente = new DOMSource(documento);
			StreamResult ficheroXML = new StreamResult(new File("notasAlumno.xml"));
			Transformer t = TransformerFactory.newInstance().newTransformer();
			t.setOutputProperty(OutputKeys.INDENT, "yes");
			t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			t.transform(fuente, ficheroXML);
			
			System.out.println("Datos creados");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
