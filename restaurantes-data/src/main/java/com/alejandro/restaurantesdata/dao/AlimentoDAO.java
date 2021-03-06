

/**
 * 
 */
package com.alejandro.restaurantesdata.dao;

import java.sql.SQLException;
import java.util.List;

import com.alejandro.restauranteentities.entity.Alimento;
import com.alejandro.restaurantesdata.myexceptions.RestauranteException;


/**
 * @author Horiz
 *
 */
public interface AlimentoDAO {

	/**
	 * metodo que permite guardar registros de tipos de alimentos
	 * @param Alimento
	 * @return 1 o mas en caso de ser exitoso o 0 en caso de no guardarlo
	 * @throws SQLException excepcion generada si el comando sql falla
	 */
	int guardar(Alimento alimento) throws SQLException;
	/**
	 * metodo que permite actualizar registros de  alimentos
	 * @param Alimento objeto a actualizar
	 * @return 1 o mas en caso de ser exitoso o 0 en caso de no guardarlo
	 * @throws SQLException excepcion generada si el comando sql falla
	 */
	int actualizar(Alimento alimento) throws SQLException;
	/**
	 * metodo que permite eliminar registros  de alimentos
	 * @param idAlimento id del tipo a eliminar
	 * @return 1 o mas en caso de ser exitoso o 0 en caso de no eliminarlo
	 * @throws SQLException excepcion generada si el comando sql falla
	 */
	int eliminar(int idAlimento) throws SQLException;
	/**
	 * metodo que permite consultar los registros de alimentos
	 * @return lista con los tipos de alimentos | null
	 * @throws SQLException excepcion generada si el comando sql falla
	 */
	List<Alimento> consultar() throws SQLException;
	/**
	 * metodo que nos permite consultar un registro de alimento por id
	 * @param idAlimento identificador del alimento
	 * @return objeto de tipo alimento que se consulto
	 * @throws AlimentoException que lanza una excepcion personalizada al no cumplirse la correcta sintaxis de la sentencia sql
	 */
	Alimento consultarPorId(int idAlimento) throws SQLException, RestauranteException;
	
}
