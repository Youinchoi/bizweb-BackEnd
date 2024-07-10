package com.bizweb.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bizweb.user.entity.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
	UserInfo findByUemail(String uemail); // 이메일로 찾기
	boolean existsByUemail(String uemail); // 이메일 중복체크
}
