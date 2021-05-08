package com.littleBigBusters.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.littleBigBusters.backend.model.Ingreso;

@Repository
public interface IIngresoRepository extends JpaRepository<Ingreso, Long> {

}
