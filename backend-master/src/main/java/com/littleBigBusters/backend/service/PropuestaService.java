package com.littleBigBusters.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littleBigBusters.backend.model.Propuesta;
import com.littleBigBusters.backend.repository.IPropuestaRepository;
import com.littleBigBusters.backend.service.interfaces.IPropuestaService;

@Service
@Transactional
public class PropuestaService implements IPropuestaService {

	@Autowired
	public IPropuestaRepository _propuestaRepository;

	public List<Propuesta> findAll() {
		return _propuestaRepository.findAll();
	}

	public Propuesta findById(Long id) {
		try {
			return _propuestaRepository.findById(id).get();
		} catch (Exception e) {
			System.out.print(e);
			return null;
		}
	}

	public Propuesta create(Propuesta user) {
		return _propuestaRepository.save(user);
	}

	public void update(Propuesta user) {
		_propuestaRepository.save(user);
	}

	public void deleteById(Long id) {
		Propuesta user = findById(id);
		_propuestaRepository.delete(user);
	}

}
