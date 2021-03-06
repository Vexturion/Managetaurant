/**
 * 
 */
package com.alejandro.restauranteweb.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.alejandro.restauranteentities.entity.Empleado;
import com.alejandro.restauranteservice.services.LoginService;
import com.alejandro.restauranteweb.session.SessionBean;
import com.alejandro.restauranteweb.utils.ControllersUtil;

/**
 * @author Jose Alejandro Cruz Duran siempre agregar @managedBean a una clase
 *         para realizar este proceso (comunicar con una pantalla)
 *
 */
@ManagedBean
@ViewScoped
public class LoginController {
	/**
	 * usuario capturado por el usuario final
	 */
	private String username;
	/**
	 * usuario capturado por usuario final
	 */
	private String password;
	/**
	 * es super admin general?
	 */
	private boolean superAdminGeneral;

	/**
	 * objeto que mantiene la informacion en sesion del aplicativo
	 */
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;

	private LoginService loginService = new LoginService();

	public void entrar() {

		try {
			Empleado empleadoConsultado = this.loginService.consultarPorUsuarioYPassword(this.username, this.password,
					superAdminGeneral);
			if (empleadoConsultado != null) {
				if (empleadoConsultado.isEstatus()) {

					if (empleadoConsultado.isSuperAdminGeneral()) {
						ControllersUtil.redireccionar("/adminrestaurantes.xhtml");
					} else if (empleadoConsultado.isSuperAdmin()) {
						ControllersUtil.redireccionar("/admintiposalimentos.xhtml");
					}
					this.sessionBean.setEmpleado(empleadoConsultado);
				} else {
					ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR",
							"El usuario esta desabilitado del sistema");
				}
			} else {
				ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR",
						"El usuario y/o contraseña son incorrectos");
			}
		} catch (SQLException e) {
			ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR",
					"Hubo un problema al procesar tu solicitud, favor de intentarlo mas tarde");
			e.printStackTrace();
		} catch (IOException e) {
			ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "ERROR",
					"Hubo un problema al acceder a tu pantalla de inicio, favor de intentarlo mas tarde");
			e.printStackTrace();
		}
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the superAdminGeneral
	 */
	public boolean isSuperAdminGeneral() {
		return superAdminGeneral;
	}

	/**
	 * @param superAdminGeneral the superAdminGeneral to set
	 */
	public void setSuperAdminGeneral(boolean superAdminGeneral) {
		this.superAdminGeneral = superAdminGeneral;
	}

	/**
	 * @return the loginService
	 */
	public LoginService getLoginService() {
		return loginService;
	}

	/**
	 * @param loginService the loginService to set
	 */
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	/**
	 * @return the sessionBean
	 */
	public SessionBean getSessionBean() {
		return sessionBean;
	}

	/**
	 * @param sessionBean the sessionBean to set
	 */
	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

}
