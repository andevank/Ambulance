package co.ambulancia.demo.dao;

import java.util.List;

import co.ambulancia.demo.modelo.TiposUsuarios;

public interface ITiposUsuariosDAO {

	
	public void crear(TiposUsuarios entity);
	public void modificar(TiposUsuarios entity);
	public void borrar(TiposUsuarios entity);
	public TiposUsuarios consultarPorId(long tusu_codigo);
	public List<TiposUsuarios> consultar();
}
