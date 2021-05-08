package com.littleBigBusters.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littleBigBusters.backend.model.LoginUser;
import com.littleBigBusters.backend.repository.ILoginUserRepository;
import com.littleBigBusters.backend.service.interfaces.ILoginUserService;

@Service
@Transactional
public class LoginUserService implements ILoginUserService {

	@Autowired
	public ILoginUserRepository _loginUserRepository;

	public List<LoginUser> findAll() {
		return _loginUserRepository.findAll();
	}

	public LoginUser findById(Long id) {
		try {
			return _loginUserRepository.findById(id).get();
		} catch (Exception e) {
			System.out.print(e);
			return null;
		}
	}

	public LoginUser create(LoginUser user) {
		return _loginUserRepository.save(user);
	}

	public void update(LoginUser user) {
		_loginUserRepository.save(user);
	}

	public void deleteById(Long id) {
		LoginUser user = findById(id);
		_loginUserRepository.delete(user);
	}
}
