package com.littleBigBusters.backend.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.littleBigBusters.backend.model.LoginUser;
import com.littleBigBusters.backend.repository.ILoginUserRepository;

@Service
@Transactional
public class MyUserDetailService implements UserDetailsService{
	@Autowired
	private ILoginUserRepository _userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {
		
		System.out.println("userDetail");
		
		LoginUser user = _userRepository.findByDni(dni);
		if (user == null) {System.out.println("Esta vacio");}
		
//		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        for (Rol role : userR.getRol()){
//            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
//        }
		
		return new User(user.getDni(),user.getPassword(), new ArrayList<>());
//		return new User(userR.getEmail(),userR.getPassword(), grantedAuthorities);
//		return new User("foo","foo", new ArrayList<>());
	}
}
