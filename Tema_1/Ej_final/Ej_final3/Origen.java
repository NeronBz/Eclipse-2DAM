package Ej_final3;

//Origen.java
public class Origen {
	private String pais;
	private String region;

	public Origen() {
	}

	public Origen(String pais, String region) {
		this.pais = pais;
		this.region = region;
	}
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

}
