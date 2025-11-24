package Ej_final;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "personas")
public class Personas implements Serializable {
	private ArrayList<Persona> listaPersonas = new ArrayList<>();

	public Personas() {
	}

	@XmlElement(name = "persona")
	public ArrayList<Persona> getPersonas() {
		return listaPersonas;
	}

	public void setPersonas(ArrayList<Persona> personas) {
		this.listaPersonas = personas;
	}

	// Métodos de utilidad
	public void mostrarPersonas() {
		for (Persona e : listaPersonas)
			System.out.println(e);
	}

	public void aniadirPersona(Persona persona) {
		listaPersonas.add(persona);
	}
}
