package co.ambulancia.demo.logica;

import java.util.List;

import co.ambulancia.demo.modelo.Servicio;

public interface IServiciosLogica {
	
	public void crearServicios(Servicio entity)throws Exception;
	public void modificarServicios(Servicio entity)throws Exception;
	public void borrarServicios(Servicio entity)throws Exception;
	public Servicio consultarPorId(long cliId)throws Exception;
	public List<Servicio> consultarServicios();

}
