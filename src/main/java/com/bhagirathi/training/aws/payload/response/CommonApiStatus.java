package com.bhagirathi.training.aws.payload.response;

public class CommonApiStatus {

	private ApiStatus apiStatus;
	private Object result;
	
	
	
	public CommonApiStatus(ApiStatus apiStatus, Object result) {
		super();
		this.apiStatus = apiStatus;
		this.result = result;
	}
	public ApiStatus getApiStatus() {
		return apiStatus;
	}
	public void setApiStatus(ApiStatus apiStatus) {
		this.apiStatus = apiStatus;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
	

}
