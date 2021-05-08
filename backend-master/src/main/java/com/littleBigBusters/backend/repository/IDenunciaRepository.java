package com.littleBigBusters.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.littleBigBusters.backend.model.Denuncia;


@Repository
public interface IDenunciaRepository extends JpaRepository<Denuncia, Long> {

}
