package co.ambulancia.demo.modelo;
// Generated 30/06/2017 08:43:08 PM by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Servicio generated by hbm2java
 */
@Entity
@Table(name = "servicio", schema = "public")
public class Servicio implements java.io.Serializable {

	private int codigoServicio;
	private String fechaServicio;
	private String horaServicio;
	private String operador;
	private String entidad;
	private String autorizaCodigo;
	private String horaRecogida;
	private String horaCita;
	private String observaciones;
	private String solicitante;
	private String trasladoRequerimiento;
	private String perimetroRequerido;
	private String nombrePaciente;
	private String edadPaciente;
	private String diagnostico;
	private String cedulaPaciente;
	private String telefonoPaciente;
	private String lugarOrigen;
	private String lugarDestino;
	private String historiaPaciente;
	private String movilDespachada;
	private String horaDespachoOrigen;
	private String medicoPaciente;
	private String horaLlegadaSitio;
	private String desplazamiento;
	private String horaLlegadaDestino;
	private String movilDisponible;
	private String estado;

	public Servicio() {
	}

	public Servicio(int codigoServicio, String autorizaCodigo, String horaRecogida, String trasladoRequerimiento,
			String perimetroRequerido, String nombrePaciente, String edadPaciente, String diagnostico,
			String cedulaPaciente, String lugarOrigen, String lugarDestino) {
		this.codigoServicio = codigoServicio;
		this.autorizaCodigo = autorizaCodigo;
		this.horaRecogida = horaRecogida;
		this.trasladoRequerimiento = trasladoRequerimiento;
		this.perimetroRequerido = perimetroRequerido;
		this.nombrePaciente = nombrePaciente;
		this.edadPaciente = edadPaciente;
		this.diagnostico = diagnostico;
		this.cedulaPaciente = cedulaPaciente;
		this.lugarOrigen = lugarOrigen;
		this.lugarDestino = lugarDestino;
	}

	public Servicio(int codigoServicio, String fechaServicio, String horaServicio, String operador, String entidad,
			String autorizaCodigo, String horaRecogida, String horaCita, String observaciones, String solicitante,
			String trasladoRequerimiento, String perimetroRequerido, String nombrePaciente, String edadPaciente,
			String diagnostico, String cedulaPaciente, String telefonoPaciente, String lugarOrigen, String lugarDestino,
			String historiaPaciente, String movilDespachada, String horaDespachoOrigen, String medicoPaciente,
			String horaLlegadaSitio, String desplazamiento, String horaLlegadaDestino, String movilDisponible,
			String estado) {
		this.codigoServicio = codigoServicio;
		this.fechaServicio = fechaServicio;
		this.horaServicio = horaServicio;
		this.operador = operador;
		this.entidad = entidad;
		this.autorizaCodigo = autorizaCodigo;
		this.horaRecogida = horaRecogida;
		this.horaCita = horaCita;
		this.observaciones = observaciones;
		this.solicitante = solicitante;
		this.trasladoRequerimiento = trasladoRequerimiento;
		this.perimetroRequerido = perimetroRequerido;
		this.nombrePaciente = nombrePaciente;
		this.edadPaciente = edadPaciente;
		this.diagnostico = diagnostico;
		this.cedulaPaciente = cedulaPaciente;
		this.telefonoPaciente = telefonoPaciente;
		this.lugarOrigen = lugarOrigen;
		this.lugarDestino = lugarDestino;
		this.historiaPaciente = historiaPaciente;
		this.movilDespachada = movilDespachada;
		this.horaDespachoOrigen = horaDespachoOrigen;
		this.medicoPaciente = medicoPaciente;
		this.horaLlegadaSitio = horaLlegadaSitio;
		this.desplazamiento = desplazamiento;
		this.horaLlegadaDestino = horaLlegadaDestino;
		this.movilDisponible = movilDisponible;
		this.estado = estado;
	}

	@Id

	@Column(name = "codigo_servicio", unique = true, nullable = false)
	public int getCodigoServicio() {
		return this.codigoServicio;
	}

	public void setCodigoServicio(int codigoServicio) {
		this.codigoServicio = codigoServicio;
	}

	@Column(name = "fecha_servicio", length = 20)
	public String getFechaServicio() {
		return this.fechaServicio;
	}

	public void setFechaServicio(String fechaServicio) {
		this.fechaServicio = fechaServicio;
	}

	@Column(name = "hora_servicio", length = 20)
	public String getHoraServicio() {
		return this.horaServicio;
	}

	public void setHoraServicio(String horaServicio) {
		this.horaServicio = horaServicio;
	}

