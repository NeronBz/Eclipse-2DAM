package Examen;

import java.io.Serializable;

public class ComidaJSON implements Serializable {
	private int id, tiempoEntrega, numPedidos;
	private double valoracion;

	public ComidaJSON() {

	}

	public ComidaJSON(int id, int tiempoEntrega, double valoracion, int numPedidos) {
		this.id = id;
		this.tiempoEntrega = tiempoEntrega;
		this.valoracion = valoracion;
		this.numPedidos = numPedidos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTiempoEntrega() {
		return tiempoEntrega;
	}

	public void setTiempoEntrega(int tiempoEntrega) {
		this.tiempoEntrega = tiempoEntrega;
	}

	public int getNumPedidos() {
		return numPedidos;
	}

	public void setNumPedidos(int numPedidos) {
		this.numPedidos = numPedidos;
	}

	public double getValoracion() {
		return valoracion;
	}

	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}

	@Override
	public String toString() {
		return "ComidaJSON [id=" + id + ", tiempoEntrega=" + tiempoEntrega + ", valoracion=" + valoracion
				+ ", numPedidos=" + numPedidos + "]";
	}

}
