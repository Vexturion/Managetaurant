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

import com.alejandro.restauranteentities.entity.TipoAlimento;
import com.alejandro.restauranteservice.services.AdminSucursalService;
import com.alejandro.restauranteweb.utils.ControllersUtil;

/**
 * @author Jose Alejandro Cruz Duran clase que permite controlar el flujo de la
 *         pantalla de administracion de tipos de restaurante
 */

@ManagedBean
@ViewScoped
public class AdminTiposAlimentosController {

	/**
	 * lista de tipos de restaurantes que muestra la informacion en el datatable
	 */
	private List<TipoAlimento> tiposAlimentos;
	/**
	 * Objeto para actualizar, eliminar
	 */
	private TipoAlimento tipoAlimento;

	/**
	 * objeto que permite utilizar los servicios de logica de negocio de tipos de
	 * restaurantes
	 */
	private AdminSucursalService adminSucursalService = new AdminSucursalService();

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
			this.tiposAlimentos = this.adminSucursalService.consultarTiposAlimentos();
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
			int guardado = this.adminSucursalService.guardarTipoAlimento(this.tipoAlimento);
			if (guardado > 0) {
				ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_INFO, "Ok", "Tipo de restaurante "
						+ this.tipoAlimento.getDescripcion() + " Se ha guardado exitosamente");
				this.consultar();
				this.inicializarComponentes();
			} else {
				ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Error",
						"Tipo de restaurante " + this.tipoAlimento.getDescripcion() + " No se guardo");
			}
		} catch (SQLException e) {
			ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_FATAL, "UPS", "Tipo de restaurante "
					+ this.tipoAlimento.getDescripcion()
					+ " Hubo un problema al solicitar informacion de los tipos de restaurantes, favor de intentarlo mas tarde\");");
			e.printStackTrace();
		}
	}

	/**
	 * metodo que permite precargar la informacion del tipo de alimento a editar
	 * 
	 * @param tipoAlimento objeto a editar
	 */
	public void cargarInformacionModal(TipoAlimento tipoResaurante) {
		this.tipoAlimento = tipoResaurante;
	}

	public void actualizar() {
		System.out.println("Ejecutando accion para actualizar");
		try {
			int actualizado = this.adminSucursalService.actualizarTipoAlimento(this.tipoAlimento);
			if (actualizado > 0) {
				ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_INFO, "Ok", "Tipo de restaurante "
						+ this.tipoAlimento.getDescripcion() + " Se ha actualizado exitosamente");
				this.consultar();
				this.inicializarComponentes();
			} else {
				ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Error", "Tipo de restaurante "
						+ this.tipoAlimento.getDescripcion() + " No se actualizo correctamente");
			}
		} catch (SQLException e) {
			ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_FATAL, "UPS", "Tipo de restaurante "
					+ this.tipoAlimento.getDescripcion()
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
			int eliminado = this.adminSucursalService
					.eliminarTipoAlimento(this.tipoAlimento.getIdTipoAlimento());
			if (eliminado > 0) {
				ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_INFO, "Ok", "Tipo de a "
						+ this.tipoAlimento.getDescripcion() + " Se ha actualizado exitosamente");
				this.consultar();
				this.inicializarComponentes();
			} else {
				ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Error", "Tipo de alimento "
						+ this.tipoAlimento.getDescripcion() + " No se elimino correctamente");
			}
		} catch (SQLException e) {
			ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_FATAL, "UPS", "Tipo de alimento "
					+ this.tipoAlimento.getDescripcion()
					+ " Hubo un problema al solicitar informacion de los tipos de restaurantes, favor de intentarlo mas tarde\");");
			e.printStackTrace();
		}
	}

	/**
	 * permite inicializar la informacion de los componentes
	 */
	public void inicializarComponentes() {
		this.tipoAlimento = new TipoAlimento();
	}

	/**
	 * @return the tiposAlimentos
	 */
	public List<TipoAlimento> getTiposAlimentos() {
		return tiposAlimentos;
	}

	/**
	 * @param tiposAlimentos the tiposAlimentos to set
	 */
	public void setTiposAlimentos(List<TipoAlimento> tiposAlimentos) {
		this.tiposAlimentos = tiposAlimentos;
	}

	/**
	 * @return the adminSucursalService
	 */
	public AdminSucursalService getAdminSucursalService() {
		return adminSucursalService;
	}

	/**
	 * @param adminSucursalService the adminSucursalService to set
	 */
	public void setAdminSucursalService(AdminSucursalService adminSucursalService) {
		this.adminSucursalService = adminSucursalService;
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

}
