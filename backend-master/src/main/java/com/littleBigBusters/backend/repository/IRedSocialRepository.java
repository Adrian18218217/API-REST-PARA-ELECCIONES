package com.littleBigBusters.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.littleBigBusters.backend.model.RedSocial;

@Repository
public interface IRedSocialRepository extends JpaRepository<RedSocial, Long> {
	
}
