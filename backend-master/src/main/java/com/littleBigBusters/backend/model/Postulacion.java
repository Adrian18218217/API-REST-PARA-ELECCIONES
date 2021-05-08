/**
 * 
 */
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "POSTULACION")
public class Postulacion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_postulacion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "año")
	private int año;
	@Column(name = "cargo")
	private String cargo;
	
	
	@ManyToOne(optional = true, cascade = CascadeType.MERGE,fetch = FetchType.EAGER )
	@JoinColumn(name = "fk_id_candidato")
	@JsonIgnoreProperties({"name","edad","dni"})
	private Candidato candidato;
	@ManyToOne(optional = true, cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_id_propuesta")
	private Propuesta propuesta;
	@ManyToOne(optional = true, cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_id_partido_politico")
	private PartidoPolitico partidoPolitico;
		
	
}
