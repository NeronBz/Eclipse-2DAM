package Manejo_de_ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

import Ejercicios.Alumno;

public class repaso {
	/*
	 * File del 1 al 10;
	 * Buffered (flujos o stream) del 11 al 20;
	 * DataStream (streams de bytes) del 21 al 25;
	 * Objetos en archivos binario del 26 al 30;
	 * Ficheros de acceso aleatorio del 31 al 33;
	 */
	Scanner sc = new Scanner(System.in);

	//Lista con duplicados:
	ArrayList<String> nombres = new ArrayList<String>();
	//Lista sin duplicados:
	HashSet<String> casas = new HashSet<String>();
	//Lista sin duplicados y ordenados por el orden de inserción:
	LinkedHashSet<String> niveles = new LinkedHashSet<String>();
	//Lista sin duplicados y ordenados por el grupo:
	TreeSet<String> archivos = new TreeSet<String>();
	//Lista sin duplicados y ordenados por el orden de inserción clave-valor:
	LinkedHashMap<String, Alumno> lista = new LinkedHashMap<String, Alumno>();

	File archivo = new File(ruta);

	for(
	File f:archivos)
	{
		String permisos = "";
		permisos += f.canRead() ? "r" : "-";
		permisos += f.canWrite() ? "w" : "-";
		permisos += f.canExecute() ? "x" : "-";
		if (f.isDirectory()) {
			System.out.println(f.getName() + " - " + " es una carpeta con permisos: " + permisos);
		} else if (f.isFile()) {
			System.out.println(f.getName() + " - " + " es un archivo con permisos: " + permisos);
		}

	}Arrays.sort(hijos,Comparator.comparingLong(File::length));

	BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero, true));

	FileReader fr = new FileReader(fichero);
	int c;while((c=fr.read())!=-1)
	{
		System.out.print((char) c);
	}

	BufferedReader br = new BufferedReader(new FileReader(fichero));
	String linea;while((linea=br.readLine())!=null)
	{
		System.out.println(linea);
	}

	try(
	DataOutputStream dos = new DataOutputStream(new FileOutputStream(archivo)))
	{
		dos.writeByte(num);
	}catch(
	IOException e)
	{
		e.printStackTrace();
	}

	try(
	DataInputStream dis = new DataInputStream(new FileInputStream(archivo)))
	{
		char caracter = (char) dis.readByte();
		System.out.println("Caracter en la tabla Ascii: " + caracter);
	}catch(
	IOException e)
	{
		e.printStackTrace();
	}

	Empleado empInicial = new Empleado("12345678A", "Paco", 3000);

	try(
	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta)))
	{
		oos.writeObject(empInicial);
		System.out.println("Empleado guardado correctamente en " + ruta);
	}catch(
	IOException e)
	{
		System.out.println("Error al escribir el empleado: " + e.getMessage());
	}

	try(
	ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta)))
	{
		Empleado empLeido = (Empleado) ois.readObject();
		System.out.println("Empleado leído desde el fichero:");
		System.out.println(empLeido);
	}catch(IOException|
	ClassNotFoundException e)
	{
		System.out.println("Error al leer el empleado: " + e.getMessage());
	}

}

}
