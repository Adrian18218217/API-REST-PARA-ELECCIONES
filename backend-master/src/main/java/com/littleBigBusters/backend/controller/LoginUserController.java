/**
 * 
 */
package com.littleBigBusters.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.littleBigBusters.backend.model.LoginUser;
import com.littleBigBusters.backend.service.interfaces.ILoginUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1/user")
@Api(tags = "user")
public class LoginUserController {

	@Autowired
	ILoginUserService _loginUserService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("")
	@ApiOperation(value = "Listar Reservas", notes = "Servicio para listar todas las reservas")
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Reservas encontrados"),
			@ApiResponse(code = 404, message = "Reservas no encontrados") 
			})
	public ResponseEntity<?> getUsers() {
		
		List<LoginUser> users = _loginUserService.findAll();
		
		return ResponseEntity.ok(users);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Listar Reservas", notes = "Servicio para listar todas las reservas")
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Reservas encontrados"),
			@ApiResponse(code = 404, message = "Reservas no encontrados") 
			})
	public ResponseEntity<?> getUser(@PathVariable("id") Long id) {

		LoginUser user = _loginUserService.findById(id);

		if(user == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(user);
	}

	@PostMapping(value = "", headers = "Accept=application/json")
	@ApiOperation(value = "Listar Reservas", notes = "Servicio para listar todas las reservas")
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Reservas encontrados"),
			@ApiResponse(code = 404, message = "Reservas no encontrados") 
			})
	public ResponseEntity<?> createUser(@RequestBody LoginUser user) {

		user.setPassword(encoder.encode(user.getPassword()));
		
		LoginUser newUser = _loginUserService.create(user);
				
		return ResponseEntity.ok(newUser);
	}

	@PatchMapping(value = "/{id}", headers = "Accept=application/json")
	@ApiOperation(value = "Listar Reservas", notes = "Servicio para listar todas las reservas")
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Reservas encontrados"),
			@ApiResponse(code = 404, message = "Reservas no encontrados") 
			})
	public ResponseEntity<LoginUser> updateUser(@PathVariable("id") Long id, @RequestBody LoginUser user) {

		LoginUser newUser = _loginUserService.findById(id);
				
		if(newUser == null)
			return ResponseEntity.notFound().build();
		
		//validations
		if(user.getNickname() != null && !user.getNickname().equals("")) 
			newUser.setEmail(user.getNickname()); ;
		
		if(user.getEmail() != null && !user.getEmail().equals("")) 
			newUser.setEmail(user.getEmail());
		
		if(user.getPassword() != null && !user.getPassword().equals(""))
			newUser.setPassword(encoder.encode(user.getPassword()));
		
		_loginUserService.update(newUser);

		return ResponseEntity.ok(_loginUserService.findById(id));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Listar Reservas", notes = "Servicio para listar todas las reservas")
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Reservas encontrados"),
			@ApiResponse(code = 404, message = "Reservas no encontrados") 
			})
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {

		LoginUser delUser = _loginUserService.findById(id);
		
		if(delUser == null)
			return ResponseEntity.notFound().build();

		_loginUserService.deleteById(id);
		
		return ResponseEntity.ok(delUser);
	}
}
