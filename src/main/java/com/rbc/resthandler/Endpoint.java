package com.rbc.resthandler;

import java.util.HashMap;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class Endpoint {
	
	private String request = "" ;
	private String response = "" ;
	private String callback = "" ;
	private MediaType contentType = MediaType.TEXT_XML ;
	private HashMap<String,String> inputParameters = new HashMap<String,String>();
	private Enum httpStatusCode;
	private String uri = "" ;
	private String returnType = "" ;
	private HttpMethod method ;
	private Class className;
	//soap request
	private String requestBody ;
	private String soapAction ;
	private String headerNamespace ;
	private String headerTagName ;
	private String headerContent ;
	private int connectionTimeout ;
	private int readTimeout ;
	
	public String getRequestBody() {
		return requestBody;
	}
	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}
	public String getSoapAction() {
		return soapAction;
	}
	public void setSoapAction(String soapAction) {
		this.soapAction = soapAction;
	}
	public String getHeaderNamespace() {
		return headerNamespace;
	}
	public void setHeaderNamespace(String headerNamespace) {
		this.headerNamespace = headerNamespace;
	}
	public String getHeaderTagName() {
		return headerTagName;
	}
	public void setHeaderTagName(String headerTagName) {
		this.headerTagName = headerTagName;
	}
	public String getHeaderContent() {
		return headerContent;
	}
	public void setHeaderContent(String headerContent) {
		this.headerContent = headerContent;
	}
	public int getConnectionTimeout() {
		return connectionTimeout;
	}
	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}
	public int getReadTimeout() {
		return readTimeout;
	}
	public void setReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
	}
	public Class getClassName() {
		return className;
	}
	public void setClassName(Class className) {
		this.className = className;
	}
	public Object getRequestObj() {
		return requestObj;
	}
	public void setRequestObj(Object requestObj) {
		this.requestObj = requestObj;
	}
	public Object getResponseObj() {
		return responseObj;
	}
	public void setResponseObj(Object responseObj) {
		this.responseObj = responseObj;
	}
	private Object requestObj ;
	private Object responseObj ;
	
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getCallback() {
		return callback;
	}
	public void setCallback(String callback) {
		this.callback = callback;
	}
	public MediaType getContentType() {
		return contentType;
	}
	public void setContentType(MediaType contentType) {
		this.contentType = contentType;
	}
	public HashMap<String, String> getInputParameters() {
		return inputParameters;
	}
	public void setInputParameters(HashMap<String, String> inputParameters) {
		this.inputParameters = inputParameters;
	}
	public Enum getHttpStatusCode() {
		return httpStatusCode;
	}
	public void setHttpStatusCode(Enum httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getReturnType() {
		return returnType;
	}
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	public HttpMethod getMethod() {
		return method;
	}
	public void setMethod(HttpMethod method) {
		this.method = method;
	}
	

}
