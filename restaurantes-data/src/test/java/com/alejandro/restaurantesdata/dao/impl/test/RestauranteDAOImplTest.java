/**
 * 
 */
package com.alejandro.restaurantesdata.dao.impl.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.alejandro.restauranteentities.entity.Menu;
import com.alejandro.restauranteentities.entity.Restaurante;
import com.alejandro.restauranteentities.entity.TipoRestaurante;
import com.alejandro.restaurantesdata.dao.impl.RestauranteDAOImpl;

/**
 * @author Horiz
 *
 */

class RestauranteDAOImplTest {

	@Test
	void testGuardarExitoso() {
		RestauranteDAOImpl restauranteDAOImpl = new RestauranteDAOImpl();

		Restaurante restaurante = new Restaurante();
		restaurante.setNombre("La torre eiffel");
		restaurante.setImagen("eiffelres.jpg");
		restaurante.setEstatus(true);
		restaurante.setFechaCreacion(LocalDateTime.now());
		restaurante.setSlogan("Un pedazo de Francia en Mexico");

		TipoRestaurante tipoRestaurante = new TipoRestaurante();
		tipoRestaurante.setIdTipoRestaurante(22);
		restaurante.setTipoRestaurante(tipoRestaurante);

		Menu menu = new Menu();
		menu.setIdMenu(5);
		restaurante.setMenu(menu);

		int guardado = 0;

		try {
			// primer caso: exitoso si guardado es mayor a 0.
			guardado = restauranteDAOImpl.guardar(restaurante);
			assertTrue(guardado > 0);
			System.out.println("Se guardo exitosamente");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testGuardarErrorEnSQL() {
		RestauranteDAOImpl restauranteDAOImpl = new RestauranteDAOImpl();

		Restaurante restaurante = new Restaurante();
		restaurante.setNombre("Restaurante Ramen io");
		restaurante.setImagen("ramenio.jpg");
		restaurante.setEstatus(true);
		restaurante.setFechaCreacion(LocalDateTime.now());
		restaurante.setSlogan("El mejor ramen japones en mexico");

		TipoRestaurante tipoRestaurante = new TipoRestaurante();
		tipoRestaurante.setIdTipoRestaurante(18);
		restaurante.setTipoRestaurante(tipoRestaurante);

		Menu menu = new Menu();
		menu.setIdMenu(4);
		restaurante.setMenu(menu);

		int guardado = 0;

		try {
			guardado = restauranteDAOImpl.guardar(restaurante);

		} catch (SQLException e) {
			// exitoso si no se guardo el restaurante por que hubo un error en la sentecia
			// sql
			assertTrue(guardado == 0);
			System.err.println("No se guardo...");
			e.printStackTrace();
		}
	}

	@Test
	void actualizar() {
		RestauranteDAOImpl restauranteDAOImpl = new RestauranteDAOImpl();

		Restaurante restaurante = new Restaurante();
		restaurante.setIdRestaurante(15);
		restaurante.setNombre("El Naruto");
		restaurante.setImagen("elnarutores.jpg");
		restaurante.setEstatus(false);
		restaurante.setFechaModificacion(LocalDateTime.now());
		restaurante.setSlogan("Del anime a tu mesa");

		TipoRestaurante tipoRestaurante = new TipoRestaurante();
		tipoRestaurante.setIdTipoRestaurante(18);
		restaurante.setTipoRestaurante(tipoRestaurante);

		assertTrue(restaurante.getTipoRestaurante().getIdTipoRestaurante() == 18);

		Menu menu = new Menu();
		menu.setIdMenu(4);
		restaurante.setMenu(menu);

		assertTrue(restaurante.getMenu().getIdMenu() == 4);

		int actualizado = 0;

		try {
			actualizado = restauranteDAOImpl.actualizar(restaurante);
			assertTrue(actualizado > 0);
			System.out.println("Se ha actualizado correctamente");

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Ha ocurrido un error al actualizar el registro" + e.getCause());
		}
	}

	@Test
	void eliminar() {
		int idREstaurante = 17;
		RestauranteDAOImpl restauranteDAOImpl = new RestauranteDAOImpl();
		 try {
			assertTrue(idREstaurante == 17);
			
			int eliminado = restauranteDAOImpl.eliminar(idREstaurante);
			
			assertTrue(eliminado>0);
			System.out.println("Se elimino el registro correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getCause());
		}

	}

	@Test
	void consultarExitoso(){
		RestauranteDAOImpl restauranteDAOImpl = new RestauranteDAOImpl();
		
		try {
			List<Restaurante> restaurantesConsultados = restauranteDAOImpl.consultar();
		assertTrue(restaurantesConsultados.size()>0);
		for (Restaurante restaurante : restaurantesConsultados) {
			System.out.println("Id Restaurante: " + restaurante.getIdRestaurante());
			System.out.println("Nombre Restaurante: " + restaurante.getNombre());
			System.out.println("Imagen: " + restaurante.getImagen());
			System.out.println("Fecha Creacion: " + restaurante.getFechaCreacion());
			System.out.println("Fecha modificacion: " + restaurante.getFechaModificacion());
			System.out.println("Estatus: " + restaurante.isEstatus() + "\n");
		}
		} catch (Exception e) {
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		
	}
	
}
