package Ej_final1;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ropa")
public class RopaXML implements Serializable {
	private ArrayList<PrendaXML> listaRopa = new ArrayList<>();

	public RopaXML() {
	}

	@XmlElement(name = "prenda")
	public ArrayList<PrendaXML> getListaRopa() {
		return listaRopa;
	}

	public void setListaRopa(ArrayList<PrendaXML> listaRopa) {
		this.listaRopa = listaRopa;
	}

	public void aniadirPrenda(PrendaXML prenda) {
		listaRopa.add(prenda);
	}
}