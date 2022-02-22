/**
 * 
 */
package com.alejandro.restaurantesdata.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimeZone;

/**
 * @author Jose Alejandro Cruz
 * clase que se encarga de configurar la conexion y habilita las
 * transacciones con una base de datos
 *
 */
public class ConnectionFactory {
	/**
	 * objeto encargado de mantener la conexion con la base de datos
	 */

	private static Connection connection;
	/**
	 * objeto encargado de habilitar y ejecutar las sentencias sql
	 */
	private static Statement statement;
	
	/**
	 * objeto que nos permite conectar a la base de datos
	 * @return objeto connection con la informacion de la base de datos | null
	 * @throws ClassNotFoundException excepcion generada al no cargar el driver de conexion
	 * @throws SQLException excepcion generada al no conectarse a la base de datos
	 */
	public static Connection conectar() throws ClassNotFoundException, SQLException {
		// paso 1: Cargar el driver de conexion
		Class.forName("com.mysql.cj.jdbc.Driver");
		// paso 2 establecer los datos de conexion
		String url ="jdbc:mysql://localhost:3306/restaurante?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDateTimeCode=false&serverTimezone=" + TimeZone.getDefault().getID();
		String user = "root";
		String password = "i3t2m3M9B4";
		//paso 3: establecer la conexion
		connection = DriverManager.getConnection(url, user, password);
		
		statement = connection.createStatement(); // habilitando proceso para ejecutar sentencias sql
		
		return  connection;
	} 

	/**
	 * Metodo que nos permite ejecutar sentencias SQL (INSERT, UPDATE, DELETE)
	 * @param sql sentencia a ejecutarse
	 * @return 1 en caso de ser exitoso o 0 en caso de error
	 * @throws SQLException Excepcion generada en caso de que la sentencias SQL falle
	 */
	public static int ejecutarSQL(String sql) throws SQLException {
		System.out.println("Query: " + sql);
		return statement.executeUpdate(sql);
	}
	
	/**
	 * permite ejecutar sentencias SELECT 
	 * @param sql sentencias a ejecutarse
	 * @return objeto con la informacion obtenida de la sentencias selec
	 * @throws SQLException Excepcion generada en caso de que la sentencias SQL falle
	 */
	public static ResultSet ejecutarSQLSelect(String sql) throws SQLException {
		System.out.println("Query " + sql);
		return statement.executeQuery(sql);
	}
}
