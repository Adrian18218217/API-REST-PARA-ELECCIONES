package com.littleBigBusters.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littleBigBusters.backend.model.Postulacion;
import com.littleBigBusters.backend.repository.IPostulacionRepository;
import com.littleBigBusters.backend.service.interfaces.IPostulacionService;

@Service
@Transactional
public class PostulacionService implements IPostulacionService {

	@Autowired
	public IPostulacionRepository _postulacionRepository;

	public List<Postulacion> findAll() {
		return _postulacionRepository.findAll();
	}

	public Postulacion findById(Long id) {
		try {
			return _postulacionRepository.findById(id).get();
		} catch (Exception e) {
			System.out.print(e);
			return null;
		}
	}

	public Postulacion create(Postulacion user) {
		return _postulacionRepository.save(user);
	}

	public void update(Postulacion user) {
		_postulacionRepository.save(user);
	}

	public void deleteById(Long id) {
		Postulacion user = findById(id);
		_postulacionRepository.delete(user);
	}

}
