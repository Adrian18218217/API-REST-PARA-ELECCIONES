package com.littleBigBusters.backend.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PARTIDO_POLITICO")
public class PartidoPolitico implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_partido_politico")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "pagina_web")
	private String paginaWeb;
	@Column(name = "facebook")
	private String facebook;
	@Column(name = "twiter")
	private String twiter;
	
	@OneToMany(mappedBy = "partidoPolitico", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Postulacion> postulaciones;
	
	@OneToMany(mappedBy = "partidoPolitico", cascade = CascadeType.ALL)
	private Set<ReporteIncidencia> reporteIncidencias;
	
	

}
