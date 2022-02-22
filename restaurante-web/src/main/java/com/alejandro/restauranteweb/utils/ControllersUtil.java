/**
 * 
 */
package com.alejandro.restauranteweb.utils;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * 
 * @author Jose Alejandro Cruz Duran clase que permite utilizar metodos generales para el funcionamiento de los controladores
 * 
 */
public class ControllersUtil {
	
	/**
	 * metodo que permite navegar entre pantallas
	 * @param pagina a redireccionar
	 * @throws IOException excepcion que se genera si no encuentra la pagina
	 */
	public static void redireccionar(String pagina) throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		String contextPath = ec.getRequestContextPath();
		ec.redirect(contextPath.concat(pagina));
	}
	
	/**
	 * metodo que permite mostrar un mensaje al usuario
	 * @param severity tipo de mensaje
	 * @param titulo de la ventana
	 * @param mensaje descripcion a mostrar al usuario
	 */
	public static void mostrarMensaje(Severity severity, String titulo, String mensaje) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, titulo, mensaje));
	}
	
}
