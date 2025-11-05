package Manejo_de_ficheros;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ej_27 {

	public static void main(String[] args) {
		/*
		 * 27. Utilizando la clase empleado crea un programa que permita gestionar los
		 * empleados utilizando un fichero. El programa debe permitir: 1. Dar de alta
		 * empleados 2. Buscar empleados (a partir del dni) 3. Listar empleados 4.
		 * Borrar empleado (por el dni) 5. Salir El fichero de datos empleados.bin
		 * contendrá objetos empleados.
		 */

		boolean continuar = true;
		Scanner teclado = new Scanner(System.in);

		do {
			System.out.println("\n--- MENÚ DE EMPLEADOS ---");
			System.out.println("1 - Dar de alta empleados");
			System.out.println("2 - Buscar empleado (DNI)");
			System.out.println("3 - Listar empleados");
			System.out.println("4 - Borrar empleado (DNI)");
			System.out.println("5 - Salir");
			System.out.print("Elige una opción (1-5): ");
			int opcion = Integer.parseInt(teclado.nextLine());

			switch (opcion) {
			case 1:
				System.out.print("Nombre del empleado: ");
				String nombre = teclado.nextLine();

				System.out.print("DNI del empleado: ");
				String dni = teclado.nextLine();

				System.out.print("Salario del empleado: ");
				double salario = Double.parseDouble(teclado.nextLine());

				Empleado nuevo = new Empleado(dni, nombre, salario);

				try {
					File f = new File("empleados.bin");
					ObjectOutputStream oos;
					if (f.exists()) {
						oos = new MiObjectOutputStream(new FileOutputStream(f, true));
					} else {
						oos = new ObjectOutputStream(new FileOutputStream(f, true));
					}
					oos.writeObject(nuevo);
					oos.close();
					System.out.println("Empleado añadido correctamente");
				} catch (IOException e) {
					System.out.println("Error al guardar el empleado: " + e.getMessage());
				}
				break;

			case 2:
				System.out.print("DNI a buscar: ");
				String dniBuscar = teclado.nextLine();
				boolean encontrado = false;

				try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("empleados.bin"))) {
					while (true) {
						Empleado emp = (Empleado) ois.readObject();
						if (emp.getDni().equalsIgnoreCase(dniBuscar)) {
							System.out.println("Empleado encontrado: " + emp);
							encontrado = true;
						}
					}
				} catch (EOFException eof) {
					if (!encontrado)
						System.out.println("No se encontró ningún empleado con ese DNI");
				} catch (Exception e) {
					System.out.println("Error leyendo el archivo: " + e.getMessage());
				}
				break;

			case 3:
				try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("empleados.bin"))) {
					System.out.println("\n--- LISTA DE EMPLEADOS ---");
					while (true) {
						Empleado emp = (Empleado) ois.readObject();
						System.out.println(emp);
					}
				} catch (EOFException eof) {
					// Fin del fichero
				} catch (FileNotFoundException e) {
					System.out.println("El archivo no existe");
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
				}
				break;

			case 4:
				System.out.print("DNI del empleado a borrar: ");
				String dniBorrar = teclado.nextLine();

				ArrayList<Empleado> listaTemp = new ArrayList<>();
				boolean borrado = false;

				try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("empleados.bin"))) {
					while (true) {
						Empleado emp = (Empleado) ois.readObject();
						if (!emp.getDni().equalsIgnoreCase(dniBorrar)) {
							listaTemp.add(emp);
						} else {
							borrado = true;
						}
					}
				} catch (EOFException eof) {
					// Fin del fichero
				} catch (FileNotFoundException e) {
					System.out.println("El archivo no existe");
					break;
				} catch (Exception e) {
					System.out.println("Error leyendo el archivo: " + e.getMessage());
				}

				if (borrado) {
					try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("empleados.bin"))) {
						for (Empleado e : listaTemp) {
							oos.writeObject(e);
						}
						System.out.println("Empleado eliminado correctamente");
					} catch (IOException e) {
						System.out.println("Error reescribiendo el archivo: " + e.getMessage());
					}
				} else {
					System.out.println("No se encontró ningún empleado con ese DNI.");
				}
				break;

			case 5:
				System.out.println("Saliendo...");
				continuar = false;
				break;

			default:
				System.out.println("Opción no válida");
			}
		} while (continuar);

	}
}
