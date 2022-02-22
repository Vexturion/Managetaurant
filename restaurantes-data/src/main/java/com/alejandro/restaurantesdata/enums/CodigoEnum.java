/**
 * 
 */
package com.alejandro.restaurantesdata.enums;

/**
 * @author Jose Alejandro Cruz enumeracion que contiene los codigos de error del
 *         aplicativo
 */
public enum CodigoEnum {
	/**
	 * constante con el codigo de error
	 */
	SITAXIS_ERROR_CODE(1064);

	/**
	 * codigo de error
	 */
	private int code;

	/**
	 * constructr privado de la enumeracion
	 * 
	 * @param code codigo de error generado
	 */
	CodigoEnum(int code) {
		this.code = code;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

}
