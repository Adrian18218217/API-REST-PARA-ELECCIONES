package com.littleBigBusters.backend.service.interfaces;

import java.util.List;

import com.littleBigBusters.backend.model.Postulacion;

public interface IPostulacionService {

	List<Postulacion> findAll();

	Postulacion findById(Long id);

	Postulacion create(Postulacion user);

	void update(Postulacion user);

	void deleteById(Long id);
}
