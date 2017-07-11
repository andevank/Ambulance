package co.ambulancia.demo.dao;

import java.util.List;

import co.ambulancia.demo.modelo.Usuarios;

public interface IUsuarioDAO {
	public void crear(Usuarios entity);
	public void modificar(Usuarios entity);
	public void borrar(Usuarios entity);
	public Usuarios consultarId(long usu_cedula);
	public Usuarios consultarLogin(String login);
	public List<Usuarios> consultar();
}
