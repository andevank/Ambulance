package co.ambulancia.demo.modelo;
// Generated 30/06/2017 08:43:08 PM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Ambulancia generated by hbm2java
 */
@Entity
@Table(name = "ambulancia", schema = "public")
public class Ambulancia implements java.io.Serializable {

	private long ambCodigo;
	private String ambPlaca;
	private String ambNombre;
	private Set<Remision> remisions = new HashSet<Remision>(0);

	public Ambulancia() {
	}

	public Ambulancia(long ambCodigo, String ambPlaca, String ambNombre) {
		this.ambCodigo = ambCodigo;
		this.ambPlaca = ambPlaca;
		this.ambNombre = ambNombre;
	}

	public Ambulancia(long ambCodigo, String ambPlaca, String ambNombre, Set<Remision> remisions) {
		this.ambCodigo = ambCodigo;
		this.ambPlaca = ambPlaca;
		this.ambNombre = ambNombre;
		this.remisions = remisions;
	}

	@Id

	@Column(name = "amb_codigo", unique = true, nullable = false, precision = 10, scale = 0)
	public long getAmbCodigo() {
		return this.ambCodigo;
	}

	public void setAmbCodigo(long ambCodigo) {
		this.ambCodigo = ambCodigo;
	}

	@Column(name = "amb_placa", nullable = false, length = 6)
	public String getAmbPlaca() {
		return this.ambPlaca;
	}

	public void setAmbPlaca(String ambPlaca) {
		this.ambPlaca = ambPlaca;
	}

	@Column(name = "amb_nombre", nullable = false, length = 50)
	public String getAmbNombre() {
		return this.ambNombre;
	}

	public void setAmbNombre(String ambNombre) {
		this.ambNombre = ambNombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ambulancia")
	public Set<Remision> getRemisions() {
		return this.remisions;
	}

	public void setRemisions(Set<Remision> remisions) {
		this.remisions = remisions;
	}

}
