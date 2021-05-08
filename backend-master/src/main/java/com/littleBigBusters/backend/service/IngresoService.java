package com.littleBigBusters.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littleBigBusters.backend.model.Ingreso;
import com.littleBigBusters.backend.repository.IIngresoRepository;
import com.littleBigBusters.backend.service.interfaces.IIngresoService;

@Service
@Transactional
public class IngresoService implements IIngresoService {

	@Autowired
	public IIngresoRepository _ingresoRepository;

	public List<Ingreso> findAll() {
		return _ingresoRepository.findAll();
	}

	public Ingreso findById(Long id) {
		try {
			return _ingresoRepository.findById(id).get();
		} catch (Exception e) {
			System.out.print(e);
			return null;
		}
	}

	public Ingreso create(Ingreso user) {
		return _ingresoRepository.save(user);
	}

	public void update(Ingreso user) {
		_ingresoRepository.save(user);
	}

	public void deleteById(Long id) {
		Ingreso user = findById(id);
		_ingresoRepository.delete(user);
	}

}
