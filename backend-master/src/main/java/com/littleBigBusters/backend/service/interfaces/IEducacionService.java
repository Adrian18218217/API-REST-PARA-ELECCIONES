package com.littleBigBusters.backend.service.interfaces;

import java.util.List;

import com.littleBigBusters.backend.model.Educacion;

public interface IEducacionService {

	List<Educacion> findAll();

	Educacion findById(Long id);

	Educacion create(Educacion user);

	void update(Educacion user);

	void deleteById(Long id);
}
