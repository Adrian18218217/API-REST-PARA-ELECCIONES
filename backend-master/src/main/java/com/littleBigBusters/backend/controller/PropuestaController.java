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

import com.littleBigBusters.backend.model.Propuesta;
import com.littleBigBusters.backend.model.LoginUser;
import com.littleBigBusters.backend.service.interfaces.ILoginUserService;
import com.littleBigBusters.backend.service.interfaces.IPropuestaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1/propuesta")
@Api(tags = "propuesta")
public class PropuestaController {

	@Autowired
	IPropuestaService _propuestaService;
	
	@GetMapping("")
	@ApiOperation(value = "Listar Reservas", notes = "Servicio para listar todas las reservas")
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Reservas encontrados"),
			@ApiResponse(code = 404, message = "Reservas no encontrados") 
			})
	public ResponseEntity<?> getUsers() {
		
		List<Propuesta> users = _propuestaService.findAll();
		
		return ResponseEntity.ok(users);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Listar Reservas", notes = "Servicio para listar todas las reservas")
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Reservas encontrados"),
			@ApiResponse(code = 404, message = "Reservas no encontrados") 
			})
	public ResponseEntity<?> getUser(@PathVariable("id") Long id) {

		Propuesta user = _propuestaService.findById(id);

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
	public ResponseEntity<?> createUser(@RequestBody Propuesta user) {
		
		Propuesta newUser = _propuestaService.create(user);
				
		return ResponseEntity.ok(newUser);
	}

	@PatchMapping(value = "/{id}", headers = "Accept=application/json")
	@ApiOperation(value = "Listar Reservas", notes = "Servicio para listar todas las reservas")
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Reservas encontrados"),
			@ApiResponse(code = 404, message = "Reservas no encontrados") 
			})
	public ResponseEntity<Propuesta> updateUser(@PathVariable("id") Long id, @RequestBody LoginUser user) {

		Propuesta newUser = _propuestaService.findById(id);
				
		if(newUser == null)
			return ResponseEntity.notFound().build();
				
		_propuestaService.update(newUser);

		return ResponseEntity.ok(_propuestaService.findById(id));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Listar Reservas", notes = "Servicio para listar todas las reservas")
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Reservas encontrados"),
			@ApiResponse(code = 404, message = "Reservas no encontrados") 
			})
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {

		Propuesta delUser = _propuestaService.findById(id);
		
		if(delUser == null)
			return ResponseEntity.notFound().build();

		_propuestaService.deleteById(id);
		
		return ResponseEntity.ok(delUser);
	}
}
