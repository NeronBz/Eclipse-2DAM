package Ejercicios;

import java.util.ArrayList;
import java.util.Arrays;

public class Alumno {

	/*
	 * Implementaremos la clase Alumno con una serie de atributos y métodos.
	 * Atributos: Expediente, ocho dígitos. Nombre, un texto de 20 caracteres.
	 * Apellidos una texto de 40 caracteres. Notas, estructura de almacenamiento de
	 * notas numéricas con decimales. Esta estructura por lo tanto tendrá datos
	 * donde puede haber duplicados, el orden no es importante y su función
	 * principal no es de búsquedas Los métodos de la clase Alumno serán los métodos
	 * set y get para cada atributo y el método toString. Además: Un método
	 * añadirNota que recibe como parámetro un número con decimal, el método lo debe
	 * añadir a la estructura de almacenamiento notas. El método calcularNota que
	 * hace la media de todas las notas guardadas en la estructura de almacenamiento
	 * notas. Para ello sumamos todas las notas y las dividiremos por el número
	 * total de notas introducidas.
	 */

	int expediente;
	String nombre;
	String apellidos;
	ArrayList<Double> notas;

	public Alumno() {
		this.notas = new ArrayList<>();
	}

	public Alumno(int expediente, String nombre, String apellidos, ArrayList<Double> notas) {
		this.expediente = expediente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.notas = notas;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public ArrayList<Double> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Double> notas) {
		this.notas = notas;
	}

	@Override
	public String toString() {
		return "Alumno [expediente=" + expediente + ", nombre=" + nombre + ", apellidos=" + apellidos + ", notas="
				+ notas.toString() + "]";
	}

	public void anadirNota(double num) {
		if (num >= 0 && num <= 10) {
			notas.add(num);
		} else {
			System.out.println("Nota inválida: " + num + ". Debe estar entre 0 y 10.");
		}
	}

	public double calcularNota() {
		double sum = 0;

		if (notas.isEmpty()) {
			return 0.0;
		} else {
			for (Double nota : notas) {
				sum += nota;
			}
		}
		return sum / notas.size();
	}

}
