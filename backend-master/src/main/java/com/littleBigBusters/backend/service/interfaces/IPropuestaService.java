package com.littleBigBusters.backend.service.interfaces;

import java.util.List;

import com.littleBigBusters.backend.model.Propuesta;

public interface IPropuestaService {

	List<Propuesta> findAll();

	Propuesta findById(Long id);

	Propuesta create(Propuesta user);

	void update(Propuesta user);

	void deleteById(Long id);
}
