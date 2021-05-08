package com.littleBigBusters.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littleBigBusters.backend.model.CandidatoRedSocial;
import com.littleBigBusters.backend.repository.ICandidatoRedSocialRepository;
import com.littleBigBusters.backend.service.interfaces.ICandidatoRedSocialService;

@Service
@Transactional
public class CandidatoRedSocialService implements ICandidatoRedSocialService {

	@Autowired
	public ICandidatoRedSocialRepository _candidatoRedSocialRepository;

	public List<CandidatoRedSocial> findAll() {
		return _candidatoRedSocialRepository.findAll();
	}

	public CandidatoRedSocial findById(Long id) {
		try {
			return _candidatoRedSocialRepository.findById(id).get();
		} catch (Exception e) {
			System.out.print(e);
			return null;
		}
	}

	public CandidatoRedSocial create(CandidatoRedSocial user) {
		return _candidatoRedSocialRepository.save(user);
	}

	public void update(CandidatoRedSocial user) {
		_candidatoRedSocialRepository.save(user);
	}

	public void deleteById(Long id) {
		CandidatoRedSocial user = findById(id);
		_candidatoRedSocialRepository.delete(user);
	}

}
