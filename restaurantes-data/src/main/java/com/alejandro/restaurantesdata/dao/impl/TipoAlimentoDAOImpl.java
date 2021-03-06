/**
 * 
 */
package com.alejandro.restaurantesdata.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alejandro.restauranteentities.entity.TipoAlimento;
import com.alejandro.restaurantesdata.connection.ConnectionFactory;
import com.alejandro.restaurantesdata.dao.TipoAlimentoDAO;
import com.alejandro.restaurantesdata.enums.CodigoEnum;
import com.alejandro.restaurantesdata.myexceptions.RestauranteException;

/**
 * @author Horiz
 *
 */
public class TipoAlimentoDAOImpl implements TipoAlimentoDAO {

	@Override
	public int guardar(TipoAlimento tipoAlimento) throws SQLException {
		String sql = "INSERT INTO tipo_alimento(descripcion,fechaCreacion,estatus) VALUES ('"
				+ tipoAlimento.getDescripcion() + "','" + tipoAlimento.getFechaCreacion() + " ', "
				+ tipoAlimento.isEstatus() + ");";
		int ejecutado = ConnectionFactory.ejecutarSQL(sql);
		return ejecutado;
	}

	@Override
	public int actualizar(TipoAlimento tipoAlimento) throws SQLException {
		String sql = "UPDATE tipo_alimento SET estatus = " + tipoAlimento.isEstatus() + ", descripcion = '"
				+ tipoAlimento.getDescripcion() + "', fechaModificacion = '" + tipoAlimento.getFechaModificacion()
				+ "' WHERE idTipoAlimento = " + tipoAlimento.getIdTipoAlimento() + ";";
		int ejecutado = ConnectionFactory.ejecutarSQL(sql);
		return ejecutado;
	}

	@Override
	public int eliminar(int idTipoAlimento) throws SQLException {
		String sql = "DELETE FROM tipo_alimento WHERE idTipoAlimento = " + idTipoAlimento + ";";
		int ejecutado = ConnectionFactory.ejecutarSQL(sql);
		return ejecutado;
	}

	@Override
	public List<TipoAlimento> consultar() throws SQLException {
		String sql = "SELECT * FROM tipo_alimento ORDER BY descripcion;";
		ResultSet rs = ConnectionFactory.ejecutarSQLSelect(sql);

		List<TipoAlimento> tiposAlimentos = new ArrayList<TipoAlimento>();
		if (rs != null) {
			while (rs.next()) {
				TipoAlimento tipoAlimento = new TipoAlimento();
				tipoAlimento.setIdTipoAlimento(rs.getInt("idTipoAlimento"));
				tipoAlimento.setDescripcion(rs.getString("descripcion"));
				tipoAlimento.setFechaCreacion(rs.getTimestamp("fechaCreacion").toLocalDateTime());
				tipoAlimento.setFechaModificacion(rs.getTimestamp("fechaModificacion") != null
						? rs.getTimestamp("fechaModificacion").toLocalDateTime()
						: null);
				tipoAlimento.setEstatus(rs.getBoolean("estatus"));

				tiposAlimentos.add(tipoAlimento);
			}
		}
		return tiposAlimentos;
	}

	@Override
	public TipoAlimento consultarPorId(int idTipoAlimento) throws SQLException, RestauranteException {
		String sql = "SELECT * ROM tipo_alimento WHERE idTipoAlimento = " + idTipoAlimento + ";";

		ResultSet rs = null;
		try {
			rs = ConnectionFactory.ejecutarSQLSelect(sql);
		} catch (Exception e) {
			if (e.getClass().getName().contains("SQLSyntaxErrorException")) {
				throw new RestauranteException("Error de sintaxis en la sentencia SQL: " + sql,
						CodigoEnum.SITAXIS_ERROR_CODE);
			}

		}

		TipoAlimento tipoAlimento = null;
		if (rs != null) {
			if (rs.next()) {
				tipoAlimento = new TipoAlimento();
				tipoAlimento.setIdTipoAlimento(rs.getInt("idTipoAlimento"));
				tipoAlimento.setDescripcion(rs.getString("descripcion"));
				tipoAlimento.setFechaCreacion(rs.getTimestamp("fechaCreacion").toLocalDateTime());
				tipoAlimento.setFechaModificacion(rs.getTimestamp("fechaModificacion") != null
						? rs.getTimestamp("fechaModificacion").toLocalDateTime()
						: null);
				tipoAlimento.setEstatus(rs.getBoolean("estatus"));

			}

		}
		return tipoAlimento;
	}

}
