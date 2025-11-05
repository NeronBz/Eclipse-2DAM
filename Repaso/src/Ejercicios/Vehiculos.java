package Ejercicios;
//Raúl Blázquez Ibáñez

public class Vehiculos {

	// Crea la clase vehículos con los atributos: matricula, marca y precio de
	// compra. Como
	// métodos tendremos los constructores, los getters y setters, el toString y un
	// método
	// propios llamado pvp que recibe por parámetros un beneficio que será un número
	// entero
	// entre 0 y 100 y devuelve el precio de venta al público. Para calcularlo se
	// utiliza la siguiente
	// fórmula: pvp= preciocompra+((preciocompra*beneficio)/100)

	String matricula;
	String marca;
	Double precio;

	public Vehiculos() {

	}

	public Vehiculos(String matricula, String marca, Double precio) {
		this.matricula = matricula;
		this.marca = marca;
		this.precio = precio;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Vehiculos [matricula=" + matricula + ", marca=" + marca + ", precio=" + precio + "]";
	}

	public double pvp(double beneficio) {
		return this.precio + ((this.precio * beneficio) / 100);
	}

	public static void main(String[] args) {
		Vehiculos v1=new Vehiculos("1446DGV", "Audi", 14000.00);
		System.out.println(v1.pvp(23.8));

	}

}
