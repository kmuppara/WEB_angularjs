package com.rbc.model;

public class CustomErr {
	
	private String errorMsg;

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	public CustomErr(String errorMsg){
        this.errorMsg = errorMsg;
    }

}