	@Column(name = "operador", length = 50)
	public String getOperador() {
		return this.operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	@Column(name = "entidad", length = 50)
	public String getEntidad() {
		return this.entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	@Column(name = "autoriza_codigo", nullable = false, length = 50)
	public String getAutorizaCodigo() {
		return this.autorizaCodigo;
	}

	public void setAutorizaCodigo(String autorizaCodigo) {
		this.autorizaCodigo = autorizaCodigo;
	}

	@Column(name = "hora_recogida", nullable = false, length = 50)
	public String getHoraRecogida() {
		return this.horaRecogida;
	}

	public void setHoraRecogida(String horaRecogida) {
		this.horaRecogida = horaRecogida;
	}

	@Column(name = "hora_cita", length = 50)
	public String getHoraCita() {
		return this.horaCita;
	}

	public void setHoraCita(String horaCita) {
		this.horaCita = horaCita;
	}

	@Column(name = "observaciones", length = 50)
	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Column(name = "solicitante", length = 50)
	public String getSolicitante() {
		return this.solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	@Column(name = "traslado_requerimiento", nullable = false, length = 50)
	public String getTrasladoRequerimiento() {
		return this.trasladoRequerimiento;
	}

	public void setTrasladoRequerimiento(String trasladoRequerimiento) {
		this.trasladoRequerimiento = trasladoRequerimiento;
	}

	@Column(name = "perimetro_requerido", nullable = false, length = 50)
	public String getPerimetroRequerido() {
		return this.perimetroRequerido;
	}

	public void setPerimetroRequerido(String perimetroRequerido) {
		this.perimetroRequerido = perimetroRequerido;
	}

	@Column(name = "nombre_paciente", nullable = false, length = 50)
	public String getNombrePaciente() {
		return this.nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	@Column(name = "edad_paciente", nullable = false, length = 50)
	public String getEdadPaciente() {
		return this.edadPaciente;
	}

	public void setEdadPaciente(String edadPaciente) {
		this.edadPaciente = edadPaciente;
	}

	@Column(name = "diagnostico", nullable = false, length = 150)
	public String getDiagnostico() {
		return this.diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	@Column(name = "cedula_paciente", nullable = false, length = 50)
	public String getCedulaPaciente() {
		return this.cedulaPaciente;
	}

	public void setCedulaPaciente(String cedulaPaciente) {
		this.cedulaPaciente = cedulaPaciente;
	}

	@Column(name = "telefono_paciente", length = 50)
	public String getTelefonoPaciente() {
		return this.telefonoPaciente;
	}

	public void setTelefonoPaciente(String telefonoPaciente) {
		this.telefonoPaciente = telefonoPaciente;
	}

	@Column(name = "lugar_origen", nullable = false, length = 50)
	public String getLugarOrigen() {
		return this.lugarOrigen;
	}

	public void setLugarOrigen(String lugarOrigen) {
		this.lugarOrigen = lugarOrigen;
	}

	@Column(name = "lugar_destino", nullable = false, length = 50)
	public String getLugarDestino() {
		return this.lugarDestino;
	}

	public void setLugarDestino(String lugarDestino) {
		this.lugarDestino = lugarDestino;
	}

	@Column(name = "historia_paciente", length = 50)
	public String getHistoriaPaciente() {
		return this.historiaPaciente;
	}

	public void setHistoriaPaciente(String historiaPaciente) {
		this.historiaPaciente = historiaPaciente;
	}

	@Column(name = "movil_despachada", length = 50)
	public String getMovilDespachada() {
		return this.movilDespachada;
	}

	public void setMovilDespachada(String movilDespachada) {
		this.movilDespachada = movilDespachada;
	}

	@Column(name = "hora_despacho_origen", length = 50)
	public String getHoraDespachoOrigen() {
		return this.horaDespachoOrigen;
	}

	public void setHoraDespachoOrigen(String horaDespachoOrigen) {
		this.horaDespachoOrigen = horaDespachoOrigen;
	}

	@Column(name = "medico_paciente", length = 50)
	public String getMedicoPaciente() {
		return this.medicoPaciente;
	}

	public void setMedicoPaciente(String medicoPaciente) {
		this.medicoPaciente = medicoPaciente;
	}

	@Column(name = "hora_llegada_sitio", length = 50)
	public String getHoraLlegadaSitio() {
		return this.horaLlegadaSitio;
	}

	public void setHoraLlegadaSitio(String horaLlegadaSitio) {
		this.horaLlegadaSitio = horaLlegadaSitio;
	}

	@Column(name = "desplazamiento", length = 50)
	public String getDesplazamiento() {
		return this.desplazamiento;
	}

	public void setDesplazamiento(String desplazamiento) {
		this.desplazamiento = desplazamiento;
	}

	@Column(name = "hora_llegada_destino", length = 50)
	public String getHoraLlegadaDestino() {
		return this.horaLlegadaDestino;
	}

	public void setHoraLlegadaDestino(String horaLlegadaDestino) {
		this.horaLlegadaDestino = horaLlegadaDestino;
	}

	@Column(name = "movil_disponible", length = 50)
	public String getMovilDisponible() {
		return this.movilDisponible;
	}

	public void setMovilDisponible(String movilDisponible) {
		this.movilDisponible = movilDisponible;
	}

	@Column(name = "estado", length = 50)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
