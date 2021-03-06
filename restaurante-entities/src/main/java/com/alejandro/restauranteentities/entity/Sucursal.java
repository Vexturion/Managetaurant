/**
 * 
 */
package com.alejandro.restauranteentities.entity;

/**
 * @author Horiz
 *
 */
public class Sucursal extends CommonEntity {
	/**
	 * id de la sucursal
	 */
	private int idSucursal;
	/**
	 * nombre de la sucursal
	 */
	private String nombre;
	/**
	 * restaurante al que pertenece la sucursal
	 */
	private Restaurante restaurante;
	/**
	 * @return the idSucursal
	 */
	public int getIdSucursal() {
		return idSucursal;
	}
	/**
	 * @param idSucursal the idSucursal to set
	 */
	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the restaurante
	 */
	public Restaurante getRestaurante() {
		return restaurante;
	}
	/**
	 * @param restaurante the restaurante to set
	 */
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

}
