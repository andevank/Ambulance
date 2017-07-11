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

import co.ambulancia.demo.modelo.TiposUsuarios;
import co.ambulancia.demo.modelo.Usuarios;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class UsuarioDAOTest {

	@Autowired
	private IUsuarioDAO usuariosDAO;

	@Autowired
	private ITiposUsuariosDAO tiposUsuariosDAO;

	private Long usu_cedula = 1096199L;

	private final static Logger log = LoggerFactory.getLogger(UsuarioDAOTest.class);

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void aTest() {

		assertNotNull(usuariosDAO);
		assertNotNull(tiposUsuariosDAO);

		Usuarios usuarios = usuariosDAO.consultarId(usu_cedula);
		assertNull("El usuario ya existe", usuarios);

		usuarios = new Usuarios();
		usuarios.setUsuCedula(usu_cedula);
		usuarios.setUsuNombre("John Connor");
		usuarios.setUsuLogin("jconnor");
		usuarios.setUsuClave("1234");

		TiposUsuarios tiposUsuarios = tiposUsuariosDAO.consultarPorId(10L);
		assertNotNull("El tipo de Usuario no existe", tiposUsuarios);

		usuarios.setTiposUsuarios(tiposUsuarios);
		usuariosDAO.crear(usuarios);

	}

	@Test
	@Transactional(readOnly = true)
	public void bTest() {

		assertNotNull(usuariosDAO);

		Usuarios usuarios = usuariosDAO.consultarId(usu_cedula);
		assertNotNull("El usuario no existe", usuarios);

		log.info("" + usuarios.getUsuCedula());
		log.info("" + usuarios.getUsuNombre());
		log.info("" + usuarios.getUsuLogin());
		
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void cTest() {
		
		assertNotNull(usuariosDAO);
		Usuarios usuarios = usuariosDAO.consultarId(usu_cedula);
		assertNotNull("El usuario no existe", usuarios);
		
		usuarios.setUsuNombre("John Doe Parker");
		usuarios.setUsuLogin("jdoe");
		usuarios.setUsuClave("5678");

		TiposUsuarios tiposUsuarios = tiposUsuariosDAO.consultarPorId(20L);
		assertNotNull("El tipo de Usuario no existe", tiposUsuarios);

		usuarios.setTiposUsuarios(tiposUsuarios);
		
		usuariosDAO.modificar(usuarios);

	}

	@Test
	@Transactional(readOnly = true)
	public void dTest() {
		
		assertNotNull(usuariosDAO);
		Usuarios usuarios = usuariosDAO.consultarId(usu_cedula);
		assertNotNull("El Usuario no existe", usuarios);
		usuariosDAO.borrar(usuarios);
	}
	
	@Test
	@Transactional(readOnly = true)
	public void eTest() {

		List<Usuarios> losUsuarios = usuariosDAO.consultar();

		for (Usuarios usuarios : losUsuarios) {

			log.info(""+usuarios.getUsuLogin());
			log.info(""+usuarios.getUsuClave());
			log.info(""+usuarios.getUsuCedula());
			log.info(""+usuarios.getUsuNombre());
		}
	}

	
}
