import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.*;

// Modelos base para copiar y adaptar
class Libro {
	private String titulo, autor, editorial, isbn;

	public Libro() {
	}

	public Libro(String titulo, String autor, String editorial, String isbn) {
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String toString() {
		return titulo + " / " + autor + " / " + editorial + " / " + isbn;
	}
}

class LibrosContenedor {
	private List<Libro> libros = new ArrayList<>();

	public LibrosContenedor() {
	}

	public LibrosContenedor(List<Libro> libros) {
		this.libros = libros;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
}

// Métodos de utilidad para JSON:
public class repasoJSON {
	// Serializa cualquier objeto Java a JSON (string)
	public String objetoAJson(Object obj) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(obj);
	}

	// Deserializa un string JSON en objeto Java
	public <T> T jsonAObjeto(String json, Class<T> tipo) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, tipo);
	}

	// Serializa y guarda en archivo JSON
	public void guardarEnJson(File archivo, Object obj) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(archivo, obj);
	}

	// Lee y deserializa desde archivo JSON
	public <T> T leerDesdeJson(File archivo, Class<T> tipo) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(archivo, tipo);
	}

	// Añade un libro y guarda toda la lista en archivo JSON
	public void aniadirLibro(File archivo, LibrosContenedor container, Libro nuevoLibro) throws IOException {
		container.getLibros().add(nuevoLibro);
		guardarEnJson(archivo, container);
	}

	// Busca un libro por ISBN en la lista
	public Libro buscarLibroPorIsbn(List<Libro> libros, String isbn) {
		for (Libro l : libros) {
			if (l.getIsbn().equals(isbn))
				return l;
		}
		return null;
	}

	// Modifica un libro por ISBN y guarda el contenedor en archivo JSON
	public boolean modificarLibroPorIsbn(File archivo, LibrosContenedor container, String isbn, String nuevoTitulo,
			String nuevoAutor, String nuevaEditorial) throws IOException {
		Libro libro = buscarLibroPorIsbn(container.getLibros(), isbn);
		if (libro == null)
			return false;
		libro.setTitulo(nuevoTitulo);
		libro.setAutor(nuevoAutor);
		libro.setEditorial(nuevaEditorial);
		guardarEnJson(archivo, container);
		return true;
	}

	// Borra libro por ISBN y guarda toda la lista en archivo JSON
	public boolean borrarLibroPorIsbn(File archivo, LibrosContenedor container, String isbn) throws IOException {
		Libro libro = buscarLibroPorIsbn(container.getLibros(), isbn);
		if (libro == null)
			return false;
		container.getLibros().remove(libro);
		guardarEnJson(archivo, container);
		return true;
	}

	// Muestra todos los libros en el contenedor
	public void mostrarLibros(LibrosContenedor container) {
		for (Libro libro : container.getLibros()) {
			System.out.println(libro);
		}
	}
}
