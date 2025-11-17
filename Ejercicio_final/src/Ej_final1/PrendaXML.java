package Ej_final1;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "prenda")
public class PrendaXML implements Serializable {
	private String nombre;
	private String talla;
	private String color;
	private int precio;
	private String estado;

	// Constructor vacío requerido para JAXB
	public PrendaXML() {
	}

	// Constructor para copiar datos desde Prenda original
	public PrendaXML(String nombre, String talla, String color, int precio, String estado) {
		this.nombre = nombre;
		this.talla = talla;
		this.color = color;
		this.precio = precio;
		this.estado = estado;
	}

	@XmlElement
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement
	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	@XmlElement
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@XmlElement
	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@XmlElement
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
