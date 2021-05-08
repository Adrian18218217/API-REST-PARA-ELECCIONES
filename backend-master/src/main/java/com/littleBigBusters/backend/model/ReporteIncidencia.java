package com.littleBigBusters.backend.model;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="REPORTE_INCIDENCIA")
public class ReporteIncidencia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_reporte_inicidencia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String longitud;
	
	private String latitud;
	
	private String denuncia;
	
	private LocalTime fecha;
	@Column(columnDefinition = "BLOB")
	private byte[] imagen;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private PartidoPolitico partidoPolitico;
}

