package co.ambulancia.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.ambulancia.demo.modelo.Usuarios;

@Repository
@Scope("singleton")
public class UsuariosDAO implements IUsuarioDAO {

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void crear(Usuarios entity) {
		entityManager.persist(entity);
	}
	
	@Override
	public void modificar(Usuarios entity) {
		entityManager.merge(entity);
	}
	
	@Override
	public void borrar(Usuarios entity) {
		entityManager.remove(entity);
	}
	
	@Override
	public Usuarios consultarId(long usu_cedula) {
		return entityManager.find(Usuarios.class, usu_cedula);
	}
	
	@Override
	public Usuarios consultarLogin(String usu_login) {
		String hql="SELECT usu FROM Usuarios usu WHERE usu.usuLogin=:login";
		Usuarios usuarios=(Usuarios)entityManager.createQuery(hql).setParameter("login", usu_login).getSingleResult();
		return usuarios;
	}
	
	@Override
	public List<Usuarios> consultar() {
		String jpql="Select usu from Usuarios usu";
		return entityManager.createQuery(jpql).getResultList();
	}
}
