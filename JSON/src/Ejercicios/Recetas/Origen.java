package Ejercicios.Recetas;

public class Origen {
	private String pais;
	private String region;

	// Getters y setters
	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Origen [pais=" + pais + ", region=" + region + "]";
	}

}