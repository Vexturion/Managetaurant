/**
 * 
 */
package com.alejandro.restaurantedata.myexceptions;

import com.alejandro.restaurantedata.enums.CodigoEnum;

/**
 * @author Jose Alejandro Cruz Duran
 * excepcion personalizada para los errores ocasionados en restaurante
 */
public class RestauranteException extends Exception {
	
	/**
	 * codigo de error generado por la excepcion
	 */

	private int errorCode;
	/**
	 * constructor default
	 */
	public RestauranteException() {
		
	}
	
	/**
	 * constructor super cargado que muestra el codigo y mensaje de error
	 * @param mensaje a mostrar al usuario
	 * @param codigoEnum codigo de error de la enumeracion
	 */
	public RestauranteException(String mensaje, CodigoEnum codigoEnum) {
		super(mensaje);
		this.errorCode = codigoEnum.getCode();
	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
}
