package Manejo_de_ficheros_2;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Ej_35 {

	public static void main(String[] args) {
		/*
		 * 35. Crea un documento DOM vacío, añade un nodo raíz llamado profesores, un
		 * nodo elemento llamado profesor con un atributo grupo 2DAM y un nodo texto.
		 * Muestra el resultado por consola.
		 */

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
			Element elemento1 = documento.createElement("profesores");
			Element elemento2 = documento.createElement("profesor");
			elemento2.setAttribute("grupo", "2DAM");
			Text elemento3 = documento.createTextNode("algo");
			documento.appendChild(elemento1);
			elemento1.appendChild(elemento2);
			elemento2.appendChild(elemento3);

			// Guardar en XML
			StreamResult consola = new StreamResult(System.out);
			DOMSource fuente = new DOMSource(documento);
			StreamResult ficheroXML = new StreamResult(new File("profesores.xml"));
			Transformer t = TransformerFactory.newInstance().newTransformer();
			t.setOutputProperty(OutputKeys.INDENT, "yes");
			t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			t.transform(fuente, ficheroXML);
			t.transform(fuente, consola);

			System.out.println("Datos creados");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
