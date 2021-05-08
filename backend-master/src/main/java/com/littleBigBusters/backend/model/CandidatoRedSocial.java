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

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CANDIDATO_RED_SOCIAL")
public class CandidatoRedSocial implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_candidato_red_social")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "url")
	private String url;
	
	@ManyToOne(optional = true, cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_id_candidato")
	@JsonIgnore
	private Candidato candidato;
	@ManyToOne(optional = true, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_id_red_social")
	private RedSocial redSocial;
	

}
