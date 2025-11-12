package Ej_final;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "personas")
public class Personas {
	ArrayList<PersonaXML> listaPersonas = new ArrayList<PersonaXML>();

	public Personas() {
	}

	@XmlElement(name = "persona")
	public ArrayList<PersonaXML> getPersonas() {
		return listaPersonas;
	}

	public void setPersonas(ArrayList<PersonaXML> Personas) {
		listaPersonas = Personas;
	}

	public void mostrarPersonas() {
		for (PersonaXML e : listaPersonas)
			System.out.println(e.toString());
	}

	public void aniadirPersonaXML(PersonaXML e) {
		this.listaPersonas.add(e);
	}
}
