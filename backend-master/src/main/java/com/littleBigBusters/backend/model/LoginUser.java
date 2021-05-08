package com.littleBigBusters.backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "USER")
public class LoginUser implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_user")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "dni")
	private String dni;
	@Column(name = "nickname")
	private String nickname;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	
}
