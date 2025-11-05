package Ejercicios;
//Raúl Blázquez Ibáñez

import Ejercicios.Persona;

public class Ejercicio_23 {

	public static void main(String[] args) {
		// Recorre un array de cinco objetos

		Persona personas[] = new Persona[4];
		personas[0] = new Persona("Pepe", "Sánchez", "74810286U", 21, "soltero");
		personas[1] = new Persona("Juan", "A", "74810286U", 20, "soltero");
		personas[2] = new Persona("María", "B", "74810286U", 22, "casada");
		personas[3] = new Persona("Luis", "C", "74810286U", 23, "soltero");

		for (int i = 0; i < personas.length; i++) {
			System.out.println(personas[i].toString());
		}
		
		for (Persona p:personas) {
			System.out.println(p.toString());
		}

	}

}
