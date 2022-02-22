/**
 * 
 */
package com.alejandro.restauranteweb.session;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.alejandro.restauranteentities.entity.Empleado;

/**
 * @author Jose ALejandro Cruz Duran
 * clase de jsf que almacena la informacion del usuario
 */

@ManagedBean
@SessionScoped
public class SessionBean {
	/**
	 * objeto del empleado que inicia la sesion
	 */
	private Empleado empleado;

	/**
	 * @return the empleado
	 */
	public Empleado getEmpleado() {
		return empleado;
	}

	/**
	 * @param empleado the empleado to set
	 */
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
}
