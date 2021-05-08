/**
 * 
 */
package com.littleBigBusters.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.littleBigBusters.backend.model.Area;
import com.littleBigBusters.backend.service.interfaces.IAreaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1/area")
@Api(tags = "area")
public class AreaController {

	@Autowired
	IAreaService _areaService;
	
	@GetMapping("")
	@ApiOperation(value = "Listar Reservas", notes = "Servicio para listar todas las reservas")
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Reservas encontrados"),
			@ApiResponse(code = 404, message = "Reservas no encontrados") 
			})
	public ResponseEntity<?> getUsers() {
		
		List<Area> users = _areaService.findAll();
		
		return ResponseEntity.ok(users);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Listar Reservas", notes = "Servicio para listar todas las reservas")
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Reservas encontrados"),
			@ApiResponse(code = 404, message = "Reservas no encontrados") 
			})
	public ResponseEntity<?> getUser(@PathVariable("id") Long id) {

		Area user = _areaService.findById(id);

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
	public ResponseEntity<?> createUser(@RequestBody Area user) {
		
		Area newUser = _areaService.create(user);
				
		return ResponseEntity.ok(newUser);
	}

	@PatchMapping(value = "/{id}", headers = "Accept=application/json")
	@ApiOperation(value = "Listar Reservas", notes = "Servicio para listar todas las reservas")
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Reservas encontrados"),
			@ApiResponse(code = 404, message = "Reservas no encontrados") 
			})
	public ResponseEntity<Area> updateUser(@PathVariable("id") Long id, @RequestBody Area user) {

		Area newUser = _areaService.findById(id);
				
		if(newUser == null)
			return ResponseEntity.notFound().build();
				
		_areaService.update(newUser);

		return ResponseEntity.ok(_areaService.findById(id));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Listar Reservas", notes = "Servicio para listar todas las reservas")
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Reservas encontrados"),
			@ApiResponse(code = 404, message = "Reservas no encontrados") 
			})
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {

		Area delUser = _areaService.findById(id);
		
		if(delUser == null)
			return ResponseEntity.notFound().build();

		_areaService.deleteById(id);
		
		return ResponseEntity.ok(delUser);
	}
}
