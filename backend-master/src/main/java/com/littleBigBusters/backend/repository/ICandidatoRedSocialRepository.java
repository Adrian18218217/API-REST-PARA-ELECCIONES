package com.littleBigBusters.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.littleBigBusters.backend.model.CandidatoRedSocial;

@Repository
public interface ICandidatoRedSocialRepository extends JpaRepository<CandidatoRedSocial, Long> {

}
