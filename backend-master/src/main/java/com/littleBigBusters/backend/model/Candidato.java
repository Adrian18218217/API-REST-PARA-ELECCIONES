package com.littleBigBusters.backend.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "CANDIDATO")
public class Candidato implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_candidato")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "dni")
	private String dni;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "edad")
	private String edad;
	@Column(name = "sexo")
	private String sexo;
	@Column(name = "licencia")
	private String licencia;
	@Column(name = "nivel_socio_economico")
	private String nivelSocioEconomico;
	@Column(name = "generacion")
	private String generacion;
	@Column(name = "deuda_sunat")
	private String deudaSunat;
	@Column(name = "observacion")
	private String observacion;
	@Column(name = "imagen_url")
	private String imagenUrl;
	
	@OneToMany(mappedBy = "candidato", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Cargo> cargos;
	@OneToMany(mappedBy = "candidato", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Postulacion> Postulaciones;
	@OneToMany(mappedBy = "candidato", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<CandidatoRedSocial> candidatosRedesSociales;
	@OneToMany(mappedBy = "candidato", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Denuncia> denuncias;
	@OneToMany(mappedBy = "candidato", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Educacion> educaciones;
}
