package Ej_final2;

import java.io.Serializable;

public class PrendaJSON implements Serializable {
	private int id, precio;

	public PrendaJSON() {

	}

	public PrendaJSON(int id, int precio) {
		this.id = id;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "PrendaJSON [id=" + id + ", precio=" + precio + "]";
	}

}
