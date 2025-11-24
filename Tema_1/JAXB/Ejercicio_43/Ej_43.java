package Ejercicios.Ejercicio_43;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import Ejercicios.Ejercicio_42.Libreria;
import Ejercicios.Ejercicio_42.Libro;

public class Ej_43 {

	public static void main(String[] args) {
		File archivo=new File("src/Libreria.xml");
		Libreria libreria=new Libreria();
		if (archivo.exists()) {
			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(Libreria.class);
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				libreria = (Libreria) unmarshaller.unmarshal(archivo);

			} catch (JAXBException e) {
				e.printStackTrace();
			}
			
			System.out.print("Librería: " + libreria.getNombre());
			System.out.print("\tLugar: " + libreria.getLugar());
			System.out.println("\tCP: " + libreria.getCp());
			System.out.println("Libros disponibles: ");
			for (Libro libro : libreria.getLibreria()) {
				System.out.print("Título: "+libro.getTitulo	());
				System.out.print("\tAutor: "+libro.getAutor());
				System.out.print("\tEditorial: "+libro.getEditorial());
				System.out.print("\tISBN: "+libro.getIsbn());
				System.out.println();
			}
		} else {
			libreria = new Libreria();
		}
	}

}
