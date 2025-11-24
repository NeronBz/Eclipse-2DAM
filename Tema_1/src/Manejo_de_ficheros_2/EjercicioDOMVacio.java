package Manejo_de_ficheros_2;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;

public class EjercicioDOMVacio {
	public static void main(String[] args) throws TransformerFactoryConfigurationError, TransformerException {
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
			Element elemento = documento.createElement("raiz");
			Element elemento1 = documento.createElement("hoja");
			// Añadimos elemento raíz al documento
			documento.appendChild(elemento);
			// Añadir un nodo elemento como hijo de otro elemento
			elemento.appendChild(elemento1);
			// Añadir atributos a elemento
			elemento1.setAttribute("nombre", "valor");
			// 1.Crear una fuente/origen con el árbol DOM
			DOMSource fuente = new DOMSource(documento);
			// 2.Crear el destino de la transformación:
			StreamResult ficheroXML = new StreamResult(new File("salidaVacio.xml"));

			// 2.1.Si queremos mostrar por consola
			// StreamResult consola = new StreamResult(System.out);
			// 3.Crear un transformador:
			Transformer t = TransformerFactory.newInstance().newTransformer();
			// 4.Mejoramos el forma
			t.setOutputProperty(OutputKeys.INDENT, "yes");
			t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			// 5.Transformar la fuente en el resultado
			t.transform(fuente, ficheroXML);
			// 5.1. Si queremos mostrar por consola
			// t.transform(fuente, consola);
		} catch (ParserConfigurationException e) {
		}
	}
}