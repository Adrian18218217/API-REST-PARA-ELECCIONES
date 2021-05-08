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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PROPUESTA")
public class Propuesta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_propuesta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "descripcion")
	private String descripcion;
	
	@OneToMany(mappedBy = "propuesta", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Postulacion> postulaciones;
	
	@ManyToOne(optional = true, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_id_area")
	private Area area;

}
