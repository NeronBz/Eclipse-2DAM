package Ej_final;

import java.util.List;
import java.io.*;

public class PersonaContenedor implements Serializable {
	private List<Persona> personas;

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setRecetas(List<Persona> personas) {
		this.personas = personas;
	}
}