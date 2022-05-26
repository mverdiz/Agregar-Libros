package net.miguel.uf1845.dal;

import java.math.*;
import java.util.*;

import net.miguel.uf1845.modelos.*;

public class DaoLibrosMemoria implements DaoLibros {

	private static final TreeMap<Long, Libro> libros = new TreeMap<>();
	
	//Con Esta forma se puede colocar unos libros de prueba
	//De esta forma se autoincrementa libros segun la cantidad que se quiera
	/*static {
		for (long i = 1; i <= 2; i++) {
			libros.put(i, new Libro(i, "Titulo", new BigDecimal(i), new Integer((int) i)));
		}
	}*/
	
	//De esta forma se agregan libros de prueba 
	static {
		libros.put(1L,  new Libro("1", "11 minutos", "25.00", "3"));
		libros.put(2L,  new Libro("2", "Casas Muertas", "50.60", "10"));
	}

	// SINGLETON
	private DaoLibrosMemoria() {
	}

	private static final DaoLibrosMemoria INSTANCIA = new DaoLibrosMemoria();

	public static DaoLibrosMemoria getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Libro> obtenerTodos() {
		return libros.values();
	}

	
	@Override
	public Libro insertar(Libro libro) {
		Long id = libros.size() > 0 ? libros.lastKey() + 1L : 1L;
		libro.setId(id);
		libros.put(libro.getId(), libro);

		return libro;
	}
	

}
