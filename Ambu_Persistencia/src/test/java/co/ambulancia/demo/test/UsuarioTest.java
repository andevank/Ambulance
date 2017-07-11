package co.ambulancia.demo.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.ambulancia.demo.modelo.TiposUsuarios;
import co.ambulancia.demo.modelo.Usuarios;

public class UsuarioTest {

	private final static Logger log = LoggerFactory.getLogger(UsuarioTest.class);

	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	private static Long usuId = 1001470L;

	@Test
	public void aTest() {
		entityManagerFactory = Persistence.createEntityManagerFactory("Ambu_Persistencia");
		entityManager = entityManagerFactory.createEntityManager();

		Usuarios usuarios = entityManager.find(Usuarios.class, usuId);
		assertNull("El usuario ya existe", usuarios);

		usuarios = new Usuarios();
		usuarios.setUsuCedula(usuId);
		usuarios.setUsuNombre("John Doe");
		usuarios.setUsuLogin("jdoe");
		usuarios.setUsuClave("1234");

		TiposUsuarios tiposUsuarios = entityManager.find(TiposUsuarios.class, 10L);
		assertNotNull("El tipo de Usuario no existe", tiposUsuarios);

		usuarios.setTiposUsuarios(tiposUsuarios);

		entityManager.getTransaction().begin();
		entityManager.persist(usuarios);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

	@Test
	public void bTest() {
		entityManagerFactory = Persistence.createEntityManagerFactory("Ambu_Persistencia");
		entityManager = entityManagerFactory.createEntityManager();

		Usuarios usuarios = entityManager.find(Usuarios.class, usuId);
		assertNotNull("El usuario no existe", usuarios);

		log.info("" + usuarios.getUsuCedula());
		log.info("" + usuarios.getUsuNombre());
		log.info("" + usuarios.getUsuLogin());

		entityManager.close();
		entityManagerFactory.close();
	}

	@Test
	public void cTest() {
		entityManagerFactory = Persistence.createEntityManagerFactory("Ambu_Persistencia");
		entityManager = entityManagerFactory.createEntityManager();

		Usuarios usuarios = entityManager.find(Usuarios.class, 10L);
		assertNotNull("El usuario ya existe", usuarios);

		usuarios = new Usuarios();
		usuarios.setUsuCedula(usuId);
		usuarios.setUsuNombre("John Doe Parker");
		usuarios.setUsuLogin("jdoe");
		usuarios.setUsuClave("5678");

		TiposUsuarios tiposUsuarios = entityManager.find(TiposUsuarios.class, 10L);
		assertNotNull("El tipo de Usuario no existe", tiposUsuarios);

		usuarios.setTiposUsuarios(tiposUsuarios);
		entityManager.getTransaction().begin();
		entityManager.merge(usuarios);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();

	}

	@Test
	public void dTest() {
		entityManagerFactory = Persistence.createEntityManagerFactory("Ambu_Persistencia");
		entityManager = entityManagerFactory.createEntityManager();

		Usuarios usuarios = entityManager.find(Usuarios.class, usuId);
		assertNotNull("El usuario no existe", usuarios);

		entityManager.getTransaction().begin();
		entityManager.remove(usuarios);
		entityManager.getTransaction().commit();

		log.info("" + usuarios.getUsuCedula());
		log.info(usuarios.getUsuNombre());

		entityManager.close();
		entityManagerFactory.close();

	}

	@Test
	public void eTest() {

		entityManagerFactory = Persistence.createEntityManagerFactory("Ambu_Persistencia");
		entityManager = entityManagerFactory.createEntityManager();

		String jqpl = "select usu from Usuarios usu";

		List<Usuarios> losusuarios = entityManager.createQuery(jqpl).getResultList();

		for (Usuarios usuarios : losusuarios) {

			log.info("");
		}

		entityManager.close();
		entityManagerFactory.close();
	}

}
