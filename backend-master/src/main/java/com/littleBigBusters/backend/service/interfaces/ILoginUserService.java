package com.littleBigBusters.backend.service.interfaces;

import java.util.List;

import com.littleBigBusters.backend.model.LoginUser;

public interface ILoginUserService {

	List<LoginUser> findAll();

	LoginUser findById(Long id);

	LoginUser create(LoginUser user);

	void update(LoginUser user);

	void deleteById(Long id);
}
