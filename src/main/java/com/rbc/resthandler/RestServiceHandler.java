package com.rbc.resthandler;

import javax.net.ssl.TrustManager;
import javax.net.ssl.SSLSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Component(value="RestHandler")
public class RestServiceHandler extends WebServiceGatewaySupport implements Handler<Endpoint>{

	@Autowired
	RestTemplate rt;

	@Override
	public void processRequest(Endpoint teo) throws Exception {
		ResponseEntity re = null;
		String uri = teo.getUri();
		HttpEntity<?> httpEntity;
		
		Class responseType = (null!=teo.getClassName()) ? teo.getClassName():String.class;
		if(null != teo.getRequestObj())
			httpEntity = new HttpEntity<Object>(teo.getRequestObj(), getHttpHeaders(teo));
		else
		httpEntity = new HttpEntity<Object>(teo.getRequest(), getHttpHeaders(teo));
		
		HttpMethod reqMethod = (teo.getMethod()!=null) ? teo.getMethod() : HttpMethod.POST ;
		re = rt.exchange(uri, reqMethod, httpEntity, responseType);
		
		if(null != re && re.hasBody()) {
			if(teo.getClassName() != null) {
				teo.setResponseObj(re.getBody());
				teo.setHeaderContent(re.getHeaders().getFirst("Location"));
				teo.setResponse(re.getBody().toString());
			}
			else {
				teo.setResponse(re.getBody().toString());
			}
		}
		teo.setHttpStatusCode(re.getStatusCode());
	}
	
	public HttpHeaders getHttpHeaders(Endpoint teo) {
		HttpHeaders headers = new HttpHeaders();
		if(StringUtils.hasText(teo.getReturnType())) {
			headers.set("Accept", teo.getReturnType());
		}
		if(null != teo.getContentType()) {
			headers.set("Content-Type", teo.getContentType().toString());
		}
		else {
			headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		}
		return headers;
	}
	/*
	private static void disableSslVerification() throws Exception{
		TrustManager[] trustAllCerts = new TrustManager[] {new X509Certifi{
			public java.security.cert.X509Certificate[] getAccptedIssuers(){
				return null;
			}
			public void checkClientTrusted(X509Certificate[] certs, String authType) {
			}
			public void checkServerTrusted(X509Certificate[] certs, String authType) {
				
			}
		}};
	}*/
	
	
	

}
