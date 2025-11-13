package Ej_final2;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "persona")
@XmlType(propOrder = { "dni", "nombre", "edad", "email", "telefono" }) // XML y JAXB
public class Persona implements Serializable {
	private String dni;
	private String nombre;
	private int edad;
	private String email;
	private int telefono;

	// Constructor vacío requerido por JAXB y serialización
	public Persona() {
	}

    // Constructor para JSON: dni, nombre, edad
    public Persona(String dni, String nombre, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    // Constructor para XML: dni, email, telefono
    public Persona(String dni,  int telefono, String email) {
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
    }

	// Getters y setters
	@XmlElement
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@XmlElement
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@XmlElement
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@XmlElement
	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + ", email=" + email + ", telefono="
				+ telefono + "]";
	}
}
