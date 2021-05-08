package com.littleBigBusters.backend.service.interfaces;

import java.util.List;

import com.littleBigBusters.backend.model.RedSocial;

public interface IRedSocialService {

	List<RedSocial> findAll();

	RedSocial findById(Long id);

	RedSocial create(RedSocial user);

	void update(RedSocial user);

	void deleteById(Long id);
}
