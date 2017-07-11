package co.ambulancia.demo.vista;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import co.ambulancia.demo.logica.IServiciosLogica;
import co.ambulancia.demo.modelo.Servicio;

@ManagedBean
@ViewScoped
public class ServicioVista {

	@ManagedProperty("#{serviciosLogica}")
	private IServiciosLogica serviciosLogica;

	private List<Servicio> losServicios;

	private String sbFecha;
	private String sbHora;
	private InputText txtOperador;
	private InputText txtEntidad;
	private InputText txtAutoriza_Codigo;
	private InputText txtHora_Recogida;
	private InputText txtHora_Cita;
	private InputTextarea txtObservaciones;
	private InputText txtSolicitante;
	private InputText txtTraslado_Requerimiento;
	private InputText txtPerimetro_requerido;
	private InputText txt_Nombre_Paciente;
	private InputText txtEdad_Paciente;
	private InputText txtDiagnostico;
	private InputText txtCedulaPaciente;
	private InputText txtTeléfono_Paciente;
	private InputText txtLugar_Origen;
	private InputText txtLugar_Destino;
	private InputText txtHistoriaPaciente;
	private InputText txtMovil_Despachada;
	private InputText txtHora_Despacho_Origen;
	private InputText txtMedico;
	private InputText txtHora_Llegada_Sitio;
	private InputText txtDesplazamiento;
	private InputText txtHora_Llegada_Destino;
	private InputText txtMovil_Disponible;
	private CommandButton btnCrear;
	private CommandButton btnModificar;
	private CommandButton btnBorrar;
	private SelectOneMenu somColores;
	private List<SelectItem> losColoresSelectItem;
	

