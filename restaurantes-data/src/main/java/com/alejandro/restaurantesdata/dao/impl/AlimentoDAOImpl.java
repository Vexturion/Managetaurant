/**
 * 
 */
package com.alejandro.restaurantesdata.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.alejandro.restauranteentities.entity.Alimento;
import com.alejandro.restauranteentities.entity.Menu;
import com.alejandro.restauranteentities.entity.Restaurante;
import com.alejandro.restauranteentities.entity.TipoAlimento;
import com.alejandro.restaurantesdata.connection.ConnectionFactory;
import com.alejandro.restaurantesdata.dao.AlimentoDAO;
import com.alejandro.restaurantesdata.enums.CodigoEnum;
import com.alejandro.restaurantesdata.myexceptions.RestauranteException;

/**
 * @author Horiz
 *
 */
public class AlimentoDAOImpl implements AlimentoDAO {

	@Override
	public int guardar(Alimento alimento) throws SQLException {
		String sql = "INSERT INTO alimento (`nombre`, `imagen`, `descripcion`, `idTipoAlimento`, `descuento`, `precio`, `fechaCreacion`, `estatus`, `idRestaurante`, `idMenu`) \r\n"
				+ "		VALUES ('" + alimento.getNombre() + "', '" + alimento.getImagen() + "', '"
				+ alimento.getDescripcion() + "', " + alimento.getTipoAlimento().getIdTipoAlimento() + ", "
				+ alimento.getDescuento() + ", '" + alimento.getPrecio() + "', " + "'" + alimento.getFechaCreacion()
				+ "', " + alimento.isEstatus() + ", " + alimento.getRestaurante().getIdRestaurante() + ", "
				+ alimento.getMenu().getIdMenu() + ");";
		int ejecutado = ConnectionFactory.ejecutarSQL(sql);
		return ejecutado;
	}

	@Override
	public int actualizar(Alimento alimento) throws SQLException {
		String sql = "UPDATE alimento SET `nombre` = '" + alimento.getNombre() + "', `imagen` = '"
				+ alimento.getImagen() + "', `descripcion` = '" + alimento.getDescripcion() + "', "
				+ "`idTipoAlimento` = " + alimento.getTipoAlimento().getIdTipoAlimento() + ", `descuento` = "
				+ alimento.getDescuento() + "," + " `precio` = " + alimento.getPrecio() + ", `fechaModificacion` = '"
				+ alimento.getFechaModificacion() + "', `estatus` = " + alimento.isEstatus() + ", "
				+ "`idRestaurante` = " + alimento.getRestaurante().getIdRestaurante() + ", idMenu = "
				+ alimento.getMenu().getIdMenu() + " " + "WHERE (`idAlimento` = " + alimento.getIdAlimento() + ");";
		int ejecutado = ConnectionFactory.ejecutarSQL(sql);
		return ejecutado;
	}

	@Override
	public int eliminar(int idAlimento) throws SQLException {
		String sql = "DELETE FROM restaurante.alimento WHERE idAlimento = " + idAlimento + ";";
		int ejecutado = ConnectionFactory.ejecutarSQL(sql);
		return ejecutado;
	}

	@Override
	public List<Alimento> consultar() throws SQLException {
		String sql = "SELECT a.* FROM alimento a, tipo_alimento ta, restaurante r, menu m WHERE a.idTipoAlimento = ta.idTipoAlimento \r\n"
				+ "AND a.idRestaurante = r.idRestaurante AND a.idMenu = m.idMenu;";
		ResultSet rs = ConnectionFactory.ejecutarSQLSelect(sql);
		List<Alimento> alimentos = new ArrayList<>();
		if (rs != null) {
			while (rs.next()) {
				Alimento alimento = new Alimento();
				alimento.setIdAlimento(rs.getInt("idAlimento"));
				alimento.setNombre(rs.getString("nombre"));
				alimento.setDescripcion(rs.getString("descripcion"));
				alimento.setDescuento(rs.getInt("descuento"));
				alimento.setPrecio(rs.getDouble("precio"));
				alimento.setFechaCreacion(rs.getTimestamp("fechaCreacion").toLocalDateTime());
				alimento.setFechaModificacion(rs.getTimestamp("fechaModificacion") != null
						? rs.getTimestamp("fechaModificacion").toLocalDateTime()
						: null);
				
				TipoAlimento tipoAlimento = new TipoAlimento();
				tipoAlimento.setIdTipoAlimento(rs.getInt("idTipoAlimento"));
				
				alimento.setTipoAlimento(tipoAlimento);
				
				Restaurante restaurante = new Restaurante();
				restaurante.setIdRestaurante(rs.getInt("idRestaurante"));
				
				alimento.setRestaurante(restaurante);
				
				Menu menu = new Menu();
				menu.setIdMenu(rs.getInt("idMenu"));
				
				alimento.setMenu(menu);
				
				alimentos.add(alimento);
				
			}
		} 
		
		return alimentos;
	}

	@Override
	public Alimento consultarPorId(int idAlimento) throws SQLException, RestauranteException {
		String sql = "SELECT * FROM alimento WHERE idAlimento = " + idAlimento + ";";

		ResultSet rs = null;
		try {
			rs = ConnectionFactory.ejecutarSQLSelect(sql);
		} catch (Exception e) {
			if (e.getClass().getName().contains("SQLSyntaxErrorException")) {
				throw new RestauranteException("Error de sintaxis en la sentencia SQL: " + sql,
						CodigoEnum.SITAXIS_ERROR_CODE);
			}

		}

		Alimento alimento = null;
		if (rs != null) {
			if (rs.next()) {
				alimento = new Alimento();
				alimento.setIdAlimento(rs.getInt("idAlimento"));
				alimento.setNombre(rs.getNString("nombre"));
				alimento.setImagen(rs.getString("imagen"));
				alimento.setDescripcion(rs.getString("descripcion"));
				alimento.setPrecio(rs.getDouble("precio"));
				alimento.setDescuento(rs.getInt("descuento"));
				alimento.setFechaCreacion(rs.getTimestamp("fechaCreacion").toLocalDateTime());
				alimento.setFechaModificacion(rs.getTimestamp("fechaModificacion") != null
						? rs.getTimestamp("fechaModificacion").toLocalDateTime()
						: null);
				alimento.setEstatus(rs.getBoolean("estatus"));

			}
		}
		return alimento;
	}

}
