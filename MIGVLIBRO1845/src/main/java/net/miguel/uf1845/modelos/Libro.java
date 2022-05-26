package net.miguel.uf1845.modelos;

import java.math.*;
import java.util.*;

public class Libro {
	
	private Long id;
	private String titulo;
	private BigDecimal precio;
	private Integer descuento;
	
	private TreeMap<String, String> errores = new TreeMap<>();
	
	public Libro(String id, String titulo, String precio, String descuento) {
		setId(id);
		setTitulo(titulo);
		setPrecio(precio);
		setDescuento(descuento);
	}
	
	public Libro(Long id, String titulo, BigDecimal precio, Integer descuento ) {
		setId(id);
		setTitulo(titulo);
		setPrecio(precio);
		setDescuento(descuento);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setId(String id) {
		if(id.trim().length() == 0) {
			setId((Long)null);
			return;
		}
		
		try {
			setId(Long.parseLong(id));
		} catch (Exception e) {
			errores.put("id", "No es un número");
		}
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		/*if(titulo == null || titulo.trim().length() < 2 || titulo.trim().length() > 150)*/
		if(titulo == null || titulo.trim().length() < 2) {
			errores.put("titulo", "El título debe tener más de 2 caracteres");
		} else if (titulo == null || titulo.trim().length() > 150)
			errores.put("titulo", "El título NO debe tener más de 150 caracteres");
		
		this.titulo = titulo;
	}


	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		
		//TODO comprobar 2 decimales 
		precio.setScale(2, RoundingMode.UP);
		
		if(precio.compareTo(BigDecimal.ZERO) < 0) {
			errores.put("precio", "El precio no puede ser negativo");
		}
		this.precio = precio;
	}

	public void setPrecio(String precio) {
		try {
			setPrecio(new BigDecimal(precio));
		} catch (Exception e) {
			errores.put("precio", "No es un número");
		}
	}
	
	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		if(descuento < 0 ) {
			errores.put("descuento", "El descuento no puede ser menor a 0%");
		} else if (descuento > 100){
			errores.put("descuento", "El descuento no puede ser mayor a 100%");
		}
		this.descuento = descuento;
	}
	
	public void setDescuento(String descuento) {
		try {
			setDescuento(new Integer(descuento));
		} catch (Exception e) {
			errores.put("descuento", "No es un número");
		}
	}

	public TreeMap<String, String> getErrores() {
		return errores;
	}

	public boolean tieneErrores() {
		return errores.size() > 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descuento, errores, id, precio, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(descuento, other.descuento) && Objects.equals(errores, other.errores)
				&& Objects.equals(id, other.id) && Objects.equals(precio, other.precio)
				&& Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", precio=" + precio + ", descuento=" + descuento
				+ ", errores=" + errores + "]";
	}
	
	
	
	
}
