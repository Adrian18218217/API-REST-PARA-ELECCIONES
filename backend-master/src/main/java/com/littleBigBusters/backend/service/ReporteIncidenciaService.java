package com.littleBigBusters.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littleBigBusters.backend.model.ReporteIncidencia;
import com.littleBigBusters.backend.repository.IReporteIncidenciaRepository;
import com.littleBigBusters.backend.service.interfaces.IReporteIncidenciaService;

@Service
@Transactional
public class ReporteIncidenciaService implements IReporteIncidenciaService {

	@Autowired
	public IReporteIncidenciaRepository _reporteIncidenciaRepository;

	public List<ReporteIncidencia> findAll() {
		return _reporteIncidenciaRepository.findAll();
	}

	public ReporteIncidencia findById(Long id) {
		try {
			return _reporteIncidenciaRepository.findById(id).get();
		} catch (Exception e) {
			System.out.print(e);
			return null;
		}
	}

	public ReporteIncidencia create(ReporteIncidencia user) {
		return _reporteIncidenciaRepository.save(user);
	}

	public void update(ReporteIncidencia user) {
		_reporteIncidenciaRepository.save(user);
	}

	public void deleteById(Long id) {
		ReporteIncidencia user = findById(id);
		_reporteIncidenciaRepository.delete(user);
	}
}
