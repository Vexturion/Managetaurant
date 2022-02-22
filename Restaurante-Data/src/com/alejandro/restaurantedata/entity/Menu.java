/**
 * 
 */
package com.alejandro.restaurantedata.entity;

/**
 * @author Jose Alejandro Cruz Duran clase que representa la entidad de
 *         menu en la base de datos
 */
public class Menu extends CommonEntity {
	/**
	 * identificador del menu
	 */
	private int idMenu;
	/**
	 * clave del menu
	 */
	private String clave;
	/**
	 * descripcion del menu
	 */
	private String descripcion;
	/**
	 * @return the idMenu
	 */
	public int getIdMenu() {
		return idMenu;
	}
	/**
	 * @param idMenu the idMenu to set
	 */
	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}
	/**
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}
	/**
	 * @param clave the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
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
	
}
