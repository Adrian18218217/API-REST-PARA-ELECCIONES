package com.littleBigBusters.backend.service.interfaces;

import java.util.List;

import com.littleBigBusters.backend.model.Ingreso;

public interface IIngresoService {

	List<Ingreso> findAll();

	Ingreso findById(Long id);

	Ingreso create(Ingreso user);

	void update(Ingreso user);

	void deleteById(Long id);
}
