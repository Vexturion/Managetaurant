/**
 * 
 */
package com.alejandro.restauranteservice.services;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import com.alejandro.restauranteentities.entity.TipoAlimento;
import com.alejandro.restaurantesdata.dao.impl.TipoAlimentoDAOImpl;

/**
 * @author Jose Alejandro Cruz Duran
 * clase que realiza la logica de negocio para la pantalla de admin de sucursal(superAdmin)
 *
 */
public class AdminSucursalService {
	
	// ::::::::::: OBJETO PARA TRANSACCIONES DE TIPO DE ALIMENTO
	private TipoAlimentoDAOImpl tipoAlimentoDAOImpl = new TipoAlimentoDAOImpl();

	
	// ::::::::::::: TIPO ALIMENTOS ::::::::::::::::::::::::::
	public List<TipoAlimento> consultarTiposAlimentos() throws SQLException {
		return this.tipoAlimentoDAOImpl.consultar();	}


	/**
	 * @return the tipoAlimentoDAOImpl
	 */
	public TipoAlimentoDAOImpl getTipoAlimentoDAOImpl() {
		return tipoAlimentoDAOImpl;
	}


	/**
	 * @param tipoAlimentoDAOImpl the tipoAlimentoDAOImpl to set
	 */
	public void setTipoAlimentoDAOImpl(TipoAlimentoDAOImpl tipoAlimentoDAOImpl) {
		this.tipoAlimentoDAOImpl = tipoAlimentoDAOImpl;
	}

	/**
	 * metodo que permite guardar un registro de tipo de restaurante
	 * @param tipoAlimento a guardar
	 * @return 1 en caso de guardado, 0 en caso de error
	 * @throws SQLException error al ejecutar la sentencia sql
	 */
	public int guardarTipoAlimento(TipoAlimento tipoAlimento) throws SQLException {
		tipoAlimento.setFechaCreacion(LocalDateTime.now());
		tipoAlimento.setEstatus(true);
		
		return this.tipoAlimentoDAOImpl.guardar(tipoAlimento);
	}

	/**
	 * metodo que permite actualizar un registro de tipo de restaurante
	 * @param tipoAlimento a actualizar
	 * @return 1 en caso de actualizado, 0 en caso de error
	 * @throws SQLException error al ejecutar la sentencia sql
	 */
	public int actualizarTipoAlimento(TipoAlimento tipoAlimento) throws SQLException {
		tipoAlimento.setFechaModificacion(LocalDateTime.now());
		return this.tipoAlimentoDAOImpl.actualizar(tipoAlimento);
	}
	
	/**
	 * Metodo que permite eliminar un registro de tipo de restaurante
	 * @param idTipoAlimento a eliminar
	 * @return 1 en caso de eliminar, 0 en caso de error
	 * @throws SQLException error al ejecutar la sentencia sql
	 */
	public int eliminarTipoAlimento(int idTipoAlimento) throws SQLException {
		return this.tipoAlimentoDAOImpl.eliminar(idTipoAlimento);
	}
	
}
