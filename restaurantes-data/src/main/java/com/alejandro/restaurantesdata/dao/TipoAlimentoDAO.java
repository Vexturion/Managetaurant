/**
 * 
 */
package com.alejandro.restaurantesdata.dao;

import java.sql.SQLException;
import java.util.List;

import com.alejandro.restauranteentities.entity.TipoAlimento;
import com.alejandro.restaurantesdata.myexceptions.RestauranteException;

/**
 * @author Horiz
 *
 */
public interface TipoAlimentoDAO {

	/**
	 * metodo que permite guardar registros de tipos de restaurantes
	 * @param tipoAlimento
	 * @return 1 o mas en caso de ser exitoso o 0 en caso de no guardarlo
	 * @throws SQLException excepcion generada si el comando sql falla
	 */
	int guardar(TipoAlimento tipoAlimento) throws SQLException;
	/**
	 * metodo que permite actualizar registros de tipo restaurantes
	 * @param tipoAlimento objeto a actualizar
	 * @return 1 o mas en caso de ser exitoso o 0 en caso de no guardarlo
	 * @throws SQLException excepcion generada si el comando sql falla
	 */
	int actualizar(TipoAlimento tipoAlimento) throws SQLException;
	/**
	 * metodo que permite eliminar registros de tipos de restaurantes
	 * @param idTipoAlimento id del tipo a eliminar
	 * @return 1 o mas en caso de ser exitoso o 0 en caso de no eliminarlo
	 * @throws SQLException excepcion generada si el comando sql falla
	 */
	int eliminar(int idTipoAlimento) throws SQLException;
	/**
	 * metodo que permite consultar los registros de tipo de restaurantes
	 * @return lista con los tipos de restaurantes | null
	 * @throws SQLException excepcion generada si el comando sql falla
	 */
	List<TipoAlimento> consultar() throws SQLException;
	/**
	 * metodo que nos permite consultar un registro de tipo restaurante por id
	 * @param idTipoAlimento identificador del restaurante
	 * @return objeto de tipo restaurante que se consulto
	 * @throws RestauranteException que lanza una excepcion personalizada al no cumplirse la correcta sintaxis de la sentencia sql
	 */
	TipoAlimento consultarPorId(int idTipoAlimento) throws SQLException, RestauranteException;
	
}
