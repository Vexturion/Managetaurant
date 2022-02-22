/**
 * 
 */
package com.alejandro.restaurantedata.dao;

import java.sql.SQLException;
import java.util.List;

import com.alejandro.restaurantedata.entity.Restaurante;
import com.alejandro.restaurantedata.myexceptions.RestauranteException;

/**
 * @author Jose Alejandro Cruz Duran
 * interface que proporciona el crud para las transacciones hacia la base de datos en la tabla 
 * restaurante
 */
public interface RestauranteDAO {

	/**
	 * metodo que permite guardar registros de tipos de restaurantes
	 * @param Restaurante
	 * @return 1 o mas en caso de ser exitoso o 0 en caso de no guardarlo
	 * @throws SQLException excepcion generada si el comando sql falla
	 */
	int guardar(Restaurante restaurante) throws SQLException;
	/**
	 * metodo que permite actualizar registros de tipo restaurantes
	 * @param Restaurante objeto a actualizar
	 * @return 1 o mas en caso de ser exitoso o 0 en caso de no guardarlo
	 * @throws SQLException excepcion generada si el comando sql falla
	 */
	int actualizar(Restaurante restaurante) throws SQLException;
	/**
	 * metodo que permite eliminar registros de tipos de restaurantes
	 * @param idRestaurante id del tipo a eliminar
	 * @return 1 o mas en caso de ser exitoso o 0 en caso de no eliminarlo
	 * @throws SQLException excepcion generada si el comando sql falla
	 */
	int eliminar(int idRestaurante) throws SQLException;
	/**
	 * metodo que permite consultar los registros de tipo de restaurantes
	 * @return lista con los tipos de restaurantes | null
	 * @throws SQLException excepcion generada si el comando sql falla
	 */
	List<Restaurante> consultar() throws SQLException;
	/**
	 * metodo que nos permite consultar un registro de tipo restaurante por id
	 * @param idRestaurante identificador del restaurante
	 * @return objeto de tipo restaurante que se consulto
	 * @throws RestauranteException que lanza una excepcion personalizada al no cumplirse la correcta sintaxis de la sentencia sql
	 */
	Restaurante consultarPorId(int idRestaurante) throws SQLException, RestauranteException;
	
	
}
