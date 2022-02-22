/**
 * 
 */
package com.alejandro.restaurantedata.entity;

import java.time.LocalDateTime;

/**
 * @author Jose Alejandro Cruz Duran
 * clase que contiene campos que se reutilizan en todas las clases que mapean
 * a las tablas
 */
public class CommonEntity {

	/**
	 * fecha de la creacion de tipo restaurante
	 */
	private LocalDateTime fechaCreacion;
	/**
	 * fecha de modificacion de tipo restaurante
	 */
	private LocalDateTime fechaModificacion;
	/**
	 * estado de tipo restaurante
	 */
	private boolean estatus;
	/**
	 * @return the fechaCreacion
	 */
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	/**
	 * @return the fechaModificacion
	 */
	public LocalDateTime getFechaModificacion() {
		return fechaModificacion;
	}
	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(LocalDateTime fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	/**
	 * @return the estatus
	 */
	public boolean isEstatus() {
		return estatus;
	}
	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	
}
