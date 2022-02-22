/**
 * 
 */
package com.alejandro.restauranteentities.entity;

/**
 * @author Horiz
 *
 */
public class Empleado extends CommonEntity {
	
	/**
	 * id del empleado
	 */
	private int idEmpleado;
	/**
	 * nombre del empleado
	 */
	private String nombre;
	/**
	 * primer apellido del empleado
	 */
	private String primerApellido;
	/**
	 * segundo apellido del empleado
	 */
	private String segundoApellido;
	/**
	 * rol del empleado
	 */
	private Rol rol;
	/**
	 * sucursal a la que pertenece el empleado (superadmingeneral no pertenece a ninguna sucursal)
	 */
	private Sucursal sucursal;
	/**
	 * usuario del empleado
	 */
	private String usuario;
	/**
	 * password del empleado
	 */
	private String password;
	/**
	 * email del empleado
	 */
	private String email;
	/**
	 * es super admin el empleado?
	 */
	private boolean superAdmin;
	/**
	 * es superadmingeneral el empleado?
	 */
	private boolean superAdminGeneral;
	/**
	 * @return the idEmpleado
	 */
	public int getIdEmpleado() {
		return idEmpleado;
	}
	/**
	 * @param idEmpleado the idEmpleado to set
	 */
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the primerApellido
	 */
	public String getPrimerApellido() {
		return primerApellido;
	}
	/**
	 * @param primerApellido the primerApellido to set
	 */
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	/**
	 * @return the segundoApellido
	 */
	public String getSegundoApellido() {
		return segundoApellido;
	}
	/**
	 * @param segundoApellido the segundoApellido to set
	 */
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	/**
	 * @return the rol
	 */
	public Rol getRol() {
		return rol;
	}
	/**
	 * @param rol the rol to set
	 */
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	/**
	 * @return the sucursal
	 */
	public Sucursal getSucursal() {
		return sucursal;
	}
	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the superAdmin
	 */
	public boolean isSuperAdmin() {
		return superAdmin;
	}
	/**
	 * @param superAdmin the superAdmin to set
	 */
	public void setSuperAdmin(boolean superAdmin) {
		this.superAdmin = superAdmin;
	}
	/**
	 * @return the superAdminGeneral
	 */
	public boolean isSuperAdminGeneral() {
		return superAdminGeneral;
	}
	/**
	 * @param superAdminGeneral the superAdminGeneral to set
	 */
	public void setSuperAdminGeneral(boolean superAdminGeneral) {
		this.superAdminGeneral = superAdminGeneral;
	}

}
