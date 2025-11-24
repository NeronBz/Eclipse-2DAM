package Ej_final2;

import java.util.ArrayList;
import java.util.List;

public class RopaJSON {
	private List<PrendaJSON> listaRopaJson = new ArrayList<>();

	public RopaJSON() {
	}

	public List<PrendaJSON> getListaRopaJson() {
		return listaRopaJson;
	}

	public void setListaRopaJson(List<PrendaJSON> listaRopaJson) {
		this.listaRopaJson = listaRopaJson;
	}

	public void aniadirPrenda(PrendaJSON prendaJson) {
		listaRopaJson.add(prendaJson);
	}
}
