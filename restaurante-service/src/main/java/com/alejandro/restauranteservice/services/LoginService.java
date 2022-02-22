/**
 * 
 */
package com.alejandro.restauranteservice.services;

import java.sql.SQLException;

import com.alejandro.restauranteentities.entity.Empleado;
import com.alejandro.restaurantesdata.dao.impl.EmpleadoDAOImpl;

/**
 * @author Jose Alejandro Cruz Duran
 * clase que realiza la logica de negocio para la funcionalidad de la pantalla Login
 *
 */
public class LoginService {

	/**
	 * objeto para obtener los resultados de las transacciones a la base de datos en la tabla empleados
	 */
	private EmpleadoDAOImpl empleadoDAOImpl = new EmpleadoDAOImpl();
	
	/**
	 * metodo que nos permite consultar un empleado desde el login con su informacion y perfil en el sistema
	 * @param usuario parametro capturado por el usuario
	 * @param password parametro capturado por el usuario
	 * @param superAdminGeneral verifica si el usuario es administrador general
	 * @return objeto con el empleado loggin
	 * @throws SQLException error en caso de ejecutar la sentencia sql
	 */
	
	public Empleado consultarPorUsuarioYPassword(String usuario, String password, boolean superAdminGeneral) throws SQLException {
		return this.empleadoDAOImpl.consultarPorUsuarioYPassword(usuario, password, superAdminGeneral);
	}
	
}
