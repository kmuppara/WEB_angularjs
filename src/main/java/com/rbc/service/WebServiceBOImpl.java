package com.rbc.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.rbc.model.RobotVO;
import com.rbc.resthandler.Endpoint;
import com.rbc.resthandler.RestServiceHandler;

@Service
public class WebServiceBOImpl implements WebServiceBO {
	
	@Autowired
	Endpoint endPoint;
	
	private String BASE_URI = "http://localhost:8088/";
	
	@Autowired
	RestServiceHandler restHandler;
	
	/*@Override
	public Endpoint getRobo() {
		StringBuilder uri = new StringBuilder(BASE_URI);
		endPoint.setUri(uri.append("home").toString());
		endPoint.setMethod(HttpMethod.GET);
		endPoint.setRequest(null);
		endPoint.setRequestObj(null);
		endPoint.setClassName(RobotVO.class);
		endPoint.setReturnType(MediaType.APPLICATION_JSON_VALUE);
		endPoint.setContentType(MediaType.APPLICATION_JSON);
		try {
			restHandler.processRequest(endPoint);
			return endPoint;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}*/

	@Override
	public Endpoint addRobot(RobotVO robot) throws Exception {
		StringBuilder uri = new StringBuilder(BASE_URI);
		endPoint.setUri(uri.append("robot").toString());
		endPoint.setMethod(HttpMethod.POST);
		endPoint.setRequest(robot.toString());
		endPoint.setRequestObj(robot);
		endPoint.setClassName(RobotVO.class);
		endPoint.setReturnType(MediaType.APPLICATION_JSON_VALUE);
		endPoint.setContentType(MediaType.APPLICATION_JSON);
		try {
			restHandler.processRequest(endPoint);
			return endPoint;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Endpoint getRobot(int id) throws Exception {
		endPoint = new Endpoint();
		StringBuilder uri = new StringBuilder(BASE_URI);
		endPoint.setUri(uri.append("robot/").append(id).toString());
		endPoint.setMethod(HttpMethod.GET);
		endPoint.setRequest(null);
		endPoint.setRequestObj(null);
		endPoint.setClassName(RobotVO.class);
		endPoint.setReturnType(MediaType.APPLICATION_JSON_VALUE);
		endPoint.setContentType(MediaType.APPLICATION_JSON);
		try {
			restHandler.processRequest(endPoint);
			return endPoint;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Endpoint deleteRobot(int id) throws Exception {
		endPoint = new Endpoint();
		StringBuilder uri = new StringBuilder(BASE_URI);
		endPoint.setUri(uri.append("robot/").append(id).toString());
		endPoint.setMethod(HttpMethod.DELETE);
		endPoint.setRequest(null);
		endPoint.setRequestObj(null);
		endPoint.setClassName(RobotVO.class);
		endPoint.setReturnType(MediaType.APPLICATION_JSON_VALUE);
		endPoint.setContentType(MediaType.APPLICATION_JSON);
		try {
			restHandler.processRequest(endPoint);
			return endPoint;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Endpoint getAllRobots() throws Exception {
		endPoint = new Endpoint();
		StringBuilder uri = new StringBuilder(BASE_URI);
		endPoint.setUri(uri.append("robots").toString());
		endPoint.setMethod(HttpMethod.GET);
		endPoint.setRequest(null);
		endPoint.setRequestObj(null);
		endPoint.setClassName(ArrayList.class);
		endPoint.setReturnType(MediaType.APPLICATION_JSON_VALUE);
		endPoint.setContentType(MediaType.APPLICATION_JSON);
		try {
			restHandler.processRequest(endPoint);
			return endPoint;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
