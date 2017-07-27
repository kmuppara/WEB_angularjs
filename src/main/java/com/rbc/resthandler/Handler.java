package com.rbc.resthandler;

public interface Handler<T extends Endpoint> {
	
	public void processRequest(T teo) throws Exception;

}
