package com.littleBigBusters.backend.service.interfaces;

import java.util.List;

import com.littleBigBusters.backend.model.Area;

public interface IPostulacion {

	List<Area> findAll();

	Area findById(Long id);

	Area create(Area user);

	void update(Area user);

	void deleteById(Long id);
}
