/**
 * 
 */
package com.alejandro.restaurantesdata.dao;

import java.sql.SQLException;
import java.util.List;

import com.alejandro.restauranteentities.entity.Empleado;
import com.alejandro.restaurantesdata.myexceptions.RestauranteException;

/**
 * @author Jose Alejandro Cruz Duran
 * interface que proporciona el crud para las transacciones hacia la base de datos en la tabla 
 * empleado
 */
public interface EmpleadoDAO {

	/**
	 * metodo que permite guardar registros de tipos de empleados
	 * @param empleado
	 * @return 1 o mas en caso de ser exitoso o 0 en caso de no guardarlo
	 * @throws SQLException excepcion generada si el comando sql falla
	 */
	int guardar(Empleado empleado) throws SQLException;
	/**
	 * metodo que permite actualizar registros de tipo empleados
	 * @param Restaurante objeto a actualizar
	 * @return 1 o mas en caso de ser exitoso o 0 en caso de no guardarlo
	 * @throws SQLException excepcion generada si el comando sql falla
	 */
	int actualizar(Empleado empleado) throws SQLException;
	/**
	 * metodo que permite eliminar registros de empleados
	 * @param idRestaurante id del tipo a eliminar
	 * @return 1 o mas en caso de ser exitoso o 0 en caso de no eliminarlo
	 * @throws SQLException excepcion generada si el comando sql falla
	 */
	int eliminar(int idEmpleado) throws SQLException;
	/**
	 * metodo que permite consultar los registros de empleados
	 * @return lista con los tipos de restaurantes | null
	 * @throws SQLException excepcion generada si el comando sql falla
	 */
	List<Empleado> consultar() throws SQLException;
	/**
	 * metodo que nos permite consultar un registro de empleados por id
	 * @param idEmpleado identificador del empleado
	 * @return objeto de tipo empleado que se consulto
	 * @throws RestauranteException que lanza una excepcion personalizada al no cumplirse la correcta sintaxis de la sentencia sql
	 */
	Empleado consultarPorId(int idEmpleado) throws SQLException, RestauranteException;
	
	
}
