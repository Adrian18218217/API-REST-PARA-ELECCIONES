package com.littleBigBusters.backend.service.interfaces;

import java.util.List;

import com.littleBigBusters.backend.model.ReporteIncidencia;

public interface IReporteIncidenciaService {

	List<ReporteIncidencia> findAll();

	ReporteIncidencia findById(Long id);

	ReporteIncidencia create(ReporteIncidencia user);

	void update(ReporteIncidencia user);

	void deleteById(Long id);
	
	
}
