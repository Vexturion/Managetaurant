/**
 * 
 */
package com.alejandro.restauranteservice.services;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import com.alejandro.restauranteentities.entity.Menu;
import com.alejandro.restauranteentities.entity.Restaurante;
import com.alejandro.restauranteentities.entity.TipoRestaurante;
import com.alejandro.restaurantesdata.dao.impl.RestauranteDAOImpl;
import com.alejandro.restaurantesdata.dao.impl.TipoRestauranteDAOImpl;

/**
 * @author Jose Alejandro Cruz Duran clase de servicios encargada de realizar la
 *         logica de negocio para la administracion de restaurantes para el
 *         admingeneral
 *
 */
public class AdminGeneralService {

	// ::::::::::::::::: OBJETOS PARA TRANSACCIONES ::::::::::::::
	
	/**
	 * objeto que permite realizar las transacciones de tipo restaurante
	 */
	private TipoRestauranteDAOImpl tipoRestauranteDAOImpl = new TipoRestauranteDAOImpl();
	
	/**
	 * objeto que permite realizar las transacciones de restaurantes
	 */
	private RestauranteDAOImpl restauranteDAOImpl = new RestauranteDAOImpl();
	
	
	// ::::::: RESTAURANTES ::::::::::::::
	
	/**
	 * Metodo que permite consultar el listado de restaurantes
	 * @return lista de restaurantes consultados
	 * @throws SQLException en caso de error al ejecutar la sentencia SQL
	 */
	public List<Restaurante> consultarRestaurantes() throws SQLException{
		return this.restauranteDAOImpl.consultar();
	}
	
	
	public int guardarRestaurante(Restaurante restaurante) throws SQLException {
		restaurante.setFechaCreacion(LocalDateTime.now());
		restaurante.setEstatus(true);
		
		return this.restauranteDAOImpl.guardar(restaurante);
	}
	
	
	public int actualizarRestaurante(Restaurante restaurante) throws SQLException {
		restaurante.setFechaModificacion(LocalDateTime.now());
		restaurante.setMenu(new Menu());
		return this.restauranteDAOImpl.actualizar(restaurante);	
	}
	
	
	public int eliminarRestaurante(int idRestaurante) throws SQLException {
		return this.restauranteDAOImpl.eliminar(idRestaurante);
	}
	
	/**
	 * @return the restauranteDAOImpl
	 */
	public RestauranteDAOImpl getRestauranteDAOImpl() {
		return restauranteDAOImpl;
	}




	/**
	 * @param restauranteDAOImpl the restauranteDAOImpl to set
	 */
	public void setRestauranteDAOImpl(RestauranteDAOImpl restauranteDAOImpl) {
		this.restauranteDAOImpl = restauranteDAOImpl;
	}
			
	
	// :::::::: TIPOS DE RESTAURANTES :::::::::

	public List<TipoRestaurante> consultarTiposRestaurantes() throws SQLException {
		return this.tipoRestauranteDAOImpl.consultar();	}


	/**
	 * @return the tipoRestauranteDAOImpl
	 */
	public TipoRestauranteDAOImpl getTipoRestauranteDAOImpl() {
		return tipoRestauranteDAOImpl;
	}


	/**
	 * @param tipoRestauranteDAOImpl the tipoRestauranteDAOImpl to set
	 */
	public void setTipoRestauranteDAOImpl(TipoRestauranteDAOImpl tipoRestauranteDAOImpl) {
		this.tipoRestauranteDAOImpl = tipoRestauranteDAOImpl;
	}

	/**
	 * metodo que permite guardar un registro de tipo de restaurante
	 * @param tipoRestaurante a guardar
	 * @return 1 en caso de guardado, 0 en caso de error
	 * @throws SQLException error al ejecutar la sentencia sql
	 */
	public int guardarTipoRestaurante(TipoRestaurante tipoRestaurante) throws SQLException {
		tipoRestaurante.setFechaCreacion(LocalDateTime.now());
		tipoRestaurante.setEstatus(true);
		
		return this.tipoRestauranteDAOImpl.guardar(tipoRestaurante);
	}

	/**
	 * metodo que permite actualizar un registro de tipo de restaurante
	 * @param tipoRestaurante a actualizar
	 * @return 1 en caso de actualizado, 0 en caso de error
	 * @throws SQLException error al ejecutar la sentencia sql
	 */
	public int actualizarTipoRestaurante(TipoRestaurante tipoRestaurante) throws SQLException {
		tipoRestaurante.setFechaModificacion(LocalDateTime.now());
		return this.tipoRestauranteDAOImpl.actualizar(tipoRestaurante);
	}
	
	/**
	 * Metodo que permite eliminar un registro de tipo de restaurante
	 * @param idTipoRestaurante a eliminar
	 * @return 1 en caso de eliminar, 0 en caso de error
	 * @throws SQLException error al ejecutar la sentencia sql
	 */
	public int eliminarTipoRestaurante(int idTipoRestaurante) throws SQLException {
		return this.tipoRestauranteDAOImpl.eliminar(idTipoRestaurante);
	}



}

