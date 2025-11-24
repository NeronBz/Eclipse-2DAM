package Ejercicios.Ejercicio_44;

import java.io.File;
import java.util.Scanner;
import javax.xml.bind.*;

public class Ej_44 {
	public static void main(String[] args) {
		boolean continuar = true;
		Scanner sc = new Scanner(System.in);
		Empresas empresas = new Empresas();
		File archivo = new File("src/Empresas.xml");
		if (archivo.exists()) {
			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(Empresas.class);
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				empresas = (Empresas) unmarshaller.unmarshal(archivo);
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}
		do {
			System.out.println("1 - Ver datos de las empresas");
			System.out.println("2 - Ver trabajadores");
			System.out.println("3 - Añadir trabajador (sin nifs duplicados)");
			System.out.println("4 - Modificar trabajador, por nif");
			System.out.println("5 - Borrar trabajador, por nif");
			System.out.println("6 - Salir");
			System.out.print("Elige una opción (1-6): ");
			int opcion = Integer.parseInt(sc.nextLine());
			switch (opcion) {
			case 1:
				System.out.println("Empresas disponibles: " + empresas.getEmpresas().size());
				for (Empresa emp : empresas.getEmpresas()) {
					System.out.println("\nEmpresa: " + emp.getNombre() + " (NIE: " + emp.getNie() + ")");
					Direccion d = emp.getDireccion();
					if (d != null) {
						System.out.println("Dirección: " + d.getNombreVia() + ", Nº " + d.getNumero() + ", "
								+ d.getPoblacion() + ", CP: " + d.getCp());
					}
					System.out.println("Trabajadores en la empresa: " + emp.getListaTrabajadores().size());
				}
				System.out.println();
				break;
			case 2:
				for (Empresa empresa : empresas.getEmpresas()) {
					System.out.println("-- Empresa: " + empresa.getNombre());
					for (Trabajador trabajador : empresa.getListaTrabajadores()) {
						System.out.println("   Trabajador: " + trabajador.getNombre() + " | NIF: " + trabajador.getNif()
								+ " | Cargo: " + trabajador.getCargo());
					}
				}
				System.out.println();
				break;
			case 3:
				// Aquí puedes pedir el NIE de la empresa, comprobar que existe, y luego pedir
				// los datos del trabajador
				System.out.print("Introduce el NIE de la empresa donde añadir: ");
				String nieAdd = sc.nextLine();
				Empresa empAdd = null;
				for (Empresa emp : empresas.getEmpresas()) {
					if (emp.getNie().equals(nieAdd))
						empAdd = emp;
				}
				if (empAdd == null) {
					System.out.println("Empresa no encontrada.");
				} else {
					System.out.print("NIF del trabajador: ");
					String nif = sc.nextLine();
					boolean dup = false;
					for (Trabajador t : empAdd.getListaTrabajadores())
						if (nif.equals(t.getNif()))
							dup = true;
					if (dup) {
						System.out.println("Ya existe un trabajador con ese NIF.");
					} else {
						System.out.print("Nombre: ");
						String nombre = sc.nextLine();
						System.out.print("Cargo: ");
						String cargo = sc.nextLine();
						empAdd.getListaTrabajadores().add(new Trabajador(nif, nombre, cargo));
						System.out.println("Trabajador añadido correctamente.");
					}
				}
				break;
			case 4:
				// Modificación de trabajador por NIF
				System.out.print("Introduce el NIE de la empresa: ");
				String nieMod = sc.nextLine();
				Empresa empMod = null;
				for (Empresa emp : empresas.getEmpresas()) {
					if (emp.getNie().equals(nieMod))
						empMod = emp;
				}
				if (empMod == null) {
					System.out.println("Empresa no encontrada.");
				} else {
					System.out.print("NIF del trabajador a modificar: ");
					String nifMod = sc.nextLine();
					Trabajador tMod = null;
					for (Trabajador t : empMod.getListaTrabajadores()) {
						if (nifMod.equals(t.getNif()))
							tMod = t;
					}
					if (tMod == null) {
						System.out.println("No existe ese trabajador.");
					} else {
						System.out.print("Nuevo nombre: ");
						tMod.setNombre(sc.nextLine());
						System.out.print("Nuevo cargo: ");
						tMod.setCargo(sc.nextLine());
						System.out.println("Trabajador modificado.");
					}
				}
				break;
			case 5:
				// Borrar trabajador por NIF
				System.out.print("Introduce el NIE de la empresa: ");
				String nieBor = sc.nextLine();
				Empresa empBor = null;
				for (Empresa emp : empresas.getEmpresas()) {
					if (emp.getNie().equals(nieBor))
						empBor = emp;
				}
				if (empBor == null) {
					System.out.println("Empresa no encontrada.");
				} else {
					System.out.print("NIF del trabajador a borrar: ");
					String nifBor = sc.nextLine();
					Trabajador tBorrar = null;
					for (Trabajador t : empBor.getListaTrabajadores()) {
						if (nifBor.equals(t.getNif()))
							tBorrar = t;
					}
					if (tBorrar == null) {
						System.out.println("No existe ese trabajador.");
					} else {
						empBor.getListaTrabajadores().remove(tBorrar);
						System.out.println("Trabajador eliminado correctamente.");
					}
				}
				break;
			case 6:
				// Guardar XML antes de salir
				try {
					JAXBContext jaxbContext = JAXBContext.newInstance(Empresas.class);
					Marshaller marshaller = jaxbContext.createMarshaller();
					marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
					marshaller.marshal(empresas, new File("src/Empresas.xml"));
				} catch (JAXBException e) {
					e.printStackTrace();
				}
				System.out.println("Saliendo...");
				continuar = false;
				break;
			default:
				System.out.println("Opción no válida");
			}
		} while (continuar);
		sc.close();
	}
}
