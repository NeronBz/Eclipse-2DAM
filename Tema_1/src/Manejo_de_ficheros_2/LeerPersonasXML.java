package Manejo_de_ficheros_2;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class LeerPersonasXML {
	public static void main(String[] args) {
		try {
			// Crear un nuevo objeto DocumentBuilderFactory
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			// Crear un DocumentBuilder
			DocumentBuilder builder = factory.newDocumentBuilder();
			// Cargar el archivo XML
			File archivoXML = new File("Personas.xml");
			Document documento = builder.parse(archivoXML);
			// Normalizar el documento para eliminar espacios vacíos
			documento.getDocumentElement().normalize();
			// Obtener el elemento raíz
			Element raiz = documento.getDocumentElement();
			
			// Mostrar los nodos recursivamente
			mostrarNodos(raiz, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void mostrarNodos(Node elemento, int nivel) {
		// Mostrar el nombre del elemento
		for (int k = 0; k < nivel; k++) {
			System.out.print("\t"); // Tabulación
		}
		System.out.print("Nodo: " + elemento.getNodeName());
		// Mostrar sus atributos
		if (elemento.hasAttributes()) {
			NamedNodeMap atri = elemento.getAttributes();
			for (int k = 0; k < atri.getLength(); k++) {
				System.out.print(" Atributo:" + atri.item(k).getNodeName() + ":" + atri.item(k).getNodeValue());
			}
		}
		System.out.println(""); // Salto de línea
		// Obtener los hijos del elemento
		NodeList hijos = elemento.getChildNodes();
		// Recorrer los nodos hijos
		for (int i = 0; i < hijos.getLength(); i++) {
			Node nodo = hijos.item(i);
			// Mostrar el contenido si es un nodo de texto que no está vacío
			if (nodo.getNodeType() == Node.TEXT_NODE && !nodo.getNodeValue().trim().isEmpty()) {
				// Tabulación para el contenido
				for (int k = 0; k < nivel + 1; k++) {
					System.out.print("\t");
				}
				System.out.println("Contenido: " + nodo.getNodeValue().trim());
			}
			// Si es un nodo de tipo ELEMENT_NODE, hacer la llamada recursiva
			if (nodo.getNodeType() == Node.ELEMENT_NODE) {
				mostrarNodos(nodo, nivel + 1);
			}
		}
	}
}