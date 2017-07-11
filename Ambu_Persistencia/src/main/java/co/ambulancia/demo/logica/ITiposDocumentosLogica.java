package co.ambulancia.demo.logica;

import java.util.List;

import co.ambulancia.demo.modelo.TiposDocumentos;

public interface ITiposDocumentosLogica {

	public TiposDocumentos consultarPorId(long tdocCodigo);

	public List<TiposDocumentos> consultar();

}