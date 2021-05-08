package com.littleBigBusters.backend.service.interfaces;

import java.util.List;

import com.littleBigBusters.backend.model.Cargo;

public interface ICargoService {

	List<Cargo> findAll();

	Cargo findById(Long id);

	Cargo create(Cargo user);

	void update(Cargo user);

	void deleteById(Long id);
}
