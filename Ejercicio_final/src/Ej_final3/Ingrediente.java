package Ej_final3;

//Ingrediente.java
public class Ingrediente {
	private String nombre;
	private String cantidad;

	// Constructor vacío y con parámetros
	public Ingrediente() {
	}

	public Ingrediente(String nombre, String cantidad) {
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

}
