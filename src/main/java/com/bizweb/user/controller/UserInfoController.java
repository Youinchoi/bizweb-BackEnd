package com.bizweb.user.controller;

import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bizweb.user.entity.UserInfo;
import com.bizweb.user.service.UserInfoService;

@RestController
@RequestMapping("/api/user")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;

	UserInfoController(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(UserInfoController.class);

	// 회원가입
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody UserInfo userInfo) {
		String message = userInfoService.registerUser(userInfo);
		try {
			if (message.equals(userInfoService.getUserConfig().getRegisterSuccess())) {
				return ResponseEntity.ok(message);
			} else {
				return ResponseEntity.badRequest().body(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body(message);
		}
	}
	
	// 이메일 중복 확인
    @PostMapping("/check-email")
    public ResponseEntity<Boolean> checkEmailDuplicate(@RequestBody Map<String, String> request) {
        String uemail = request.get("uemail");
        log.info("uemail: {}", uemail);
        boolean isDuplicate = userInfoService.isEmailDuplicate(uemail);
        return ResponseEntity.ok(isDuplicate);
    }

	// 로그인
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody UserInfo userInfo) {
		String uemail = userInfo.getUemail();
		String upassword = userInfo.getUpassword();

		log.info("uemail: {}", uemail);
		log.info("upassword: {}", upassword);

		String message = userInfoService.loginUser(uemail, upassword);

		if (message.equals(userInfoService.getUserConfig().getLoginSuccess())) {
			return ResponseEntity.ok(message);
		} else {
			return ResponseEntity.status(401).body(message);
		}
	}
	
	// 비밀번호 찾기
	
	// 비밀번호 변경

	// 마이페이지 - 정보 수정
	@PatchMapping("/modify/{uemail}")
	public ResponseEntity<String> modifyUser(@PathVariable("uemail") String uemail,
			@RequestBody UserInfo updatedUserInfo) {
		
		String message = userInfoService.modifyUser(uemail, updatedUserInfo);
		if (message.equals(userInfoService.getUserConfig().getUpdateSuccess())) {
			return ResponseEntity.ok(message);
		} else {
			return ResponseEntity.badRequest().body(message);
		}
	}
	
	// 회원 탈퇴 (사용자)
	
	// 회원 정보 삭제 (관리자)
	@DeleteMapping("/delete/{uemail}")
	public ResponseEntity<String> deleteUser(@PathVariable("uemail") String uemail) throws Exception {
		String message = userInfoService.deleteUser(uemail);
		if (message.equals(userInfoService.getUserConfig().getDeleteSuccess())) {
			return ResponseEntity.ok(message);
		} else {
			return ResponseEntity.badRequest().body(message);
		}
	}
	
}