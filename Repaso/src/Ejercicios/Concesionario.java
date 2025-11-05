package Ejercicios;
//Raúl Blázquez Ibáñez

public class Concesionario {

	public static void main(String[] args) {
		// Crea una clase principal llamada Concesionario donde se instancian o crean 2
		// objetos de la
		// clase vehiculo (coche1 y moto1)
		// Para el objeto coche1 los datos se inicializaran llamando al constructor con
		// parámetros
		// y le pasamos los datos directamente al constructor.
		// Para el objeto moto1 los datos se inicializaran llamando al constructor por
		// defecto (al
		// vacio) y pasaremos los datos utilizando los métodos setters de variables
		// locales
		// declaradas en el método main.

		// Continuamos con la clase principal anterior. Una vez que tenemos los 2
		// vehículos vamos a
		// mostrar los datos de cada uno de ellos por pantalla, para ello debes emplear
		// los métodos:
		// Para el coche1 los métodos get.
		// Para el moto1 el método toString.
		// Una vez mostrados los datos llamaremos al método pvp de cada objeto.
		// Pasándole el
		// beneficio que queramos pero comprendido entre 0 y 100.

		Vehiculos v1 = new Vehiculos("8739GFD", "Hyundai", 7129.00);
		Vehiculos v2 = new Vehiculos();

		v2.setMarca("BMW");
		v2.setMatricula("7523RER");
		v2.setPrecio(5841.00);

		System.out.println(v1.getMarca());
		System.out.println(v1.getMatricula());
		System.out.println(v1.getPrecio());

		System.out.println(v2.toString());

		System.out.println(v1.pvp(84));
		System.out.println(v2.pvp(31));

	}

}
