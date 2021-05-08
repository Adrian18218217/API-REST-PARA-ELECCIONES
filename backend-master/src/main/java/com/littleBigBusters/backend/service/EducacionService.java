package com.littleBigBusters.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littleBigBusters.backend.model.Educacion;
import com.littleBigBusters.backend.repository.IEducacionRepository;
import com.littleBigBusters.backend.service.interfaces.IEducacionService;

@Service
@Transactional
public class EducacionService implements IEducacionService {

	@Autowired
	public IEducacionRepository _educacionRepository;

	public List<Educacion> findAll() {
		return _educacionRepository.findAll();
	}

	public Educacion findById(Long id) {
		try {
			return _educacionRepository.findById(id).get();
		} catch (Exception e) {
			System.out.print(e);
			return null;
		}
	}

	public Educacion create(Educacion user) {
		return _educacionRepository.save(user);
	}

	public void update(Educacion user) {
		_educacionRepository.save(user);
	}

	public void deleteById(Long id) {
		Educacion user = findById(id);
		_educacionRepository.delete(user);
	}

}
