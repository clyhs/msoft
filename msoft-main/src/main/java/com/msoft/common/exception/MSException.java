package com.msoft.common.exception;

public class MSException extends Exception {
	
	private String msg;
	
	
	
	public MSException(String msg){
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return msg;
	}

}
