package com.bizweb.user.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_info")
public class UserInfo {
	
	/*
	 * 이름 / 이메일(아이디) / 전화번호 / 고유번호 (회원가입시 자동생성)
	 * 유저 타입 (일반회원, 관리자 등) 
	 * 유저 상태 (휴면이냐 등등) 
	 * 유저 가입일
	 * 비밀번호
	 */

	@Id	// 기본키
    @GeneratedValue(strategy =  GenerationType.IDENTITY)	// mysql의 auto_increment 기능
	@Column(length = 20, nullable = false)
	private Long userid; // 고유번호 (unum)
	
	@Column(length = 50, nullable = false)	
	private String uemail; // 이메일
	
	@Column(length = 50, nullable = false)	
	private String uname; // 이름
	
	@Column(length = 11, nullable = false)	
	private String utel; // 전화번호
	
	@Column(length = 3, nullable = false)	
	private String utype; // 유저 타입
	
	@Column(length = 3, nullable = false)	
	private String ustatus; // 유저 상태
	
	@DateTimeFormat(pattern = "yyyyMMddHHmmss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date udate; // 유저 가입일
	
	@Column(length = 20, nullable = false)	
	private String upassword; // 유저 비밀번호
}
