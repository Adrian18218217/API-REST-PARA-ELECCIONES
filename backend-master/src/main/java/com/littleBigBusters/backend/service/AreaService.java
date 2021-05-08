package com.littleBigBusters.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.littleBigBusters.backend.model.Area;
import com.littleBigBusters.backend.repository.IAreaRepository;
import com.littleBigBusters.backend.service.interfaces.IAreaService;

@Service
@Transactional
public class AreaService implements IAreaService{

	@Autowired
	public IAreaRepository _areaReposytory;
	
	@Override
	public List<Area> findAll() {
		return _areaReposytory.findAll();
	}

	@Override
	public Area findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Area create(Area user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Area user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
