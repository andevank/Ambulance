package co.ambulancia.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.ambulancia.demo.modelo.Servicio;

@Repository
@Scope("singleton")
public class ServiciosDAO implements IServiciosDAO {

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void crear(Servicio entity) {
		entityManager.persist(entity);
	}
	
	@Override
	public void modificar(Servicio entity) {
		entityManager.merge(entity);
	}
	
	@Override
	public void borrar(Servicio entity) {
		entityManager.remove(entity);
	}
	
	@Override
	public Servicio consultarId(long usu_cedula) {
		return entityManager.find(Servicio.class, usu_cedula);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Servicio> consultar() {
		String jpql="Select ser from Servicio ser";
		return entityManager.createQuery(jpql).getResultList();
	}
}
