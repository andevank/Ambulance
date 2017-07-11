package co.ambulancia.demo.dao;

import java.util.List;

import co.ambulancia.demo.modelo.Servicio;

public interface IServiciosDAO {
	public void crear(Servicio entity);
	public void modificar(Servicio entity);
	public void borrar(Servicio entity);
	public Servicio consultarId(long usu_cedula);
	public List<Servicio> consultar();
}
