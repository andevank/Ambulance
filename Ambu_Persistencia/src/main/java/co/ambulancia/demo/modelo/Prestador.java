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
 * Prestador generated by hbm2java
 */
@Entity
@Table(name = "prestador", schema = "public")
public class Prestador implements java.io.Serializable {

	private long presNit;
	private long presCodigo;
	private String presNombre;
	private Set<Remision> remisions = new HashSet<Remision>(0);

	public Prestador() {
	}

	public Prestador(long presNit, long presCodigo, String presNombre) {
		this.presNit = presNit;
		this.presCodigo = presCodigo;
		this.presNombre = presNombre;
	}

	public Prestador(long presNit, long presCodigo, String presNombre, Set<Remision> remisions) {
		this.presNit = presNit;
		this.presCodigo = presCodigo;
		this.presNombre = presNombre;
		this.remisions = remisions;
	}

	@Id

	@Column(name = "pres_nit", unique = true, nullable = false, precision = 10, scale = 0)
	public long getPresNit() {
		return this.presNit;
	}

	public void setPresNit(long presNit) {
		this.presNit = presNit;
	}

	@Column(name = "pres_codigo", nullable = false, precision = 10, scale = 0)
	public long getPresCodigo() {
		return this.presCodigo;
	}

	public void setPresCodigo(long presCodigo) {
		this.presCodigo = presCodigo;
	}

	@Column(name = "pres_nombre", nullable = false, length = 50)
	public String getPresNombre() {
		return this.presNombre;
	}

	public void setPresNombre(String presNombre) {
		this.presNombre = presNombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "prestador")
	public Set<Remision> getRemisions() {
		return this.remisions;
	}

	public void setRemisions(Set<Remision> remisions) {
		this.remisions = remisions;
	}

}