package com.rbc.service;

import org.springframework.stereotype.Service;

import com.rbc.model.RobotVO;
import com.rbc.resthandler.Endpoint;

@Service
public interface WebServiceBO {
	
	/*public Endpoint getRobo();*/
	public Endpoint addRobot(RobotVO robot) throws Exception;
	public Endpoint getRobot(int id) throws Exception;
	public Endpoint deleteRobot(int id) throws Exception;
	public Endpoint getAllRobots() throws Exception;

}
