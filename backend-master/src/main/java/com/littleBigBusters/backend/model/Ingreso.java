package com.littleBigBusters.backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "DENUNCIA")
public class Ingreso implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_postulacion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "tipo")
	private String tipo;
	@Column(name = "cantidad")
	private String cantidad;

}
