package com.littleBigBusters.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.littleBigBusters.backend.model.PartidoPolitico;

@Repository
public interface IPartidoPoliticoRepository extends JpaRepository<PartidoPolitico, Long> {

}
