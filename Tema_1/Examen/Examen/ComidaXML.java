package Examen;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "nombre", "tipoComida", "descripcion" })
public class ComidaXML implements Serializable {
	private String nombre, tipoComida, descripcion;

	public ComidaXML() {

	}

	public ComidaXML(String nombre, String tipoComida, String descripcion) {
		this.nombre = nombre;
		this.tipoComida = tipoComida;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoComida() {
		return tipoComida;
	}

	public void setTipoComida(String tipoComida) {
		this.tipoComida = tipoComida;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "ComidaXML [nombre=" + nombre + ", tipoComida=" + tipoComida + ", descripcion=" + descripcion + "]";
	}

}
