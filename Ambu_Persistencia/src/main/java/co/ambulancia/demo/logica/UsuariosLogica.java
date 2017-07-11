package co.ambulancia.demo.logica;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.ambulancia.demo.dao.IUsuarioDAO;
import co.ambulancia.demo.modelo.Usuarios;

@Service
@Scope("singleton")
public class UsuariosLogica implements IUsuariosLogica {

	@Autowired
	private IUsuarioDAO usuariosDAO;

	// @Autowired
	// private ITiposUsuariosDAO tipoUsuariosDAO;

	@Autowired
	private Validator validator;

	public void validarusuarios(Usuarios usuarios) throws Exception {
		try {
			Set<ConstraintViolation<Usuarios>> constraintViolations = validator.validate(usuarios);

			if (constraintViolations.size() > 0) {
				StringBuilder strMessage = new StringBuilder();

				for (ConstraintViolation<Usuarios> constraintViolation : constraintViolations) {
					strMessage.append(constraintViolation.getPropertyPath().toString());
					strMessage.append(" - ");
					strMessage.append(constraintViolation.getMessage());
					strMessage.append(". \n");
				}

				throw new Exception(strMessage.toString());
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void crearUsuarios(Usuarios entity) throws Exception {
		if (entity == null) {
			throw new Exception("El usuario es nulo");
		}

		validarusuarios(entity);

		Usuarios usuarios = usuariosDAO.consultarId(entity.getUsuCedula());

		if (usuarios != null) {
			throw new Exception("El usuario ya existe");
		}

		usuariosDAO.crear(entity);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void modificarUsuarios(Usuarios entity) throws Exception {
		if (entity == null) {
			throw new Exception("El usuario es nulo");
		}

		validarusuarios(entity);

		usuariosDAO.modificar(entity);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void borrarUsuarios(Usuarios entity) throws Exception {
		if (entity == null) {
			throw new Exception("El usuario es nulo");
		}

		Usuarios usuarios = usuariosDAO.consultarId(entity.getUsuCedula());

		if (usuarios == null) {
			throw new Exception("El usuario que desea borrar no existe");
		}

		usuariosDAO.borrar(usuarios);

	}

	@Override
	@Transactional(readOnly = true)
	public Usuarios consultarPorId(long usuCedula) throws Exception {
		return usuariosDAO.consultarId(usuCedula);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuarios consultarPorLogin(String usuLogin) throws Exception {
		return usuariosDAO.consultarLogin(usuLogin);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuarios> consultarUsuarios() {
		return usuariosDAO.consultar();
	}

}
