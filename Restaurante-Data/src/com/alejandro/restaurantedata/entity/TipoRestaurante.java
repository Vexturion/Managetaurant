/**
 * 
 */
package com.alejandro.restaurantedata.entity;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Jose Alejandro Cruz Duran
 * Clase que reporesenta una entidad de tipo restaurante en la base de datos
 *
 */
public class TipoRestaurante extends CommonEntity {
	
	/**
	 * id de tipo restaurante
	 */
	private int idTipoRestaurante;
	/**
	 * descripcion de tipo restaurante
	 */
	private String descripcion;
	
	public List<Restaurante> restaurantes;

	/**
	 * @return the idTipoRestaurante
	 */
	public int getIdTipoRestaurante() {
		return idTipoRestaurante;
	}

	/**
	 * @param idTipoRestaurante the idTipoRestaurante to set
	 */
	public void setIdTipoRestaurante(int idTipoRestaurante) {
		this.idTipoRestaurante = idTipoRestaurante;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
	/**
	 * @return the restaurantes
	 */
	public List<Restaurante> getRestaurantes() {
		return restaurantes;
	}

	/**
	 * @param restaurantes the restaurantes to set
	 */
	public void setRestaurantes(List<Restaurante> restaurantes) {
		this.restaurantes = restaurantes;
	}
}
