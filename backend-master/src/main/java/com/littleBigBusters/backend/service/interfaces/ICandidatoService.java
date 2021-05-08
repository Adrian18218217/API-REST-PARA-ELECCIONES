package com.littleBigBusters.backend.service.interfaces;

import java.util.List;

import com.littleBigBusters.backend.model.Candidato;

public interface ICandidatoService {

	List<Candidato> findAll();

	Candidato findById(Long id);

	Candidato create(Candidato user);
	
	void createAll(List<Candidato> user);

	void update(Candidato user);

	void deleteById(Long id);
	
	
}
