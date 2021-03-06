/**
 * 
 */
package com.alejandro.restauranteweb.controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;

import com.alejandro.restauranteentities.entity.Menu;
import com.alejandro.restauranteentities.entity.Restaurante;
import com.alejandro.restauranteentities.entity.TipoRestaurante;
import com.alejandro.restauranteservice.services.AdminGeneralService;
import com.alejandro.restauranteweb.utils.ControllersUtil;



/**
 * @author Jose Alejandro Cruz Duran clase que permite controlar el flujo de la
 *         pantalla de administracion de restaurante
 */

@ManagedBean
@ViewScoped
public class AdminRestaurantesController {

	/**
	 * lista de restaurantes que muestra la informacion en el datatable
	 */
	private List<Restaurante> restaurantes;
	/**
	 * Objeto para actualizar, eliminar
	 */
	 private Restaurante restaurante;
	 /**
	  * elemento para guardar archivos de tipo imagen
	  */
	 private Part archivoSeleccionado;
	 /**
	  * ruta para guardar la imagen
	  */
	 private static final String PATH_DESTINO_ARCHIVO = "C:\\Users\\Horiz\\OneDrive\\Documentos\\Restaurante-Data\\restaurante-web\\src\\main\\webapp\\resources\\images\\restaurantes\\";
	 
	 

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
	 * permite inicializar la informacion de los componentes
	 */
	public void inicializarComponentes() {
		this.restaurante = new Restaurante();
		this.restaurante.setTipoRestaurante(new TipoRestaurante());
		this.restaurante.setMenu(new Menu());
		}


	/**
	 * permite consultar la lista de tipos de restaurantes
	 */
	public void consultar() {
		try {
			this.restaurantes = this.adminGeneralService.consultarRestaurantes();
		} catch (SQLException e) {
			ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_FATAL, "UPS",
					"Hubo un problema al solicitar informacion de los tipos de restaurantes, favor de intentarlo mas tarde");
			e.printStackTrace();
		}
	}

	
	public void guardarImagenDirectorio() {
		if (this.archivoSeleccionado != null) {
			try {
				InputStream inputStream = this.archivoSeleccionado.getInputStream();
				String nombreArchivo = this.archivoSeleccionado.getSubmittedFileName();
				Files.copy(inputStream, new File(PATH_DESTINO_ARCHIVO, nombreArchivo).toPath());
				this.restaurante.setImagen(nombreArchivo);
			} catch (IOException e) {
				ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_FATAL, "Ups", "Hubo un problema al copiar la imagen");
				e.printStackTrace();
			}
		
		}
	}
	
	public void guardar() {
		try {
			this.guardarImagenDirectorio();
			int guardado = this.adminGeneralService.guardarRestaurante(this.restaurante);
			if (guardado > 0) {
				ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_INFO, "Ok", " Restaurante "
						+ this.restaurante.getNombre() + " Se ha guardado exitosamente");
				this.consultar();
				this.inicializarComponentes();
			} else {
				ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Error ",
						" Restaurante " + this.restaurante.getNombre() + " No se guardo");
			}
		} catch (SQLException e) {
			ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_FATAL, "Ups ", "Hubo un problema al procesar la informacion del restaurante");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * metodo que nos permite actualizar la informacion de un restaurante
	 */
	public void actualizar() {
		try {
			this.guardarImagenDirectorio();
			int actualizado = this.adminGeneralService.actualizarRestaurante(this.restaurante);
			if (actualizado > 0) {
				ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_INFO, "Ok", " Restaurante "
						+ this.restaurante.getNombre() + " Se ha actualizado exitosamente");
				this.consultar();
				this.inicializarComponentes();
			} else {
				ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Error ",
						" Restaurante " + this.restaurante.getNombre() + " No se actualizo correctamente");
			}
		} catch (SQLException e) {
			ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_FATAL, "Ups ", "Hubo un problema al procesar la informacion del restaurante (actualizar)");
			e.printStackTrace();
		}
	}	

	
	/**
	 * metodo que permite precargar la informacion del restaurante a editar
	 * 
	 * @param restaurante objeto a editar
	 */
	public void cargarInformacionModal(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	

	/**
	 * metodo que permite eliminar de restaurante
	 */
	public void eliminar() {
		System.out.println("Ejecutando accion para eliminar");
		try {
			int eliminado = this.adminGeneralService
					.eliminarTipoRestaurante(this.restaurante.getIdRestaurante());
			if (eliminado > 0) {
				ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_INFO, "Ok", "Restaurante "
						+ this.restaurante.getNombre() + " Se ha actualizado exitosamente");
				this.consultar();
				this.inicializarComponentes();
			} else {
				ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Error", "Restaurante "
						+ this.restaurante.getNombre() + " No se elimino correctamente");
			}
		} catch (SQLException e) {
			ControllersUtil.mostrarMensaje(FacesMessage.SEVERITY_FATAL, "UPS", "Restaurante "
					+ this.restaurante.getNombre()
					+ " Hubo un problema al solicitar informacion de los tipos de restaurantes, favor de intentarlo mas tarde");
			e.printStackTrace();
		}
	}

	/**
	 * @return the restaurantes
	 */
	public List<Restaurante> getRestaurantes() {
		return restaurantes;
	}

	/**
	 * @param restaurantes the restaurantes to set
	 */
	public void setRestaurantes(List<Restaurante> restaurantes) {
		this.restaurantes = restaurantes;
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
	 * @return the archivoSeleccionado
	 */
	public Part getArchivoSeleccionado() {
		return archivoSeleccionado;
	}

	/**
	 * @param archivoSeleccionado the archivoSeleccionado to set
	 */
	public void setArchivoSeleccionado(Part archivoSeleccionado) {
		this.archivoSeleccionado = archivoSeleccionado;
	}


}