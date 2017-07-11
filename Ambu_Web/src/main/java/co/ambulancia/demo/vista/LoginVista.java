package co.ambulancia.demo.vista;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;

import co.ambulancia.demo.logica.IUsuariosLogica;
import co.ambulancia.demo.modelo.Usuarios;

@ManagedBean
@ViewScoped
public class LoginVista {

	public InputText txtLogin;
	public Password txtPassword;
	public CommandButton btnIngresar;

	@ManagedProperty("#{usuariosLogica}")
	private IUsuariosLogica usuariosLogica;

	public IUsuariosLogica getUsuariosLogica() {
		return usuariosLogica;
	}

	public void setUsuariosLogica(IUsuariosLogica usuariosLogica) {
		this.usuariosLogica = usuariosLogica;
	}

	public InputText getTxtLogin() {
		return txtLogin;
	}

	public void setTxtLogin(InputText txtLogin) {
		this.txtLogin = txtLogin;
	}

	public Password getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(Password txtPassword) {
		this.txtPassword = txtPassword;
	}

	public CommandButton getBtnIngresar() {
		return btnIngresar;
	}

	public void setBtnIngresar(CommandButton btnIngresar) {
		this.btnIngresar = btnIngresar;
	}

	public String ingresarAction() {
		System.out.println(" " + txtLogin.getValue() + " " + txtPassword.getValue());
		return "";
	}

	public void txtListener() {
		if (txtLogin.getValue().toString().equals("") == false) {
			btnIngresar.setDisabled(false);
		} else {
			btnIngresar.setDisabled(true);
		}
	}

	public String login_usuario()throws Exception {
		
			String sbLogin= txtLogin.getValue().toString();			
			Usuarios objUsu= usuariosLogica.consultarPorLogin(sbLogin);
			
			if(objUsu!=null){				
				return "/XHTML/initialMenu.xhtml";
			}
			else{
				return "/login.xhtml";
			}		
		}
	
	public String crear_usuario()throws Exception {			
			return "/usuarios/usuarios.xhtml";				
	}
}
