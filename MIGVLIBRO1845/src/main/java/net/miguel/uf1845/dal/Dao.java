package net.miguel.uf1845.dal;

public interface Dao<T> {
	Iterable<T> obtenerTodos();	
	T insertar(T objeto);
}
