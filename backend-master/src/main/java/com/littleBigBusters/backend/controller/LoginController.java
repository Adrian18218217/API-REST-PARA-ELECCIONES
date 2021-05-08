package com.littleBigBusters.backend.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.littleBigBusters.backend.model.LoginUser;
import com.littleBigBusters.backend.modelVO.TokenAuthentication;
import com.littleBigBusters.backend.util.JwtUtil;

@RestController
@RequestMapping("/")
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	@Qualifier("myUserDetailService")
	private UserDetailsService _myUserDetailService;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@PostMapping(value = "/login")
	public ResponseEntity<?> createToken(@RequestBody LoginUser user) throws Exception {

		try {

			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getDni(), user.getPassword()));

		} catch (BadCredentialsException e) {
			throw new Exception("usuario o contraseña incorrectas", e);
		}

		UserDetails userDetails = _myUserDetailService.loadUserByUsername(user.getDni());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity
				.ok(new TokenAuthentication(jwt, userDetails.getUsername(), (Set<?>) userDetails.getAuthorities()));

	}

	@GetMapping(value = { "/login", "/" })
	@ResponseBody
	public ModelAndView login() throws Exception {

		ModelAndView mav = new ModelAndView();
		String errorMessage = "Usuario no autorizado, debe autentificarse";
		mav.addObject("errorMsg", errorMessage);
		mav.setViewName("login");

		return mav;
	}

	@GetMapping(value = "/home")
	@ResponseBody
	public ModelAndView home() throws Exception {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");

		return mav;
	}
}
