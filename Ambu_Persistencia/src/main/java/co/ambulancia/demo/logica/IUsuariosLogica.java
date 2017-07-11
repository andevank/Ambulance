package co.ambulancia.demo.logica;

import java.util.List;

import co.ambulancia.demo.modelo.Usuarios;

public interface IUsuariosLogica {
	
	public void crearUsuarios(Usuarios entity)throws Exception;
	public void modificarUsuarios(Usuarios entity)throws Exception;
	public void borrarUsuarios(Usuarios entity)throws Exception;
	public Usuarios consultarPorId(long cliId)throws Exception;
	public Usuarios consultarPorLogin(String usulogin)throws Exception;
	public List<Usuarios> consultarUsuarios();
	

}
