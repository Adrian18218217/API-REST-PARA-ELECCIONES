package com.littleBigBusters.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littleBigBusters.backend.model.Cargo;
import com.littleBigBusters.backend.repository.ICargoRepository;
import com.littleBigBusters.backend.service.interfaces.ICargoService;

@Service
@Transactional
public class CargoService implements ICargoService {

	@Autowired
	public ICargoRepository _cargoRepository;

	public List<Cargo> findAll() {
		return _cargoRepository.findAll();
	}

	public Cargo findById(Long id) {
		try {
			return _cargoRepository.findById(id).get();
		} catch (Exception e) {
			System.out.print(e);
			return null;
		}
	}

	public Cargo create(Cargo user) {
		return _cargoRepository.save(user);
	}

	public void update(Cargo user) {
		_cargoRepository.save(user);
	}

	public void deleteById(Long id) {
		Cargo user = findById(id);
		_cargoRepository.delete(user);
	}

}
