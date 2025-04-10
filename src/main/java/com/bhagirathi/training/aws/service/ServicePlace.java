package com.bhagirathi.training.aws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhagirathi.training.aws.dbmodel.EntityPlace;
import com.bhagirathi.training.aws.dbmodel.EntityUserInfo;
import com.bhagirathi.training.aws.payload.request.RequestModelPlace;
import com.bhagirathi.training.aws.payload.request.RequestModleUserInfo;
import com.bhagirathi.training.aws.repo.RepoPlaces;
import com.bhagirathi.training.aws.repo.RepoUserInfo;
import com.bhagirathi.training.aws.utility.UtilityAsset;

@Service
public class ServicePlace {
	
	@Autowired
	private RepoPlaces repoPlaces;
	
	
	public List<EntityPlace> getPlaces(){
		return repoPlaces.findAll();
	}
	
	public void createPlace(RequestModelPlace requestModelPlace) {
		EntityPlace entityPlace = new EntityPlace();
		entityPlace.setPlaceName(requestModelPlace.getPlaceName());
		entityPlace.setPincode(requestModelPlace.getPincode());
		entityPlace.setCity(requestModelPlace.getCity());
		repoPlaces.save(entityPlace);
		
	}
}
