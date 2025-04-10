package com.bhagirathi.training.aws.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.bhagirathi.training.aws.payload.response.ApiError;
import com.bhagirathi.training.aws.payload.response.ApiStatus;
import com.bhagirathi.training.aws.payload.response.CommonApiStatus;
import com.bhagirathi.training.aws.utility.ApplicationConstants;

public interface AbstractController {
	
	default ResponseEntity<CommonApiStatus> getSuccessStatus(String externalTransactionId, String message,
			Object result) {
		ApiStatus apiStatus = new ApiStatus(externalTransactionId, message, ApplicationConstants.STATUS_SUCCESS, 0,
				null);
		return ResponseEntity.ok(new CommonApiStatus(apiStatus, result));
	}

	default ResponseEntity<CommonApiStatus> getErrorStatus(String externalTransactionId, String errorMessage,
			Integer errorCode, Object result) {
		List<ApiError> errors = new ArrayList<>();
		ApiError error = new ApiError(errorCode, errorMessage);
		errors.add(error);
		ApiStatus apiStatus = new ApiStatus(externalTransactionId, errorMessage, ApplicationConstants.STATUS_ERROR, 1,
				errors);
		return ResponseEntity.ok(new CommonApiStatus(apiStatus, result));
	}

}
