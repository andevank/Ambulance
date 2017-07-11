package co.ambulancia.demo.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.ambulancia.demo.modelo.Servicio;
import co.ambulancia.demo.modelo.TiposUsuarios;
import co.ambulancia.demo.modelo.Usuarios;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class ServicioDAOTest {

	@Autowired
	private IServiciosDAO serviciosDAO;
	
	private Long usu_cedula = 1096199L;

	private final static Logger log = LoggerFactory.getLogger(ServicioDAOTest.class);

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void aTest() {

	/**	assertNotNull(serviciosDAO);
		

		Servicio servicios = serviciosDAO.consultarId(usu_cedula);
		assertNull("El usuario ya existe", servicios);

		servicios = new Servicio();
		servicios.setCodigoSerrvicio(10L);
		
		serviciosDAO.crear(servicios);**/

	}

	@Test
	@Transactional(readOnly = true)
	public void bTest() {

		assertNotNull(serviciosDAO);

		Servicio servicios = serviciosDAO.consultarId(usu_cedula);
		assertNotNull("El usuario no existe", servicios);

		log.info("" + servicios.getCodigoServicio());
		log.info("" + servicios.getFechaServicio());
		log.info("" + servicios.getHoraServicio());
		
		
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void cTest() {
		
		/**assertNotNull(serviciosDAO);
		Usuarios usuarios = serviciosDAO.consultarId(usu_cedula);
		assertNotNull("El usuario no existe", usuarios);
		
		usuarios.setUsuNombre("John Doe Parker");
		usuarios.setUsuLogin("jdoe");
		usuarios.setUsuClave("5678");

		TiposUsuarios tiposUsuarios = tiposUsuariosDAO.consultarPorId(20L);
		assertNotNull("El tipo de Usuario no existe", tiposUsuarios);

		usuarios.setTiposUsuarios(tiposUsuarios);
		
		serviciosDAO.modificar(usuarios);**/

	}

	@Test
	@Transactional(readOnly = true)
	public void dTest() {
		
	/**	assertNotNull(serviciosDAO);
		Usuarios usuarios = serviciosDAO.consultarId(usu_cedula);
		assertNotNull("El Usuario no existe", usuarios);
		serviciosDAO.borrar(usuarios);**/
	}
	
	@Test
	@Transactional(readOnly = true)
	public void eTest() {

		List<Servicio> losServicios = serviciosDAO.consultar();

		for (Servicio servicio : losServicios) {

			log.info("" + servicio.getCodigoServicio());
			log.info("" + servicio.getFechaServicio());
			log.info("" + servicio.getHoraServicio());
		}
	}

	
}
