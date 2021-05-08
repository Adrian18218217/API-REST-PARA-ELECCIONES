package com.littleBigBusters.backend.service.interfaces;

import java.util.List;

import com.littleBigBusters.backend.model.Denuncia;

public interface IDenunciaService {

	List<Denuncia> findAll();

	Denuncia findById(Long id);

	Denuncia create(Denuncia user);

	void update(Denuncia user);

	void deleteById(Long id);
}
