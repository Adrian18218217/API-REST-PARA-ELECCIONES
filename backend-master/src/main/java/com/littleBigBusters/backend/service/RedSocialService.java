package com.littleBigBusters.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littleBigBusters.backend.model.RedSocial;
import com.littleBigBusters.backend.repository.IRedSocialRepository;
import com.littleBigBusters.backend.service.interfaces.IRedSocialService;

@Service
@Transactional
public class RedSocialService implements IRedSocialService {

	@Autowired
	public IRedSocialRepository _ingresoRepository;

	public List<RedSocial> findAll() {
		return _ingresoRepository.findAll();
	}

	public RedSocial findById(Long id) {
		try {
			return _ingresoRepository.findById(id).get();
		} catch (Exception e) {
			System.out.print(e);
			return null;
		}
	}

	public RedSocial create(RedSocial user) {
		return _ingresoRepository.save(user);
	}

	public void update(RedSocial user) {
		_ingresoRepository.save(user);
	}

	public void deleteById(Long id) {
		RedSocial user = findById(id);
		_ingresoRepository.delete(user);
	}

}
