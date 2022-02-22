/**
 * 
 */
package com.alejandro.restaurantedata.dao;

import java.sql.SQLException;
import java.util.List;

import com.alejandro.restaurantedata.entity.TipoRestaurante;
import com.alejandro.restaurantedata.myexceptions.RestauranteException;

/**
 * @author Horiz
 * interfaz que representa el CRUD de transaccion para la tabla de tipo_restaurante
 */
public interface TipoRestauranteDAO {
	/**
	 * metodo que permite guardar registros de tipos de restaurantes
	 * @param tipoRestaurante
	 * @return 1 o mas en caso de ser exitoso o 0 en caso de no guardarlo
	 * @throws SQLException excepcion generada si el comando sql falla
	 */
	int guardar(TipoRestaurante tipoRestaurante) throws SQLException;
	/**
	 * metodo que permite actualizar registros de tipo restaurantes
	 * @param tipoRestaurante objeto a actualizar
	 * @return 1 o mas en caso de ser exitoso o 0 en caso de no guardarlo
	 * @throws SQLException excepcion generada si el comando sql falla
	 */
	int actualizar(TipoRestaurante tipoRestaurante) throws SQLException;
	/**
	 * metodo que permite eliminar registros de tipos de restaurantes
	 * @param idTipoRestaurante id del tipo a eliminar
	 * @return 1 o mas en caso de ser exitoso o 0 en caso de no eliminarlo
	 * @throws SQLException excepcion generada si el comando sql falla
	 */
	int eliminar(int idTipoRestaurante) throws SQLException;
	/**
	 * metodo que permite consultar los registros de tipo de restaurantes
	 * @return lista con los tipos de restaurantes | null
	 * @throws SQLException excepcion generada si el comando sql falla
	 */
	List<TipoRestaurante> consultar() throws SQLException;
	/**
	 * metodo que nos permite consultar un registro de tipo restaurante por id
	 * @param idTipoRestaurante identificador del restaurante
	 * @return objeto de tipo restaurante que se consulto
	 * @throws RestauranteException que lanza una excepcion personalizada al no cumplirse la correcta sintaxis de la sentencia sql
	 */
	TipoRestaurante consultarPorId(int idTipoRestaurante) throws SQLException, RestauranteException;
	
}
