package Manejo_de_ficheros_2;

public class Alumno {

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