	public String crearAction() {

		try {

			Servicio servicio = new Servicio();
			servicio.setFechaServicio(sbFecha);
			servicio.setHoraServicio(sbHora);
			servicio.setOperador(txtOperador.getValue().toString());
			servicio.setEntidad(txtEntidad.getValue().toString());
			servicio.setAutorizaCodigo(txtAutoriza_Codigo.getValue().toString());
			servicio.setHoraRecogida(txtHora_Recogida.getValue().toString());
			servicio.setHoraCita(txtHora_Cita.getValue().toString());

			servicio.setObservaciones(txtObservaciones.getValue().toString());
			servicio.setSolicitante(txtSolicitante.getValue().toString());
			servicio.setTrasladoRequerimiento(txtTraslado_Requerimiento.getValue().toString());
			servicio.setPerimetroRequerido(txtPerimetro_requerido.getValue().toString());

			servicio.setNombrePaciente(txt_Nombre_Paciente.getValue().toString());
			servicio.setEdadPaciente(txtEdad_Paciente.getValue().toString());
			servicio.setDiagnostico(txtDiagnostico.getValue().toString());
			servicio.setCedulaPaciente(txtCedulaPaciente.getValue().toString());
			servicio.setTelefonoPaciente(txtTeléfono_Paciente.getValue().toString());

			servicio.setLugarOrigen(txtLugar_Origen.getValue().toString());
			servicio.setLugarDestino(txtLugar_Destino.getValue().toString());
			servicio.setHistoriaPaciente(txtHistoriaPaciente.getValue().toString());
			servicio.setMovilDespachada(txtMovil_Despachada.getValue().toString());
			servicio.setHoraDespachoOrigen(txtHora_Despacho_Origen.getValue().toString());

			servicio.setMedicoPaciente(txtMedico.getValue().toString());
			servicio.setHoraLlegadaSitio(txtHora_Llegada_Sitio.getValue().toString());
			servicio.setDesplazamiento(txtDesplazamiento.getValue().toString());
			servicio.setHoraLlegadaDestino(txtHora_Llegada_Destino.getValue().toString());
			servicio.setMovilDisponible(txtMovil_Disponible.getValue().toString());
			servicio.setEstado(somColores.getValue().toString());
			
			serviciosLogica.crearServicios(servicio);			

			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "El Servicio se creo con exito", ""));
			limpiarAction();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return "";
	}
	
	public String modificarAction() {	
		
		try {

			Servicio servicio = new Servicio();

			servicio.setAutorizaCodigo(txtAutoriza_Codigo.getValue().toString());
			servicio.setHoraRecogida(txtHora_Recogida.getValue().toString());
			servicio.setHoraCita(txtHora_Cita.getValue().toString());

			servicio.setObservaciones(txtObservaciones.getValue().toString());
			servicio.setSolicitante(txtSolicitante.getValue().toString());
			servicio.setTrasladoRequerimiento(txtTraslado_Requerimiento.getValue().toString());
			servicio.setPerimetroRequerido(txtPerimetro_requerido.getValue().toString());

			servicio.setNombrePaciente(txt_Nombre_Paciente.getValue().toString());
			servicio.setEdadPaciente(txtEdad_Paciente.getValue().toString());
			servicio.setDiagnostico(txtDiagnostico.getValue().toString());
			servicio.setCedulaPaciente(txtCedulaPaciente.getValue().toString());
			servicio.setTelefonoPaciente(txtTeléfono_Paciente.getValue().toString());

			servicio.setLugarOrigen(txtLugar_Origen.getValue().toString());
			servicio.setLugarDestino(txtLugar_Destino.getValue().toString());
			servicio.setHistoriaPaciente(txtHistoriaPaciente.getValue().toString());
			servicio.setMovilDespachada(txtMovil_Despachada.getValue().toString());
			servicio.setHoraDespachoOrigen(txtHora_Despacho_Origen.getValue().toString());

			servicio.setMedicoPaciente(txtMedico.getValue().toString());
			servicio.setHoraLlegadaSitio(txtHora_Llegada_Sitio.getValue().toString());
			servicio.setDesplazamiento(txtDesplazamiento.getValue().toString());
			servicio.setHoraLlegadaDestino(txtHora_Llegada_Destino.getValue().toString());
			servicio.setMovilDisponible(txtMovil_Disponible.getValue().toString());
			servicio.setEstado(somColores.getValue().toString());

		//	serviciosLogica.modificarServicios(servicio);
			

			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "El Servicio se actualizó con exito", ""));
			limpiarAction();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return "";
	}

	public String borrarAction() {
	/**	try {
			Long usuCedula = Long.parseLong(txtCedula.getValue().toString());
			Usuarios usuarios = new Usuarios();
			usuarios.setUsuCedula(usuCedula);
			usuarios.setUsuNombre(txtNombre.getValue().toString());
			usuarios.setUsuLogin(txtLogin.getValue().toString());
			usuarios.setUsuClave(txtClave.getValue().toString());

			Long tusuCodigo = Long.parseLong(somTiposUsuarios.getValue().toString());
			TiposUsuarios tiposUsuarios = tiposUsuariosLogica.consultarPorId(tusuCodigo);

			usuarios.setTiposUsuarios(tiposUsuarios);

			usuariosLogica.borrarUsuarios(usuarios);
			losUsuarios = null;

			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "El usuario se borro con exito", ""));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}**/
		return "";
	}
	
	public void sonColoresListener() {
		if(somColores.getValue().toString().equals("Amarillo")){
			System.out.println("Estoy en el amarillo");
		}
			
	}
	
	public void onRowEdit(RowEditEvent event) {
		
		Servicio servObj= (Servicio) event.getObject();
		Servicio servicio= new Servicio();
			
		servicio.setCodigoServicio(servObj.getCodigoServicio());
		servicio.setFechaServicio(servObj.getFechaServicio());
		servicio.setHoraServicio(servObj.getHoraServicio());
		servicio.setOperador(servObj.getOperador());
		servicio.setEntidad(servObj.getEntidad());
		servicio.setAutorizaCodigo(servObj.getAutorizaCodigo());
		servicio.setHoraRecogida(servObj.getHoraRecogida());
		servicio.setHoraCita(servObj.getHoraCita());

		servicio.setObservaciones(servObj.getObservaciones());
		servicio.setSolicitante(servObj.getSolicitante());
		servicio.setTrasladoRequerimiento(servObj.getTrasladoRequerimiento());
		servicio.setPerimetroRequerido(servObj.getPerimetroRequerido());

		servicio.setNombrePaciente(servObj.getNombrePaciente());
		servicio.setEdadPaciente(servObj.getEdadPaciente());
		servicio.setDiagnostico(servObj.getDiagnostico());
		servicio.setCedulaPaciente(servObj.getCedulaPaciente());
		servicio.setTelefonoPaciente(servObj.getTelefonoPaciente());

		servicio.setLugarOrigen(servObj.getLugarOrigen());
		servicio.setLugarDestino(servObj.getLugarDestino());
		servicio.setHistoriaPaciente(servObj.getHistoriaPaciente());
		servicio.setMovilDespachada(servObj.getMovilDespachada());
		servicio.setHoraDespachoOrigen(servObj.getHoraDespachoOrigen());

		servicio.setMedicoPaciente(servObj.getMedicoPaciente());
		servicio.setHoraLlegadaSitio(servObj.getHoraLlegadaSitio());
		servicio.setDesplazamiento(servObj.getDesplazamiento());
		servicio.setHoraLlegadaDestino(servObj.getHoraLlegadaDestino());
		servicio.setMovilDisponible(servObj.getMovilDisponible());
		servicio.setEstado(somColores.getValue().toString());
		
		System.out.println("Entidad modificada: "+servObj.getEntidad());
		System.out.println("Entidad modificada: "+servObj.getEstado());
		
		
		
		try {
			serviciosLogica.modificarServicios(servicio);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
       // FacesMessage msg = new FacesMessage("Servicio Editado", ""+((Servicio) event.getObject()).getCodigoServicio());
       // FacesContext.getCurrentInstance().addMessage(null, msg);
        
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion Cancelado", ""+((Servicio) event.getObject()).getCodigoServicio());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
	
	
	

	public String limpiarAction() {

		losServicios = null;
		limpiarTexto();
		return "";
	}

	public void limpiarTexto() {
		txtOperador.resetValue();
		txtEntidad.resetValue();
		txtAutoriza_Codigo.resetValue();
		txtHora_Recogida.resetValue();
		txtHora_Cita.resetValue();

		txtObservaciones.resetValue();
		txtSolicitante.resetValue();
		txtTraslado_Requerimiento.resetValue();
		txtPerimetro_requerido.resetValue();

		txt_Nombre_Paciente.resetValue();
		txtEdad_Paciente.resetValue();
		txtDiagnostico.resetValue();
		txtCedulaPaciente.resetValue();
		txtTeléfono_Paciente.resetValue();

		txtLugar_Origen.resetValue();
		txtLugar_Destino.resetValue();
		txtHistoriaPaciente.resetValue();
		txtMovil_Despachada.resetValue();
		txtHora_Despacho_Origen.resetValue();

		txtMedico.resetValue();
		txtHora_Llegada_Sitio.resetValue();
		txtDesplazamiento.resetValue();
		txtHora_Llegada_Destino.resetValue();
		txtMovil_Disponible.resetValue();
	}

	public String getSbFecha() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		sbFecha = dateFormat.format(date);
		return sbFecha;
	}

	public void setSbFecha(String sbFecha) {
		this.sbFecha = sbFecha;
	}

	public String getSbHora() {
		Date date = new Date();
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
		sbHora = hourFormat.format(date);
		return sbHora;
	}

	public void setSbHora(String sbHora) {
		this.sbHora = sbHora;
	}

	public InputText getTxtOperador() {
		return txtOperador;
	}

	public void setTxtOperador(InputText txtOperador) {
		this.txtOperador = txtOperador;
	}

	public InputText getTxtEntidad() {
		return txtEntidad;
	}

	public void setTxtEntidad(InputText txtEntidad) {
		this.txtEntidad = txtEntidad;
	}

	public InputText getTxtAutoriza_Codigo() {
		return txtAutoriza_Codigo;
	}

	public void setTxtAutoriza_Codigo(InputText txtAutoriza_Codigo) {
		this.txtAutoriza_Codigo = txtAutoriza_Codigo;
	}

	public InputText getTxtHora_Recogida() {
		return txtHora_Recogida;
	}

	public void setTxtHora_Recogida(InputText txtHora_Recogida) {
		this.txtHora_Recogida = txtHora_Recogida;
	}

	public InputText getTxtHora_Cita() {
		return txtHora_Cita;
	}

	public void setTxtHora_Cita(InputText txtHora_Cita) {
		this.txtHora_Cita = txtHora_Cita;
	}

	public InputTextarea getTxtObservaciones() {
		return txtObservaciones;
	}

	public void setTxtObservaciones(InputTextarea txtObservaciones) {
		this.txtObservaciones = txtObservaciones;
	}

	public InputText getTxtSolicitante() {
		return txtSolicitante;
	}

	public void setTxtSolicitante(InputText txtSolicitante) {
		this.txtSolicitante = txtSolicitante;
	}

	public InputText getTxtTraslado_Requerimiento() {
		return txtTraslado_Requerimiento;
	}

	public void setTxtTraslado_Requerimiento(InputText txtTraslado_Requerimiento) {
		this.txtTraslado_Requerimiento = txtTraslado_Requerimiento;
	}

	public InputText getTxtPerimetro_requerido() {
		return txtPerimetro_requerido;
	}

	public void setTxtPerimetro_requerido(InputText txtPerimetro_requerido) {
		this.txtPerimetro_requerido = txtPerimetro_requerido;
	}

	public InputText getTxt_Nombre_Paciente() {
		return txt_Nombre_Paciente;
	}

	public void setTxt_Nombre_Paciente(InputText txt_Nombre_Paciente) {
		this.txt_Nombre_Paciente = txt_Nombre_Paciente;
	}

	public InputText getTxtEdad_Paciente() {
		return txtEdad_Paciente;
	}

	public void setTxtEdad_Paciente(InputText txtEdad_Paciente) {
		this.txtEdad_Paciente = txtEdad_Paciente;
	}

	public InputText getTxtDiagnostico() {
		return txtDiagnostico;
	}

	public void setTxtDiagnostico(InputText txtDiagnostico) {
		this.txtDiagnostico = txtDiagnostico;
	}

	public InputText getTxtCedulaPaciente() {
		return txtCedulaPaciente;
	}

	public void setTxtCedulaPaciente(InputText txtCedulaPaciente) {
		this.txtCedulaPaciente = txtCedulaPaciente;
	}

	public InputText getTxtTeléfono_Paciente() {
		return txtTeléfono_Paciente;
	}

	public void setTxtTeléfono_Paciente(InputText txtTeléfono_Paciente) {
		this.txtTeléfono_Paciente = txtTeléfono_Paciente;
	}

	public InputText getTxtLugar_Origen() {
		return txtLugar_Origen;
	}

	public void setTxtLugar_Origen(InputText txtLugar_Origen) {
		this.txtLugar_Origen = txtLugar_Origen;
	}

	public InputText getTxtLugar_Destino() {
		return txtLugar_Destino;
	}

	public void setTxtLugar_Destino(InputText txtLugar_Destino) {
		this.txtLugar_Destino = txtLugar_Destino;
	}

	public InputText getTxtHistoriaPaciente() {
		return txtHistoriaPaciente;
	}

	public void setTxtHistoriaPaciente(InputText txtHistoriaPaciente) {
		this.txtHistoriaPaciente = txtHistoriaPaciente;
	}

	public InputText getTxtMovil_Despachada() {
		return txtMovil_Despachada;
	}

	public void setTxtMovil_Despachada(InputText txtMovil_Despachada) {
		this.txtMovil_Despachada = txtMovil_Despachada;
	}

	public InputText getTxtHora_Despacho_Origen() {
		return txtHora_Despacho_Origen;
	}

	public void setTxtHora_Despacho_Origen(InputText txtHora_Despacho_Origen) {
		this.txtHora_Despacho_Origen = txtHora_Despacho_Origen;
	}

	public InputText getTxtMedico() {
		return txtMedico;
	}

	public void setTxtMedico(InputText txtMedico) {
		this.txtMedico = txtMedico;
	}

	public InputText getTxtHora_Llegada_Sitio() {
		return txtHora_Llegada_Sitio;
	}

	public void setTxtHora_Llegada_Sitio(InputText txtHora_Llegada_Sitio) {
		this.txtHora_Llegada_Sitio = txtHora_Llegada_Sitio;
	}

	public InputText getTxtDesplazamiento() {
		return txtDesplazamiento;
	}

	public void setTxtDesplazamiento(InputText txtDesplazamiento) {
		this.txtDesplazamiento = txtDesplazamiento;
	}

	public InputText getTxtHora_Llegada_Destino() {
		return txtHora_Llegada_Destino;
	}

	public void setTxtHora_Llegada_Destino(InputText txtHora_Llegada_Destino) {
		this.txtHora_Llegada_Destino = txtHora_Llegada_Destino;
	}

	public InputText getTxtMovil_Disponible() {
		return txtMovil_Disponible;
	}

	public void setTxtMovil_Disponible(InputText txtMovil_Disponible) {
		this.txtMovil_Disponible = txtMovil_Disponible;
	}

	public CommandButton getBtnCrear() {
		return btnCrear;
	}

	public void setBtnCrear(CommandButton btnCrear) {
		this.btnCrear = btnCrear;
	}

	public CommandButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(CommandButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public CommandButton getBtnBorrar() {
		return btnBorrar;
	}

	public void setBtnBorrar(CommandButton btnBorrar) {
		this.btnBorrar = btnBorrar;
	}

	public List<Servicio> getLosServicios() throws Exception {

		try {
			if (losServicios == null) {
				losServicios = serviciosLogica.consultarServicios();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}

		return losServicios;
	}

	public void setLosServicios(List<Servicio> losServicios) {
		this.losServicios = losServicios;
	}

	public IServiciosLogica getServiciosLogica() {
		return serviciosLogica;
	}

	public void setServiciosLogica(IServiciosLogica serviciosLogica) {
		this.serviciosLogica = serviciosLogica;
	}

	public SelectOneMenu getSomColores() {
		return somColores;
	}

	public void setSomColores(SelectOneMenu somColores) {
		this.somColores = somColores;
	}

	public List<SelectItem> getLosColoresSelectItem() {		
		return losColoresSelectItem;
	}

	public void setLosColoresSelectItem(List<SelectItem> losColoresSelectItem) {
		this.losColoresSelectItem = losColoresSelectItem;
	}

}
