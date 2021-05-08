package com.littleBigBusters.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.littleBigBusters.backend.model.Propuesta;

@Repository
public interface IPropuestaRepository extends JpaRepository<Propuesta, Long> {

}
