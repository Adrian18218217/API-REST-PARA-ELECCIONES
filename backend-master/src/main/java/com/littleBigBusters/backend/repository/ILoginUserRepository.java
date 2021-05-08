package com.littleBigBusters.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.littleBigBusters.backend.model.LoginUser;

@Repository
public interface ILoginUserRepository extends JpaRepository<LoginUser, Long> {

	public LoginUser findByNickname(String nickname);
	
	public LoginUser findByDni(String dni);
	
	public LoginUser findByEmail(String email);
	
	public LoginUser findByDniAndPassword(String dni, String password);
	
	public LoginUser findByNicknameAndPassword(String nickname, String password);
	
	public LoginUser findByEmailAndPassword(String nickname, String password);
}
