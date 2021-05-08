package com.littleBigBusters.backend.service.interfaces;

import java.util.List;

import com.littleBigBusters.backend.model.PartidoPolitico;

public interface IPartidoPoliticoService {

	List<PartidoPolitico> findAll();

	PartidoPolitico findById(Long id);

	PartidoPolitico create(PartidoPolitico user);

	void update(PartidoPolitico user);

	void deleteById(Long id);
}
