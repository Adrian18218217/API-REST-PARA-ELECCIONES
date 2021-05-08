package com.littleBigBusters.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littleBigBusters.backend.model.Candidato;
import com.littleBigBusters.backend.repository.ICandidatoRepository;
import com.littleBigBusters.backend.service.interfaces.ICandidatoService;

@Service
@Transactional
public class CandidatoService implements ICandidatoService {

	@Autowired
	public ICandidatoRepository _candidatoRepository;

	@Override
	public List<Candidato> findAll() {
		return _candidatoRepository.findAll();
	}

	@Override
	public Candidato findById(Long id) {
		try {
			return _candidatoRepository.findById(id).get();
		} catch (Exception e) {
			System.out.print(e);
			return null;
		}
	}

	@Override
	public Candidato create(Candidato user) {
		return _candidatoRepository.save(user);
	}
	
	@Override
	public void createAll(List<Candidato> user) {
		_candidatoRepository.saveAll(user);
		
	}

	@Override
	public void update(Candidato user) {
		_candidatoRepository.save(user);
	}

	@Override
	public void deleteById(Long id) {
		Candidato user = findById(id);
		_candidatoRepository.delete(user);
	}

	

}
