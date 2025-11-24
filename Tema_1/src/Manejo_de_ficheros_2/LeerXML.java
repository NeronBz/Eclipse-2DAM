package Manejo_de_ficheros_2;

import java.io.File;
import org.w3c.dom.*;
import javax.xml.parsers.*;

public class LeerXML {
	public static void main(String[] args) {
		try {
			// Crear un nuevo objeto DocumentBuilderFactory
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			// Crear un DocumentBuilder
			DocumentBuilder builder = factory.newDocumentBuilder();
			// Cargar el archivo XML
			File archivoXML = new File("src/Manejo_de_ficheros_2/Docs/Personas.xml");
			Document documento = builder.parse(archivoXML);
			// Normalizar el documento para eliminar espacios vacíos
			documento.getDocumentElement().normalize();
			// Obtener el elemento raíz
			Element raiz = documento.getDocumentElement();

			// Mostrar los nodos recursivamente
			recorrerRamaDom(raiz, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void recorrerRamaDom(Node nodo, int nivel) {
		if (nodo != null && nodo.getNodeType() == Node.ELEMENT_NODE) { // Solo los nodos tipo ELEMENT NODE
			// Crear indentación en función del nivel del nodo
			String indentacion = " ".repeat(nivel * 4); // Cada nivel añade 4 espacios

			// Mostrar el nombre del nodo con indentación
			System.out.println(indentacion + "Nombre: " + nodo.getNodeName());

			// Obtener los hijos del nodo
			NodeList hijos = nodo.getChildNodes();

			// Recorrer los nodos hijos
			for (int i = 0; i < hijos.getLength(); i++) {
				Node nodoNieto = hijos.item(i);
				recorrerRamaDom(nodoNieto, nivel + 1); // Llamada recursiva,y + nivel
			}
		}
	}

}
