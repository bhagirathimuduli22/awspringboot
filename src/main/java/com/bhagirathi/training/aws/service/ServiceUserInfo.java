package com.bhagirathi.training.aws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhagirathi.training.aws.dbmodel.EntityUserInfo;
import com.bhagirathi.training.aws.payload.request.RequestModleUserInfo;
import com.bhagirathi.training.aws.repo.RepoUserInfo;
import com.bhagirathi.training.aws.utility.UtilityAsset;

@Service
public class ServiceUserInfo {
	
	@Autowired
	private RepoUserInfo repoUserInfo;
	
	@Autowired
	private UtilityAsset utilityAsset;
	
	public List<EntityUserInfo> getUsers(){
		return repoUserInfo.findAll();
	}
	
	public void createUserInfo(RequestModleUserInfo requestModleUserInfo) {
		EntityUserInfo entityUserInfo = new EntityUserInfo();
		entityUserInfo.setUserName(requestModleUserInfo.getUserName());
		repoUserInfo.save(entityUserInfo);
		utilityAsset.saveProfileImage(requestModleUserInfo.getProfileImage(), entityUserInfo.getId());
	}
}
