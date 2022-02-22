/**
 * 
 */
package com.alejandro.restaurantedata.principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.List.*;

import com.alejandro.restaurantedata.connection.ConnectionFactory;
import com.alejandro.restaurantedata.dao.TipoRestauranteDAO;
import com.alejandro.restaurantedata.dao.impl.TipoRestauranteDAOImpl;
import com.alejandro.restaurantedata.entity.TipoRestaurante;
import com.alejandro.restaurantedata.myexceptions.RestauranteException;

/**
 * @author Jose Alejandro Cruz
 * Clase principal para probar conexion a base de datos
 *
 */
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TipoRestauranteDAOImpl tipoRestauranteDAOImpl = new TipoRestauranteDAOImpl();

// :::::::::::::  prueba de INSERT  ::::::::::::::::::

//		TipoRestaurante ale = new TipoRestaurante();
//		ale.setDescripcion("Aleman");
//		ale.setFechaCreacion(LocalDateTime.now());
//		ale.setEstatus(true);
//		try {
//			int guardado = tipoRestauranteDAOImpl.guardar(ale);
//			if(guardado > 0) {
//				System.out.println("El tipo de restaurante " + ale.getDescripcion() + " se guardo correctamente");
//			} else {
//				System.err.println("Ha ocurrido un error al insertar valor");
//			}
//		} catch (SQLException e) {
//			System.err.println("error: " + e.getMessage());
//		}
		
		
// ::::::::::::: prueba UPDATE :::::::::::::::
		
//		TipoRestaurante tipoRestaurante = new TipoRestaurante();
//		tipoRestaurante.setEstatus(false);
//		tipoRestaurante.setIdTipoRestaurante(18);
//		tipoRestaurante.setDescripcion("Japones");
//		tipoRestaurante.setFechaModificacion(LocalDateTime.now());
//
//		
//		
//		
//		try {
//			int actualizado = tipoRestauranteDAOImpl.actualizar(tipoRestaurante);
//			if(actualizado > 0) {
//				System.out.println("El tipo de restaurante " + tipoRestaurante.getDescripcion() + " se actualizo correctamente");
//			} else {
//				System.err.println("Ha ocurrido un error al insertar valor");
//			}
//		} catch (SQLException e) {
//			System.err.println("error: " + e.getMessage());
//		}
		
// :::::::::::::: prueba DELETE ::::::::::::::::;
//		
//		TipoRestaurante tipoRestaurante = new TipoRestaurante();
//		tipoRestaurante.setIdTipoRestaurante(21);
//		tipoRestaurante.setDescripcion("Aleman");
//		
//		
//		try {
//		int eliminado = tipoRestauranteDAOImpl.eliminar(21);
//		if(eliminado > 0) {
//			System.out.println("El tipo de restaurante " + tipoRestaurante.getDescripcion() + " se elimino correctamente");
//		} else {
//			System.err.println("Ha ocurrido un error al insertar valor");
//		}
//	} catch (SQLException e) {
//		System.err.println("error: " + e.getMessage());
//	}
		
		
// :::::::::::: prueba SELECT :::::::::::::
//		try {
//			List<TipoRestaurante> tiposConsultados = tipoRestauranteDAOImpl.consultar();
//		for (TipoRestaurante tipoRestaurante : tiposConsultados) {
//			System.out.println("ID: " + tipoRestaurante.getIdTipoRestaurante());
//			System.out.println("Descripcion: " + tipoRestaurante.getDescripcion());
//			System.out.println("Fecha Creacion: " + tipoRestaurante.getFechaCreacion());
//			System.out.println("Fecha modificacion: " + tipoRestaurante.getFechaModificacion() + "\n");
//		}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		} 
		
// :::::::::::: Prueba SELECT WHERE ID :::::::::
		try {
		TipoRestaurante tipoConsultado = tipoRestauranteDAOImpl.consultarPorId(19);
	if (tipoConsultado!=null) {
		System.out.println("ID: " + tipoConsultado.getIdTipoRestaurante());
		System.out.println("Descripcion: " + tipoConsultado.getDescripcion());
		System.out.println("Fecha Creacion: " + tipoConsultado.getFechaCreacion());
		System.out.println("Fecha modificacion: " + tipoConsultado.getFechaModificacion() + "\n");
	} else {
		System.err.println("El tipo consultado no se ha encontrado / no existe");;
	}
		
	
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
	} catch(RestauranteException e){
		e.printStackTrace();
		System.out.println(e.getErrorCode());
	}
		
		
		
	}

}
