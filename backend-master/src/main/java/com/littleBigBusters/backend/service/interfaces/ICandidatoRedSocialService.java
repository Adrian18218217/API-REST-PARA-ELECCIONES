package com.littleBigBusters.backend.service.interfaces;

import java.util.List;

import com.littleBigBusters.backend.model.CandidatoRedSocial;

public interface ICandidatoRedSocialService {

	List<CandidatoRedSocial> findAll();

	CandidatoRedSocial findById(Long id);

	CandidatoRedSocial create(CandidatoRedSocial user);

	void update(CandidatoRedSocial user);

	void deleteById(Long id);
}
