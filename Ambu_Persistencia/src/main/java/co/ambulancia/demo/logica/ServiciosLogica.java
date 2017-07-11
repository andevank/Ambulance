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

import co.ambulancia.demo.dao.IServiciosDAO;
import co.ambulancia.demo.modelo.Servicio;

@Service
@Scope("singleton")
public class ServiciosLogica implements IServiciosLogica {

	@Autowired
	private IServiciosDAO serviciosDAO;

	//@Autowired
	//private ITiposUsuariosDAO tipoUsuariosDAO;

	@Autowired
	private Validator validator;

	public void validarServicios(Servicio servicios) throws Exception {
		try {
			Set<ConstraintViolation<Servicio>> constraintViolations = validator.validate(servicios);

			if (constraintViolations.size() > 0) {
				StringBuilder strMessage = new StringBuilder();

				for (ConstraintViolation<Servicio> constraintViolation : constraintViolations) {
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
	public void crearServicios(Servicio entity) throws Exception {
		if (entity == null) {
			throw new Exception("El usuario es nulo");
		}

		validarServicios(entity);

		Servicio servicios = serviciosDAO.consultarId(entity.getCodigoServicio());

		if (servicios != null) {
			throw new Exception("El usuario ya existe");
		}

		serviciosDAO.crear(entity);

	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificarServicios(Servicio entity) throws Exception {
		if(entity==null){
			throw new Exception("El usuario es nulo");
		}
		
		validarServicios(entity);
		
		serviciosDAO.modificar(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void borrarServicios(Servicio entity) throws Exception {
		if(entity==null){
			throw new Exception("El usuario es nulo");
		}
		
		Servicio servicios=serviciosDAO.consultarId(entity.getCodigoServicio());
		
		if(servicios==null){
			throw new Exception("El usuario que desea borrar no existe");
		}
		
		serviciosDAO.borrar(servicios);

	}

	@Override
	@Transactional(readOnly=true)
	public Servicio consultarPorId(long servCodigo) throws Exception {
		return serviciosDAO.consultarId(servCodigo);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Servicio> consultarServicios() {
		return serviciosDAO.consultar();
	}

}
