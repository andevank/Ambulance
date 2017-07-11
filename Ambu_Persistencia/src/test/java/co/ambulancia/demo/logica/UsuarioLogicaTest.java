package co.ambulancia.demo.logica;

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

import co.ambulancia.demo.dao.ITiposUsuariosDAO;
import co.ambulancia.demo.modelo.TiposUsuarios;
import co.ambulancia.demo.modelo.Usuarios;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class UsuarioLogicaTest {
	
	private final static Logger log=LoggerFactory.getLogger(UsuarioLogicaTest.class);
	
	@Autowired
	private IUsuariosLogica usuariosLogica;
	
	@Autowired
	private ITiposUsuariosDAO tiposUsuariosDAO;	
	
	private Long usu_Cedula=10L;

	@Test
	public void atest()throws Exception {
		assertNotNull(usuariosLogica);
		assertNotNull(tiposUsuariosDAO);
		
		Usuarios usuarios=usuariosLogica.consultarPorId(usu_Cedula);
		assertNull("El usuario ya existe", usuarios);
		
		usuarios=new Usuarios();
		usuarios.setUsuCedula(1001470L);
		usuarios.setUsuNombre("Maximus");
		usuarios.setUsuLogin("madmax");
		usuarios.setUsuClave("1234");
		
		TiposUsuarios tiposUsuarios =tiposUsuariosDAO.consultarPorId(20L);
		assertNotNull("El tipo de usuario no existe", tiposUsuarios);
		
		usuarios.setTiposUsuarios(tiposUsuarios);
		
		usuariosLogica.crearUsuarios(usuarios);
		
	}
	
	
	@Test
	public void btest()throws Exception {
		assertNotNull(usuariosLogica);
		assertNotNull(tiposUsuariosDAO);
		
		Usuarios usuarios=usuariosLogica.consultarPorId(usu_Cedula);
		assertNotNull("El usuario no existe", usuarios);
		
		log.info("Nombre:"+usuarios.getUsuNombre());
		
		
	}
	
	@Test
	public void ctest() throws Exception{
		assertNotNull(usuariosLogica);
		assertNotNull(tiposUsuariosDAO);
		
		Usuarios usuarios=usuariosLogica.consultarPorId(10L);
		assertNotNull("El usuario no existe", usu_Cedula);		
				
		usuarios.setUsuNombre("Maximus");
		usuarios.setUsuLogin("madmax");
		usuarios.setUsuClave("56788	");
		
		TiposUsuarios tiposUsuarios =tiposUsuariosDAO.consultarPorId(10L);
		assertNotNull("El tipo de documento no existe", tiposUsuarios);
		
		usuarios.setTiposUsuarios(tiposUsuarios);
		
		usuariosLogica.modificarUsuarios(usuarios);
		
	}
	
	@Test
	public void dtest()throws Exception {
		assertNotNull(usuariosLogica);
		assertNotNull(tiposUsuariosDAO);
		
		Usuarios usuarios=usuariosLogica.consultarPorId(usu_Cedula);
		assertNotNull("El usuario no existe", usuarios);
		
		usuariosLogica.borrarUsuarios(usuarios);
		
	}
	
	@Test	
	public void etest() {
		assertNotNull(usuariosLogica);
		assertNotNull(tiposUsuariosDAO);
		
		List<Usuarios> losUsuarios=usuariosLogica.consultarUsuarios();
		
		for (Usuarios usuarios : losUsuarios) {
			log.info(""+usuarios.getUsuNombre());
			log.info(""+usuarios.getUsuCedula());
		}
		
		
	}

}




