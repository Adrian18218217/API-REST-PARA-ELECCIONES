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
@Table(name = "RED_SOCIAL")
public class RedSocial implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_red_social")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "redSocial", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<CandidatoRedSocial> candidatosRedesSociales;
}
