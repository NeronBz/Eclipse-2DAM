package Ejercicios;

public class Persona {
	private String dni;
	private String nombre;
	private int edad;
	private String curso;

	public Persona() {

	}

	public Persona(String dni, String nombre, int edad, String curso) {
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.curso = curso;
	}

	// Getters y setters
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + ", curso=" + curso + "]";
	}

}
