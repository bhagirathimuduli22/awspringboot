package com.bhagirathi.training.aws.payload.response;

import java.util.ArrayList;
import java.util.List;

public class ApiStatus {
	
	private String externalTransactionId;
	private String message;
	private String overallStatus;
	private Integer statusCode;
	private List<ApiError> errors = new ArrayList<>();

	
	
	public ApiStatus(String externalTransactionId, String message, String overallStatus, Integer statusCode,
			List<ApiError> errors) {
		super();
		this.externalTransactionId = externalTransactionId;
		this.message = message;
		this.overallStatus = overallStatus;
		this.statusCode = statusCode;
		this.errors = errors;
	}

	public ApiStatus(String externalTransactionId) {
		super();
		this.externalTransactionId = externalTransactionId;
	}

	public String getExternalTransactionId() {
		return externalTransactionId;
	}

	public void setExternalTransactionId(String externalTransactionId) {
		this.externalTransactionId = externalTransactionId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getOverallStatus() {
		return overallStatus;
	}

	public void setOverallStatus(String overallStatus) {
		this.overallStatus = overallStatus;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public List<ApiError> getErrors() {
		return errors;
	}

	public void setErrors(List<ApiError> errors) {
		this.errors = errors;
	}
	
	

}
