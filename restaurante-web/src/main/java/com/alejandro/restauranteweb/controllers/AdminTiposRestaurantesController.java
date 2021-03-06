/**
 * 
 */
package com.alejandro.restauranteweb.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.alejandro.restauranteentities.entity.TipoRestaurante;
import com.alejandro.restauranteservice.services.AdminGeneralService;
import com.alejandro.restauranteweb.utils.ControllersUtil;

/**
 * @author Jose Alejandro Cruz Duran clase que permite controlar el flujo de la
 *         pantalla de administracion de tipos de restaurante
 */

@ManagedBean
@ViewScoped
public class AdminTiposRestaurantesController {

	/**
	 * lista de tipos de restaurantes que muestra la informacion en el datatable
	 */
	private List<TipoRestaurante> tiposRestaurantes;
	/**
	 * Objeto para actualizar, eliminar
	 */
	private TipoRestaurante tipoRestaurante;

	/**
	 * objeto que permite utilizar los servicios de logica de negocio de tipos de
	 * restaurantes
	 */
	private AdminGeneralService adminGeneralService = new AdminGeneralService();

	@PostConstruct
	public void init() {

		this.inicializarComponentes();
		this.consultar();
	}

	/**
	 * permite consultar la lista de tipos de restaurantes
	 */
	public void consultar() {
		try {
			this.tiposRestaurantes = this.adminGeneralService.consultarTiposRestaurantes();
		} catch (SQLException e) {
			ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_FATAL, "UPS",
					"Hubo un problema al solicitar informacion de los tipos de restaurantes, favor de intentarlo mas tarde");
			e.printStackTrace();
		}
	}

	/**
	 * metodo que permite guardar un tipo de restaurante
	 */
	public void guardar() {
		System.out.println("Ejecutando accion para guardar");
		try {
			int guardado = this.adminGeneralService.guardarTipoRestaurante(this.tipoRestaurante);
			if (guardado > 0) {
				ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_INFO, "Ok", "Tipo de restaurante "
						+ this.tipoRestaurante.getDescripcion() + " Se ha guardado exitosamente");
				this.consultar();
				this.inicializarComponentes();
			} else {
				ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Error",
						"Tipo de restaurante " + this.tipoRestaurante.getDescripcion() + " No se guardo");
			}
		} catch (SQLException e) {
			ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_FATAL, "UPS", "Tipo de restaurante "
					+ this.tipoRestaurante.getDescripcion()
					+ " Hubo un problema al solicitar informacion de los tipos de restaurantes, favor de intentarlo mas tarde\");");
			e.printStackTrace();
		}
	}

	/**
	 * metodo que permite precargar la informacion del tipo de restaurante a editar
	 * 
	 * @param tipoResaurante objeto a editar
	 */
	public void cargarInformacionModal(TipoRestaurante tipoResaurante) {
		this.tipoRestaurante = tipoResaurante;
	}

	public void actualizar() {
		System.out.println("Ejecutando accion para actualizar");
		try {
			int actualizado = this.adminGeneralService.actualizarTipoRestaurante(this.tipoRestaurante);
			if (actualizado > 0) {
				ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_INFO, "Ok", "Tipo de restaurante "
						+ this.tipoRestaurante.getDescripcion() + " Se ha actualizado exitosamente");
				this.consultar();
				this.inicializarComponentes();
			} else {
				ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Error", "Tipo de restaurante "
						+ this.tipoRestaurante.getDescripcion() + " No se actualizo correctamente");
			}
		} catch (SQLException e) {
			ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_FATAL, "UPS", "Tipo de restaurante "
					+ this.tipoRestaurante.getDescripcion()
					+ " Hubo un problema al solicitar informacion de los tipos de restaurantes, favor de intentarlo mas tarde\");");
			e.printStackTrace();
		}
	}

	/**
	 * metodo que permite eliminar un tipo de restaurante
	 */
	public void eliminar() {
		System.out.println("Ejecutando accion para eliminar");
		try {
			int eliminado = this.adminGeneralService
					.eliminarTipoRestaurante(this.tipoRestaurante.getIdTipoRestaurante());
			if (eliminado > 0) {
				ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_INFO, "Ok", "Tipo de restaurante "
						+ this.tipoRestaurante.getDescripcion() + " Se ha actualizado exitosamente");
				this.consultar();
				this.inicializarComponentes();
			} else {
				ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Error", "Tipo de restaurante "
						+ this.tipoRestaurante.getDescripcion() + " No se elimino correctamente");
			}
		} catch (SQLException e) {
			ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_FATAL, "UPS", "Tipo de restaurante "
					+ this.tipoRestaurante.getDescripcion()
					+ " Hubo un problema al solicitar informacion de los tipos de restaurantes, favor de intentarlo mas tarde\");");
			e.printStackTrace();
		}
	}

	/**
	 * permite inicializar la informacion de los componentes
	 */
	public void inicializarComponentes() {
		this.tipoRestaurante = new TipoRestaurante();
	}

	/**
	 * @return the tiposRestaurantes
	 */
	public List<TipoRestaurante> getTiposRestaurantes() {
		return tiposRestaurantes;
	}

	/**
	 * @param tiposRestaurantes the tiposRestaurantes to set
	 */
	public void setTiposRestaurantes(List<TipoRestaurante> tiposRestaurantes) {
		this.tiposRestaurantes = tiposRestaurantes;
	}

	/**
	 * @return the adminGeneralService
	 */
	public AdminGeneralService getAdminGeneralService() {
		return adminGeneralService;
	}

	/**
	 * @param adminGeneralService the adminGeneralService to set
	 */
	public void setAdminGeneralService(AdminGeneralService adminGeneralService) {
		this.adminGeneralService = adminGeneralService;
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

}
