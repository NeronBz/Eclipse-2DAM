package Ej_final1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "prenda")
@XmlType(propOrder = { "id", "nombre", "categoria", "talla", "color", "material", "stock", "precio", "coste", "estado",
		"descuento" }) // XML y JAXB
public class Prenda implements Serializable {
	private String nombre, categoria, talla, color, material, estado;
	private int id, stock, precio, coste, descuento;

	// Constructor vacío requerido por JAXB y serialización
	public Prenda() {
	}

	public Prenda(int id, String nombre, String categoria, String talla, String color, String material, int stock,
			int precio, int coste, String estado, int descuento) {
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.talla = talla;
		this.color = color;
		this.material = material;
		this.stock = stock;
		this.precio = precio;
		this.coste = coste;
		this.estado = estado;
		this.descuento = descuento;
	}

	@XmlElement
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
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
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@XmlElement
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@XmlElement
	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@XmlElement
	public int getCoste() {
		return coste;
	}

	public void setCoste(int coste) {
		this.coste = coste;
	}

	@XmlElement
	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	@Override
	public String toString() {
		return "Prenda [nombre=" + nombre + ", categoria=" + categoria + ", talla=" + talla + ", color=" + color
				+ ", material=" + material + ", estado=" + estado + ", id=" + id + ", stock=" + stock + ", precio="
				+ precio + ", coste=" + coste + ", descuento=" + descuento + "]";
	}

}
