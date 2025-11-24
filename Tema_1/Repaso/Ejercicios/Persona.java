package Ejercicios;
//Raúl Blázquez Ibáñez

public class Persona {
	// Crea la clase persona con los atributos: nombre, apellidos, dni, edad y
	// estado civil.
	// Como métodos tendremos los constructores, getters y setters y el toString.

	String nombre;
	String apellidos;
	String dni;
	int edad;
	String estado_civil;

	public Persona() {

	}

	public Persona(String nombre, String apellidos, String dni, int edad, String estado_civil) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.edad = edad;
		this.estado_civil = estado_civil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEstado_civil() {
		return estado_civil;
	}

	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}

	@Override
	public String toString() {
		return "Persona{" + "nombre='" + nombre + '\'' + ", apellidos='" + apellidos + '\'' + ", dni='" + dni + '\''
				+ ", edad=" + edad + '\'' + ", estado_civil=" + estado_civil + '}';

	}

}
