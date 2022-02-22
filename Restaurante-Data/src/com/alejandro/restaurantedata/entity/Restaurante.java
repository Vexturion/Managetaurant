/**
 * 
 */
package com.alejandro.restaurantedata.entity;

/**
 * @author Jose Alejandro Cruz Duran
 * Clase que representa una entidad restaurante en la base de datos
 */
public class Restaurante extends CommonEntity {
/**
 * id del restaurante
 */
	private int idRestaurante;
	/**
	 * nombre del restaurante
	 */
	private String nombre;
	/**
	 * imagen del restaurante
	 */
	private String imagen;
	/**
	 * slogan del restaurante
	 */
	private String slogan;
	/**
	 * tipo del restaurante
	 */
	private TipoRestaurante  tipoRestaurante;
	/**
	 * menu del restaurante
	 */
	private Menu menu;
	/**
	 * @return the idRestaurante
	 */
	public int getIdRestaurante() {
		return idRestaurante;
	}
	/**
	 * @param idRestaurante the idRestaurante to set
	 */
	public void setIdRestaurante(int idRestaurante) {
		this.idRestaurante = idRestaurante;
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
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}
	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	/**
	 * @return the slogan
	 */
	public String getSlogan() {
		return slogan;
	}
	/**
	 * @param slogan the slogan to set
	 */
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	/**
	 * @return the tipoRestaurante
	 */
	public TipoRestaurante getTipoRestaurante() {
		return tipoRestaurante;
	}
	/**
	 * @param tipoRestaurante the tipoRestaurante to set
	 */
	public void setTipoRestaurante(TipoRestaurante tipoRestaurante) {
		this.tipoRestaurante = tipoRestaurante;
	}
	/**
	 * @return the menu
	 */
	public Menu getMenu() {
		return menu;
	}
	/**
	 * @param menu the menu to set
	 */
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
}
