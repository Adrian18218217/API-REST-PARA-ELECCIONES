package com.littleBigBusters.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littleBigBusters.backend.model.PartidoPolitico;
import com.littleBigBusters.backend.repository.IPartidoPoliticoRepository;
import com.littleBigBusters.backend.service.interfaces.IPartidoPoliticoService;

@Service
@Transactional
public class PartidoPoliticoService implements IPartidoPoliticoService {

	@Autowired
	public IPartidoPoliticoRepository _ingresoRepository;

	public List<PartidoPolitico> findAll() {
		return _ingresoRepository.findAll();
	}

	public PartidoPolitico findById(Long id) {
		try {
			return _ingresoRepository.findById(id).get();
		} catch (Exception e) {
			System.out.print(e);
			return null;
		}
	}

	public PartidoPolitico create(PartidoPolitico user) {
		return _ingresoRepository.save(user);
	}

	public void update(PartidoPolitico user) {
		_ingresoRepository.save(user);
	}

	public void deleteById(Long id) {
		PartidoPolitico user = findById(id);
		_ingresoRepository.delete(user);
	}

}
