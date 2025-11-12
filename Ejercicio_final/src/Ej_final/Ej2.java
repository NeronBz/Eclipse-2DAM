package Ej_final;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Ej2 {

	public static void main(String[] args) {
		File archivo = new File("src/Ej_final/personas.xml");
		Personas personas = new Personas();// ArrayList de persona
		if (archivo.exists()) {
			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(Personas.class);
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				personas = (Personas) unmarshaller.unmarshal(archivo);

			} catch (JAXBException e) {
				e.printStackTrace();
			}

			for (PersonaXML p : personas.getPersonas()) {
				System.out.print("DNI: " + p.getDni());

				System.out.println();
			}
			try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/Ej_final/personas2.obj"))) {
				for (PersonaXML p : personas.getPersonas()) {
					bw.write("\nDNI: " + p.getDni());
					bw.write(", Teléfono: " + p.getTelefono());
					bw.write(", Email: " + p.getEmail());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			personas = new Personas();
		}

	}

}
