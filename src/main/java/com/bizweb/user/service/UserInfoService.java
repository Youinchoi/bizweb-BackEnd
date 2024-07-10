package com.bizweb.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bizweb.sample.config.UserConfig;
import com.bizweb.user.entity.UserInfo;
import com.bizweb.user.repository.UserInfoRepository;

@Service
public class UserInfoService {

	// [일반회원용] ----------------------+
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	@Autowired
	private UserConfig userConfig;

	// 유저관련 응답코드
	public UserConfig getUserConfig() {
		return userConfig;
	}
	
	// 회원가입
	public String registerUser(UserInfo userInfo) {
		try {
			userInfoRepository.save(userInfo);
			return userConfig.getRegisterSuccess();
		} catch (Exception e) {
			return userConfig.getRegisterFailure();
		}
	}
	
	// 이메일 중복 확인
	public boolean isEmailDuplicate(String uemail) {
		return userInfoRepository.existsByUemail(uemail);
	}

	// 로그인
	public String loginUser(String uemail, String upassword) {
		UserInfo userInfo = userInfoRepository.findByUemail(uemail);
		if (userInfo != null && userInfo.getUpassword().equals(upassword)) {
			return userConfig.getLoginSuccess();
		} else {
			return userConfig.getLoginFailure();
		}
	}
	
	// 비밀번호 찾기
	
	// 비밀번호 변경

	// 마이페이지 - 정보 수정
	public String modifyUser(String uemail, UserInfo updatedUserInfo) {
		try {
			UserInfo userInfo = userInfoRepository.findByUemail(uemail);
			if (userInfo == null) {
				throw new Exception("해당 유저를 찾을 수 없음 : " + uemail);
			}

			// uname, utel만 업데이트
			if (updatedUserInfo.getUname() != null) {
				userInfo.setUname(updatedUserInfo.getUname());
			}
			if (updatedUserInfo.getUtel() != null) {
				userInfo.setUtel(updatedUserInfo.getUtel());
			}

			userInfoRepository.save(userInfo);

			return userConfig.getUpdateSuccess();
		} catch (Exception e) {
			e.printStackTrace();
			return userConfig.getUpdateFailure();
		}
	}
	
	// 회원 탈퇴 (사용자)
	
	// 회원 정보 삭제 (관리자)
	public String deleteUser(String uemail) throws Exception {
		try {
			UserInfo userInfo = userInfoRepository.findByUemail(uemail);
			if (userInfo == null) {
				return userConfig.getDeleteFailure(); // 삭제할 사용자를 찾지 못했을때
			}
			userInfoRepository.delete(userInfo);
			return userConfig.getDeleteSuccess();
		} catch (Exception e) {
			e.printStackTrace();
			return userConfig.getDeleteFailure();
		}
	}

}
