package com.bhagirathi.training.aws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhagirathi.training.aws.dbmodel.EntityPlace;
import com.bhagirathi.training.aws.dbmodel.EntityUserInfo;
import com.bhagirathi.training.aws.payload.request.RequestModelPlace;
import com.bhagirathi.training.aws.payload.request.RequestModleUserInfo;
import com.bhagirathi.training.aws.payload.response.CommonApiStatus;
import com.bhagirathi.training.aws.service.ServicePlace;
import com.bhagirathi.training.aws.service.ServiceUserInfo;

@RestController
@RequestMapping("/places")
public class ControllerPlaces implements AbstractController {

	@Autowired
	private ServicePlace servicePlace;

	@GetMapping
	public ResponseEntity<CommonApiStatus> getPlaces() {

		try {
			List<EntityPlace> adminRequisitionList = servicePlace.getPlaces();
			return getSuccessStatus("EXT1234567890", "Success", adminRequisitionList);
		} catch (Exception e) {
			e.printStackTrace();
			return getErrorStatus("EXT1234567890", e.getLocalizedMessage(), 100, null);
		}
	}
	
	@PostMapping
	public ResponseEntity<CommonApiStatus> createPlace(@RequestBody RequestModelPlace requestModelPlace) {

		try {
			 servicePlace.createPlace(requestModelPlace);
			return getSuccessStatus("EXT1234567890", "Success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return getErrorStatus("EXT1234567890", e.getLocalizedMessage(), 100, null);
		}
	}
}