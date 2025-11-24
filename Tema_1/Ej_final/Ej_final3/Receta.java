package Ej_final3;

//Receta.java
import java.util.List;

public class Receta {
	private String nombre;
	private String tipo;
	private Origen origen;
	private List<Ingrediente> ingredientes;

	public Receta() {
	}

	public Receta(String nombre, String tipo, Origen origen, List<Ingrediente> ingredientes) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.origen = origen;
		this.ingredientes = ingredientes;
	}
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

}
