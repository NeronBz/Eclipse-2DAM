package Ejercicios.Recetas;

import java.util.List;

public class Receta {
	private String nombre;
	private String tipo;
	private Origen origen;
	private List<Ingrediente> ingredientes;

	// Getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Origen getOrigen() {
		return origen;
	}

	public void setOrigen(Origen origen) {
		this.origen = origen;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	@Override
	public String toString() {
		return "Receta{" + "nombre='" + nombre + '\'' + ", tipo='" + tipo + '\'' + ", origen=" + origen
				+ ", ingredientes=" + ingredientes + '}';
	}

}