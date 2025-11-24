package Ejercicios.Ejercicio_44;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "nif", "nombre", "cargo" })
public class Trabajador {
	private String nif, nombre, cargo;

	public Trabajador() {

	}

	public Trabajador(String nif, String nombre, String cargo) {
		this.nif = nif;
		this.nombre = nombre;
		this.cargo = cargo;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
