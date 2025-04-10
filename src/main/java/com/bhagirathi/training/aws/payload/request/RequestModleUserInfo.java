package com.bhagirathi.training.aws.payload.request;

import org.springframework.web.multipart.MultipartFile;

public class RequestModleUserInfo {
	
	private Long userId;
	private String userName;
	private MultipartFile profileImage;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public MultipartFile getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(MultipartFile profileImage) {
		this.profileImage = profileImage;
	}
}