package Ejercicios;
//Raúl Blázquez Ibáñez

public class Ejercicio_26 {

	public static void main(String[] args) {
		Persona p1 = new Persona("Pepe", "Sánchez", "74810286U", 20, "soltero");
		Persona p2 = new Persona("Carlos", "Alcaraz", "42797543P", 22, "casado");

		if (p1.edad > p2.edad) {
			System.out.println(p1.nombre + " es mayor");
		} else {
			System.out.println(p2.nombre + " es mayor");
		}

	}

}
