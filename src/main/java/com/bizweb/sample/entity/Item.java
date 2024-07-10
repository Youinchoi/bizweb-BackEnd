package com.bizweb.sample.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
// 데이터베이스 테이블과 매핑되는 엔티티 클래스
public class Item {
	@Id	// 기본키
    @GeneratedValue(strategy =  GenerationType.IDENTITY)	// mysql의 auto_increment 기능
	private Long id;
	
	@Column(length = 20, nullable = false)	// 10글자 제한, not null
	private String uid;
	
	@Column(length = 50, nullable = false)	// 50글자 제한, not null
	private String name;
	
}
