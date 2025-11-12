package Ej_final;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "dni", "telefono", "email" })
public class PersonaXML {
	private String dni, email;
	private int telefono;

	public PersonaXML() {

	}

	public PersonaXML(String dni, String email, int telefono) {
		this.dni = dni;
		this.email = email;
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

}
