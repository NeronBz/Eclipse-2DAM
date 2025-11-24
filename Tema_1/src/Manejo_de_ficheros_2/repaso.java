package Manejo_de_ficheros_2;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.OutputKeys;
import java.io.*;
import java.util.*;

// Modelo básico para alumnos
class Alumno {
	int expediente;
	String nombre;
	double nota;

	public Alumno() {
	}

	public Alumno(int expediente, String nombre, double nota) {
		this.expediente = expediente;
		this.nombre = nombre;
		this.nota = nota;
	}

	public int getExpediente() {
		return expediente;
	}

	public void setExpediente(int expediente) {
		this.expediente = expediente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
}

public class repaso {

	// Crea un DOM vacío y guarda como XML
	public void crearDomYGuardar(String nombreRaiz, String nombreHoja, String atributo, String valorAtributo,
			String nombreArchivo) {
		try {
			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = factoria.newDocumentBuilder();
			Document documento = db.newDocument();
			documento.setXmlVersion("1.0");
			Element raiz = documento.createElement(nombreRaiz);
			Element hoja = documento.createElement(nombreHoja);
			if (atributo != null) {
				hoja.setAttribute(atributo, valorAtributo);
			}
			documento.appendChild(raiz);
			raiz.appendChild(hoja);
			DOMSource fuente = new DOMSource(documento);
			StreamResult ficheroXML = new StreamResult(new File(nombreArchivo));
			Transformer t = TransformerFactory.newInstance().newTransformer();
			t.setOutputProperty(OutputKeys.INDENT, "yes");
			t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			t.transform(fuente, ficheroXML);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Lee un archivo XML y muestra nodos y atributos con indentación
	public void mostrarArbolXML(String rutaXML) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document documento = builder.parse(new File(rutaXML));
			documento.getDocumentElement().normalize();
			Element raiz = documento.getDocumentElement();
			mostrarNodos(raiz, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Método recursivo para mostrar nodos y atributos
	public void mostrarNodos(Node nodo, int nivel) {
		if (nodo == null)
			return;
		for (int k = 0; k < nivel; k++)
			System.out.print("\t");
		System.out.print("Nodo: " + nodo.getNodeName());
		if (nodo.hasAttributes()) {
			NamedNodeMap atri = nodo.getAttributes();
			for (int k = 0; k < atri.getLength(); k++) {
				System.out.print(" Atributo:" + atri.item(k).getNodeName() + ":" + atri.item(k).getNodeValue());
			}
		}
		System.out.println("");
		NodeList hijos = nodo.getChildNodes();
		for (int i = 0; i < hijos.getLength(); i++) {
			Node hijo = hijos.item(i);
			if (hijo.getNodeType() == Node.TEXT_NODE && !hijo.getNodeValue().trim().isEmpty()) {
				for (int k = 0; k < nivel + 1; k++)
					System.out.print("\t");
				System.out.println("Contenido: " + hijo.getNodeValue().trim());
			}
			if (hijo.getNodeType() == Node.ELEMENT_NODE) {
				mostrarNodos(hijo, nivel + 1);
			}
		}
	}

	// Recoge información de alumnos por consola, guarda un XML con sus datos
	public void guardarAlumnosXML(String archivoSalida) {
		TreeMap<Integer, Alumno> datos = new TreeMap<>();
		Scanner sc = new Scanner(System.in);
		boolean continuar = true;
		try {
			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = factoria.newDocumentBuilder();
			Document documento = db.newDocument();
			documento.setXmlVersion("1.0");
			Element raiz = documento.createElement("alumnos");
			documento.appendChild(raiz);
			do {
				System.out.print("Expediente: ");
				int expediente = Integer.parseInt(sc.nextLine());
				System.out.print("Nombre: ");
				String nombre = sc.nextLine();
				System.out.print("Nota: ");
				double nota = Double.parseDouble(sc.nextLine());
				datos.put(expediente, new Alumno(expediente, nombre, nota));
				System.out.print("¿Quieres crear otro alumno? (si/no): ");
				String respuesta = sc.nextLine();
				if (!respuesta.equalsIgnoreCase("si"))
					continuar = false;
			} while (continuar);
			for (Alumno a : datos.values()) {
				Element eAlumno = documento.createElement("alumno");
				Element eExpediente = documento.createElement("numExpediente");
				Element eNombre = documento.createElement("nombreAlumno");
				Element eNota = documento.createElement("nota");
				eExpediente.appendChild(documento.createTextNode(Integer.toString(a.getExpediente())));
				eNombre.appendChild(documento.createTextNode(a.getNombre()));
				eNota.appendChild(documento.createTextNode(Double.toString(a.getNota())));
				eAlumno.appendChild(eExpediente);
				eAlumno.appendChild(eNombre);
				eAlumno.appendChild(eNota);
				raiz.appendChild(eAlumno);
			}
			sc.close();
			DOMSource fuente = new DOMSource(documento);
			StreamResult ficheroXML = new StreamResult(new File(archivoSalida));
			Transformer t = TransformerFactory.newInstance().newTransformer();
			t.setOutputProperty(OutputKeys.INDENT, "yes");
			t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			t.transform(fuente, ficheroXML);
			System.out.println("Datos creados correctamente");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Normaliza y recorre todo el árbol XML mostrando los nombres de los nodos
	public void recorrerArbolSimpleXML(String rutaArchivo) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new File(rutaArchivo));
			doc.getDocumentElement().normalize();
			recorrerNodosSimple(doc.getDocumentElement(), 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Versión simple del recorrido de nodos (nombre e indentación)
	public void recorrerNodosSimple(Node nodo, int nivel) {
		if (nodo != null && nodo.getNodeType() == Node.ELEMENT_NODE) {
			String indent = " ".repeat(nivel * 4);
			System.out.println(indent + "Nombre: " + nodo.getNodeName());
			NodeList hijos = nodo.getChildNodes();
			for (int i = 0; i < hijos.getLength(); i++) {
				recorrerNodosSimple(hijos.item(i), nivel + 1);
			}
		}
	}
}
