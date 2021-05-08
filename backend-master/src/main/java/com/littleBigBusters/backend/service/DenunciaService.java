package com.littleBigBusters.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littleBigBusters.backend.model.Denuncia;
import com.littleBigBusters.backend.repository.IDenunciaRepository;
import com.littleBigBusters.backend.service.interfaces.IDenunciaService;

@Service
@Transactional
public class DenunciaService implements IDenunciaService {

	@Autowired
	public IDenunciaRepository _denunciaRepository;

	public List<Denuncia> findAll() {
		return _denunciaRepository.findAll();
	}

	public Denuncia findById(Long id) {
		try {
			return _denunciaRepository.findById(id).get();
		} catch (Exception e) {
			System.out.print(e);
			return null;
		}
	}

	public Denuncia create(Denuncia user) {
		return _denunciaRepository.save(user);
	}

	public void update(Denuncia user) {
		_denunciaRepository.save(user);
	}

	public void deleteById(Long id) {
		Denuncia user = findById(id);
		_denunciaRepository.delete(user);
	}

}
