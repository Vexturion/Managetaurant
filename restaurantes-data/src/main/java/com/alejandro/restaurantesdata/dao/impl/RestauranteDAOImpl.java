/**
 * 
 */
package com.alejandro.restaurantesdata.dao.impl;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alejandro.restauranteentities.entity.Restaurante;
import com.alejandro.restauranteentities.entity.TipoRestaurante;
import com.alejandro.restaurantesdata.connection.ConnectionFactory;
import com.alejandro.restaurantesdata.dao.RestauranteDAO;
import com.alejandro.restaurantesdata.enums.CodigoEnum;
import com.alejandro.restaurantesdata.myexceptions.RestauranteException;

/**
 * @author Horiz
 *
 */
public class RestauranteDAOImpl implements RestauranteDAO {

	static {
		try {
			ConnectionFactory.conectar();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Error de base de datos:" + e.getMessage());
		}
	}

	@Override
	public int guardar(Restaurante restaurante) throws SQLException {
		String sql = "INSERT INTO restaurante (nombre,imagen,slogan,idTipoRestaurante,fechaCreacion,estatus,idMenu) "
				+ "VALUES ('" + restaurante.getNombre() + "','" + restaurante.getImagen() + "','"
				+ restaurante.getSlogan() + "'," + restaurante.getTipoRestaurante().getIdTipoRestaurante() + "," + "'"
				+ restaurante.getFechaCreacion() + "'," + restaurante.isEstatus() + ","
				+ restaurante.getMenu().getIdMenu() + ");";
		int ejecutado = ConnectionFactory.ejecutarSQL(sql);
		return ejecutado;
	}

	@Override
	public int actualizar(Restaurante restaurante) throws SQLException {
		String sql = "UPDATE restaurante SET nombre = '" + restaurante.getNombre() + "', imagen = '"
				+ restaurante.getImagen() + "', slogan = '" + restaurante.getSlogan() + "', idTipoRestaurante = '"
				+ restaurante.getTipoRestaurante().getIdTipoRestaurante() + "',fechaModificacion = '"
				+ restaurante.getFechaModificacion() + "', estatus = " + restaurante.isEstatus() + ", idMenu = "
				+ restaurante.getMenu().getIdMenu() + " WHERE idRestaurante = '" + restaurante.getIdRestaurante()
				+ "';";
		int ejecutado = ConnectionFactory.ejecutarSQL(sql);
		return ejecutado;
	}

	@Override
	public int eliminar(int idRestaurante) throws SQLException {
		String sql = "DELETE FROM restaurante WHERE idRestaurante ='" + idRestaurante + "';";
		int ejecutado = ConnectionFactory.ejecutarSQL(sql);
		return ejecutado;
	}

	@Override
	public List<Restaurante> consultar() throws SQLException {
		String sql = "SELECT r.*, tr.descripcion FROM restaurante r, tipo_restaurante tr WHERE r.idTipoRestaurante = tr.idTipoRestaurante ORDER BY nombre;";
		ResultSet rs = ConnectionFactory.ejecutarSQLSelect(sql);

		List<Restaurante> restaurantes = new ArrayList<>();
		if (rs != null) {
			while (rs.next()) {
				Restaurante restaurante = new Restaurante();
				restaurante.setIdRestaurante(rs.getInt("idRestaurante"));
				restaurante.setNombre(rs.getString("nombre"));
				restaurante.setImagen(rs.getString("imagen"));
				restaurante.setSlogan(rs.getString("slogan"));
				restaurante.setFechaCreacion(rs.getTimestamp("fechaCreacion").toLocalDateTime());
				restaurante.setFechaModificacion(rs.getTimestamp("fechaModificacion") != null
						? rs.getTimestamp("fechaModificacion").toLocalDateTime()
						: null);
				restaurante.setEstatus(rs.getBoolean("estatus"));
				
				TipoRestaurante tipoRestaurante = new TipoRestaurante();	
				tipoRestaurante.setIdTipoRestaurante(rs.getInt("idTipoRestaurante"));
				tipoRestaurante.setDescripcion(rs.getString("descripcion"));
				
				restaurante.setTipoRestaurante(tipoRestaurante);
				
				restaurantes.add(restaurante);
			}
		}
		return restaurantes;
	}

	@Override
	public Restaurante consultarPorId(int idRestaurante) throws SQLException, RestauranteException {
		String sql = "SELECT * FROM restaurante WHERE idRestaurante = " + idRestaurante + ";";

		ResultSet rs = null;
		try {
			rs = ConnectionFactory.ejecutarSQLSelect(sql);
		} catch (Exception e) {
			if (e.getClass().getName().contains("SQLSyntaxErrorException")) {
				throw new RestauranteException("Error de sintaxis en la sentencia SQL: " + sql,
						CodigoEnum.SITAXIS_ERROR_CODE);
			}

		}

		Restaurante restaurante = null;
		if (rs != null) {
			if (rs.next()) {
				restaurante = new Restaurante();
				restaurante.setIdRestaurante(rs.getInt("idRestaurante"));
				restaurante.setNombre(rs.getNString("nombre"));
				restaurante.setFechaCreacion(rs.getTimestamp("fechaCreacion").toLocalDateTime());
				restaurante.setFechaModificacion(rs.getTimestamp("fechaModificacion") != null
						? rs.getTimestamp("fechaModificacion").toLocalDateTime()
						: null);
				restaurante.setEstatus(rs.getBoolean("estatus"));

			}
		}
		return restaurante;
	}
}
