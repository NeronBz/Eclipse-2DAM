package Examen;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "restaurante")
public class RestauranteXML implements Serializable {
	private ArrayList<ComidaXML> listaRestaurante = new ArrayList<>();

	public RestauranteXML() {
	}

	@XmlElement(name = "comida")
	public ArrayList<ComidaXML> getlistaRestaurante() {
		return listaRestaurante;
	}

	public void setlistaRestaurante(ArrayList<ComidaXML> listaRestaurante) {
		this.listaRestaurante = listaRestaurante;
	}

	public void aniadirComida(ComidaXML comida) {
		listaRestaurante.add(comida);
	}
}
