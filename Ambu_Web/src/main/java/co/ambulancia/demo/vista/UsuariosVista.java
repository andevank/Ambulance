package co.ambulancia.demo.vista;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.primefaces.component.password.Password;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.CellEditEvent;

import co.ambulancia.demo.logica.ITiposUsuariosLogica;
import co.ambulancia.demo.logica.IUsuariosLogica;
import co.ambulancia.demo.modelo.TiposUsuarios;
import co.ambulancia.demo.modelo.Usuarios;

@ManagedBean
@ViewScoped
public class UsuariosVista {

	@ManagedProperty("#{usuariosLogica}")
	private IUsuariosLogica usuariosLogica;

	@ManagedProperty("#{tiposUsuariosLogica}")
	private ITiposUsuariosLogica tiposUsuariosLogica;

	private List<Usuarios> losUsuarios;

	private SelectOneMenu somTiposUsuarios;

	private InputText txtCedula;
	private InputText txtNombre;
	private InputText txtLogin;
	private Password txtClave;

	private CommandButton btnCrear;
	private CommandButton btnModificar;
	private CommandButton btnBorrar;

	private String sbFecha;
	private String sbHora;

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

	private List<SelectItem> losTiposUsuariosSelectItem;

	public List<SelectItem> getLosTiposUsuariosSelectItem() {
		if (losTiposUsuariosSelectItem == null) {
			losTiposUsuariosSelectItem = new ArrayList<SelectItem>();
			List<TiposUsuarios> losTiposUsuarios = tiposUsuariosLogica.consultar();
			for (TiposUsuarios tiposUsuarios : losTiposUsuarios) {
				losTiposUsuariosSelectItem.add(new SelectItem(tiposUsuarios.getTusuCodigo(),
						tiposUsuarios.getTusuCodigo() + "-" + tiposUsuarios.getTusuNombre()));
			}
		}
		return losTiposUsuariosSelectItem;
	}

	public void setLosTiposUsuariosSelectItem(List<SelectItem> losTiposUsuariosSelectItem) {
		this.losTiposUsuariosSelectItem = losTiposUsuariosSelectItem;
	}

	public String crearAction() {
		try {
			Long usuCedula = Long.parseLong(txtCedula.getValue().toString());
			Usuarios usuarios = new Usuarios();
			usuarios.setUsuCedula(usuCedula);
			usuarios.setUsuNombre(txtNombre.getValue().toString());
			usuarios.setUsuLogin(txtLogin.getValue().toString());
			usuarios.setUsuClave(txtClave.getValue().toString());

			Long tusuCodigo = Long.parseLong(somTiposUsuarios.getValue().toString());
			TiposUsuarios tiposUsuarios = tiposUsuariosLogica.consultarPorId(tusuCodigo);

			usuarios.setTiposUsuarios(tiposUsuarios);

			usuariosLogica.crearUsuarios(usuarios);
			losUsuarios = null;

			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "El usuario se creo con exito", ""));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return "";
	}

	public String modificarAction() {
		try {

			Long usuCedula = Long.parseLong(txtCedula.getValue().toString());
			Usuarios usuarios = new Usuarios();
			usuarios.setUsuCedula(usuCedula);
			usuarios.setUsuNombre(txtNombre.getValue().toString());
			usuarios.setUsuLogin(txtLogin.getValue().toString());
			usuarios.setUsuClave(txtClave.getValue().toString());

			Long tusuCodigo = Long.parseLong(somTiposUsuarios.getValue().toString());
			TiposUsuarios tiposUsuarios = tiposUsuariosLogica.consultarPorId(tusuCodigo);

			usuarios.setTiposUsuarios(tiposUsuarios);

			usuariosLogica.modificarUsuarios(usuarios);
			losUsuarios = null;

			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "El usuario se modifico con exito", ""));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return "";
	}

	public String borrarAction() {
		try {
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
		}
		return "";
	}

	public String limpiarAction() {
		txtCedula.resetValue();
		losUsuarios = null;
		limpiar();
		return "";
	}

	public void txtCedulaListener() {
		Long usuCedula = 0L;
		Usuarios entity = null;
		try {
			usuCedula = Long.parseLong(txtCedula.getValue().toString());
			entity = usuariosLogica.consultarPorId(usuCedula);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));

		}

		if (entity == null) {
			limpiar();

		} else {
			btnCrear.setDisabled(true);
			btnModificar.setDisabled(false);
			btnBorrar.setDisabled(false);

			txtNombre.setValue(entity.getUsuNombre());
			txtLogin.setValue(entity.getUsuLogin());
			txtClave.setValue(entity.getUsuClave());
			somTiposUsuarios.setValue(entity.getTiposUsuarios().getTusuCodigo());

		}

	}

	private void limpiar() {
		btnCrear.setDisabled(false);
		btnModificar.setDisabled(true);
		btnBorrar.setDisabled(true);
		txtLogin.resetValue();
		txtClave.resetValue();
		txtNombre.resetValue();
		somTiposUsuarios.resetValue();
	}

	public SelectOneMenu getSomTiposUsuarios() {
		return somTiposUsuarios;
	}

	public void setSomTiposUsuarios(SelectOneMenu somTiposUsuarios) {
		this.somTiposUsuarios = somTiposUsuarios;
	}

	public IUsuariosLogica getUsuariosLogica() {
		return usuariosLogica;
	}

	public void setUsuariosLogica(IUsuariosLogica usuariosLogica) {
		this.usuariosLogica = usuariosLogica;
	}

	public ITiposUsuariosLogica getTiposUsuariosLogica() {
		return tiposUsuariosLogica;
	}

	public void setTiposUsuariosLogica(ITiposUsuariosLogica tiposUsuariosLogica) {
		this.tiposUsuariosLogica = tiposUsuariosLogica;
	}

	public List<Usuarios> getLosUsuarios() throws Exception {

		try {
			if (losUsuarios == null) {
				losUsuarios = usuariosLogica.consultarUsuarios();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}

		return losUsuarios;
	}

	public void setLosUsuarios(List<Usuarios> losUsuarios) {
		this.losUsuarios = losUsuarios;
	}

	public InputText getTxtCedula() {
		return txtCedula;
	}

	public void setTxtCedula(InputText txtCedula) {
		this.txtCedula = txtCedula;
	}

	public InputText getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(InputText txtNombre) {
		this.txtNombre = txtNombre;
	}

	public InputText getTxtLogin() {
		return txtLogin;
	}

	public void setTxtLogin(InputText txtLogin) {
		this.txtLogin = txtLogin;
	}

	public Password getTxtClave() {
		return txtClave;
	}

	public void setTxtClave(Password txtClave) {
		this.txtClave = txtClave;
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

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed",
					"Old: " + oldValue + ", New:" + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public String regresar() {
		return "/login.xhtml";
	}

}
