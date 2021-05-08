package com.littleBigBusters.backend.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "DENUNCIA")
public class Denuncia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_postulacion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "origen")
	private String origen;
	@Column(name = "sentencia")
	private boolean sentencia;
	
	@ManyToOne(optional = true, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_id_candidato")
	private Candidato candidato;
	
}
