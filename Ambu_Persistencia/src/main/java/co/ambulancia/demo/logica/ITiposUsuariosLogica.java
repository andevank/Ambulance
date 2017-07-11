package co.ambulancia.demo.logica;

import java.util.List;

import co.ambulancia.demo.modelo.TiposUsuarios;

public interface ITiposUsuariosLogica {
	
	public TiposUsuarios consultarPorId(long tusuCodigo);

	public List<TiposUsuarios> consultar();

}
