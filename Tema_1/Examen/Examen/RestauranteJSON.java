package Examen;

import java.util.ArrayList;

public class RestauranteJSON {
	private ArrayList<ComidaJSON> listaRestauranteJson = new ArrayList<>();

	public RestauranteJSON() {
	}

	public ArrayList<ComidaJSON> getlistaRestauranteJson() {
		return listaRestauranteJson;
	}

	public void setlistaRestauranteJson(ArrayList<ComidaJSON> listaRestauranteJson) {
		this.listaRestauranteJson = listaRestauranteJson;
	}

	public void aniadirComida(ComidaJSON comidaJson) {
		listaRestauranteJson.add(comidaJson);
	}
}
