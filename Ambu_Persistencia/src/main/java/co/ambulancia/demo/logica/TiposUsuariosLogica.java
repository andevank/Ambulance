package co.ambulancia.demo.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.ambulancia.demo.dao.ITiposUsuariosDAO;
import co.ambulancia.demo.modelo.TiposUsuarios;

@Service
@Scope("singleton")
public class TiposUsuariosLogica implements ITiposUsuariosLogica {

	@Autowired
	private ITiposUsuariosDAO tiposUsuariosDAO;
	
	@Override
	public TiposUsuarios consultarPorId(long tdocCodigo) {
		return tiposUsuariosDAO.consultarPorId(tdocCodigo);
	}

	@Override
	public List<TiposUsuarios> consultar() {
		return tiposUsuariosDAO.consultar();
	}

}
