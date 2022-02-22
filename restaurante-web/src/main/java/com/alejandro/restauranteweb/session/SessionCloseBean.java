/**
 * 
 */
package com.alejandro.restauranteweb.session;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.alejandro.restauranteweb.utils.ControllersUtil;

/**
 * @author Jose Alejandro Cruz Duran
 * clase que permite cerrar la sesion del usuario
 */
@ManagedBean
@ViewScoped
public class SessionCloseBean {

	/**
	 * metodo que nos permite cerrar la sesion del usuario
	 */
	public void cerrarSesion() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
		try {
			ControllersUtil.redireccionar("/login.xhtml");
		} catch (IOException e) {
			ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_FATAL, "Ups ", "Hubo un problema al redirigirte a la pantalla de login, favor de volver a la pantalla de inicio");
			e.printStackTrace();
		}
	}
	
}
