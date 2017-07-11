package co.ambulancia.demo.dao;

import java.util.List;

import co.ambulancia.demo.modelo.TiposDocumentos;

public interface ITiposDocumentosDAO {

	
	public void crear(TiposDocumentos entity);
	public void modificar(TiposDocumentos entity);
	public void borrar(TiposDocumentos entity);
	public TiposDocumentos consultarPorId(long tdocCodigo);
	public List<TiposDocumentos> consultar();
}
