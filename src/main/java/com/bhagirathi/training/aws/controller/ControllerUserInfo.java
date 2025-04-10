package com.bhagirathi.training.aws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhagirathi.training.aws.dbmodel.EntityUserInfo;
import com.bhagirathi.training.aws.payload.request.RequestModleUserInfo;
import com.bhagirathi.training.aws.payload.response.CommonApiStatus;
import com.bhagirathi.training.aws.service.ServiceUserInfo;

@RestController
@RequestMapping("/users")
public class ControllerUserInfo implements AbstractController {

	@Autowired
	ServiceUserInfo serviceUserInfo;

	@GetMapping
	public ResponseEntity<CommonApiStatus> getUsers() {

		try {
			List<EntityUserInfo> adminRequisitionList = serviceUserInfo.getUsers();
			return getSuccessStatus("EXT1234567890", "Success", adminRequisitionList);
		} catch (Exception e) {
			e.printStackTrace();
			return getErrorStatus("EXT1234567890", e.getLocalizedMessage(), 100, null);
		}
	}

	@PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<CommonApiStatus> createUser(@ModelAttribute RequestModleUserInfo requestModleUserInfo) {
		try {
			serviceUserInfo.createUserInfo(requestModleUserInfo);
			return getSuccessStatus("EXT1234567890", "Success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return getErrorStatus("EXT1234567890", e.getLocalizedMessage(), 100, null);
		}
	}

}
