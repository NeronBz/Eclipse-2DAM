package Ejercicios;
//Raúl Blázquez Ibáñez

import java.util.ArrayList;

public class Ejercicio_30 {

	public static void main(String[] args) {
		// Crea una lista de nombres de los alumnos con duplicados, añade cinco nombres
		// y muestra
		// su contenido.
		
		ArrayList<String> nombres=new ArrayList<String>();
		nombres.add("Paco");
		nombres.add("Juan");
		nombres.add("Paco");
		nombres.add("Lucía");
		nombres.add("Julian");
		
		for(String a:nombres) {			
			System.out.println(a);
		}
	}

}
