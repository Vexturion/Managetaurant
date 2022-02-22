/**
 * 
 */
package com.alejandro.restaurantesdata.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.alejandro.restauranteentities.entity.Empleado;
import com.alejandro.restauranteentities.entity.Menu;
import com.alejandro.restauranteentities.entity.Restaurante;
import com.alejandro.restauranteentities.entity.Rol;
import com.alejandro.restauranteentities.entity.Sucursal;
import com.alejandro.restaurantesdata.connection.ConnectionFactory;
import com.alejandro.restaurantesdata.dao.EmpleadoDAO;
import com.alejandro.restaurantesdata.myexceptions.RestauranteException;

/**
 * @author Jose Alejandro Cruz Duran clase que implementa la funcionalidad del
 *         CRUD de empleados
 *
 */
public class EmpleadoDAOImpl implements EmpleadoDAO {

	static {
		try {
			ConnectionFactory.conectar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int guardar(Empleado empleado) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizar(Empleado empleado) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminar(int idEmpleado) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Empleado> consultar() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado consultarPorId(int idEmpleado) throws SQLException, RestauranteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * metodo que nos permite consultar un empleado desde el login con su
	 * informacion y perfil en el sistema
	 * 
	 * @param usuario           parametro capturado por el usuario
	 * @param password          parametro capturado por el usuario
	 * @param superAdminGeneral verifica si el usuario es administrador general
	 * @return objeto con el empleado loggin
	 * @throws SQLException error en caso de ejecutar la sentencia sql
	 */
	public Empleado consultarPorUsuarioYPassword(String usuario, String password, boolean superAdminGeneral)
			throws SQLException {
		Empleado empleado = null;
		String sql = "";
		if (superAdminGeneral) {
			sql = "SELECT e.*, r.nombre AS nombreRol " + "FROM empleado e, rol r " + "WHERE e.idRol = r.idRol "
					+ "AND (e.usuario = '" + usuario + "' OR e.email = '" + usuario + "') " + "AND e.password = '"
					+ password + "' " + "AND e.idSucursal IS null;";
		} else {
			sql = "SELECT e.*, r.nombre as nombreRol, s.nombre as nombreSucursal, re.nombre as nombreRestaurante, re.idRestaurante ,re.imagen, re.idMenu "
					+ "FROM empleado e,rol r, sucursal s, restaurante re "
					+ "WHERE e.idRol = r.idRol AND e.idSucursal = s.idSucursal "
					+ "AND s.idRestaurante = re.idRestaurante " + "AND (e.usuario = '" + usuario + "' OR e.email = '"
					+ usuario + "') " + "AND password = '" + password + "';";
		}

		ResultSet rs = ConnectionFactory.ejecutarSQLSelect(sql);

		if (rs != null) {
			if (rs.next()) {
				empleado = new Empleado();
				empleado.setNombre(rs.getString("nombre"));
				empleado.setPrimerApellido(rs.getString("primerApellido"));
				empleado.setSegundoApellido(rs.getString("segundoApellido"));
				empleado.setUsuario(rs.getString("usuario"));
				empleado.setPassword(rs.getString("password"));
				empleado.setEmail(rs.getString("email"));
				empleado.setEstatus(rs.getBoolean("estatus"));
				empleado.setSuperAdmin(rs.getBoolean("superadmin"));
				empleado.setSuperAdminGeneral(rs.getBoolean("superadmingeneral"));

				Rol rol = new Rol();
				rol.setIdRol(rs.getInt("idRol"));
				rol.setNombre(rs.getString("nombreRol"));
				empleado.setRol(rol);

				// agregar funcionalidad para el caso de administrador de sucursa; y empleado
				if (!empleado.isSuperAdminGeneral()) {
					Sucursal sucursal = new Sucursal();
					sucursal.setIdSucursal(rs.getInt("idSucursal"));
					sucursal.setNombre(rs.getString("nombreSucursal"));
					empleado.setSucursal(sucursal);

					Restaurante restaurante = new Restaurante();
					restaurante.setIdRestaurante(rs.getInt("idRestaurante"));
					restaurante.setNombre(rs.getString("nombreRestaurante"));
					restaurante.setImagen(rs.getString("imagen"));
					sucursal.setRestaurante(restaurante);

					Menu menu = new Menu();
					menu.setIdMenu(rs.getInt("idMenu"));
					restaurante.setMenu(menu);

				}
			}

		}
		return empleado;
	}
}
