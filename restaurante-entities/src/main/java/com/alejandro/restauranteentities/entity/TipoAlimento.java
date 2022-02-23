/**
 * 
 */
package com.alejandro.restauranteentities.entity;

/**
 * @author Horiz
 *
 */
public class TipoAlimento extends CommonEntity {

	private Integer idTipoAlimento;
	
	private String descripcion;

	/**
	 * @return the idTipoAlimento
	 */
	public Integer getIdTipoAlimento() {
		return idTipoAlimento;
	}

	/**
	 * @param idTipoAlimento the idTipoAlimento to set
	 */
	public void setIdTipoAlimento(Integer idTipoAlimento) {
		this.idTipoAlimento = idTipoAlimento;
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
