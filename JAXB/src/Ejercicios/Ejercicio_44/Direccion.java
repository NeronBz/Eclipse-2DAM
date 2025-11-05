package Ejercicios.Ejercicio_44;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "nombreVia", "numero", "poblacion", "cp" })
public class Direccion {
	private String nombreVia, poblacion;
	private int numero, cp;

	public Direccion() {

	}

	public Direccion(String nombreVia, int numero, String poblacion, int cp) {
		super();
		this.nombreVia = nombreVia;
		this.numero = numero;
		this.poblacion = poblacion;
		this.cp = cp;
	}

	public String getNombreVia() {
		return nombreVia;
	}

	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int num) {
		this.numero = num;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

}
