package Examen;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "comida")
@XmlType(propOrder = { "id", "nombre", "tipoComida", "tiempoEntrega", "valoracion", "numPedidos", "descripcion" }) // XML
																													// y
																													// JAXB
public class Comida implements Serializable {
	private String nombre, tipoComida, descripcion;
	private int id, tiempoEntrega, numPedidos;
	private double valoracion;

	// Constructor vacío requerido por JAXB y serialización
	public Comida() {
	}

	public Comida(int id, String nombre, String tipoComida, int tiempoEntrega, double valoracion, int numPedidos,
			String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.tipoComida = tipoComida;
		this.tiempoEntrega = tiempoEntrega;
		this.valoracion = valoracion;
		this.numPedidos = numPedidos;
		this.descripcion = descripcion;
	}

	@XmlElement
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement
	public String getTipoComida() {
		return tipoComida;
	}

	public void setTipoComida(String tipoComida) {
		this.tipoComida = tipoComida;
	}

	@XmlElement
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
	public int getTiempoEntrega() {
		return tiempoEntrega;
	}

	public void setTiempoEntrega(int tiempoEntrega) {
		this.tiempoEntrega = tiempoEntrega;
	}

	@XmlElement
	public int getNumPedidos() {
		return numPedidos;
	}

	public void setNumPedidos(int numPedidos) {
		this.numPedidos = numPedidos;
	}

	@XmlElement
	public double getValoracion() {
		return valoracion;
	}

	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}

}
