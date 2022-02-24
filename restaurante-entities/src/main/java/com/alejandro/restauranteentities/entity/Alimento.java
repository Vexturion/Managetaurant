/**
 * 
 */
package com.alejandro.restauranteentities.entity;

/**
 * @author Horiz
 *
 */
public class Alimento extends CommonEntity{

	private Integer idAlimento;
	
	private String nombre;
	
	private String imagen;
	
	private String descripcion;
	
	private Double precio;
	
	private Integer descuento;
	
	private TipoAlimento tipoAlimento;
	
	private Restaurante restaurante;
	
	private Menu menu;

	/**
	 * @return the idAlimento
	 */
	public Integer getIdAlimento() {
		return idAlimento;
	}

	/**
	 * @param idAlimento the idAlimento to set
	 */
	public void setIdAlimento(Integer idAlimento) {
		this.idAlimento = idAlimento;
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
	 * @return the precio
	 */
	public Double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	/**
	 * @return the descuento
	 */
	public Integer getDescuento() {
		return descuento;
	}

	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}

	/**
	 * @return the tipoAlimento
	 */
	public TipoAlimento getTipoAlimento() {
		return tipoAlimento;
	}

	/**
	 * @param tipoAlimento the tipoAlimento to set
	 */
	public void setTipoAlimento(TipoAlimento tipoAlimento) {
		this.tipoAlimento = tipoAlimento;
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
