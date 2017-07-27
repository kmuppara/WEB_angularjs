package com.rbc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rbc.model.RobotVO;
import com.rbc.resthandler.Endpoint;
import com.rbc.service.WebServiceBO;

@RestController
@RequestMapping(produces=MediaType.ALL_VALUE,consumes=MediaType.ALL_VALUE)
public class WebRestController {
	
	@Autowired
	WebServiceBO webServiceBO;
	
	@Autowired
	Endpoint endpoint;
	
	@Autowired
	RobotVO robot;
	
	@RequestMapping(value="/getRobot",method=RequestMethod.GET)
	public RobotVO getRobot(@RequestParam("robotid")int id) throws Exception{
		endpoint = webServiceBO.getRobot(id);
		if(endpoint.getHttpStatusCode()==HttpStatus.OK)
			robot = (RobotVO)endpoint.getResponseObj();
		else robot = new RobotVO();
		return robot;
	}
	
	@RequestMapping(value="/addRobot",method=RequestMethod.POST)
	public String addRobot(@RequestBody RobotVO robot) throws Exception{
		endpoint = webServiceBO.addRobot(robot);
		endpoint.getHttpStatusCode();
		return null;
	}
	
	@RequestMapping(value="/deleteRobot",method=RequestMethod.DELETE)
	public String deleteRobot(@RequestParam("robotid") int id) throws Exception{
		endpoint = webServiceBO.deleteRobot(id);
		endpoint.getHttpStatusCode();
		return null;
	}
	
	@RequestMapping(value="/getAllRobots",method=RequestMethod.GET)
	public List<RobotVO> getAllRobot() throws Exception{
		List<RobotVO> robots = new ArrayList<RobotVO>();
		endpoint = webServiceBO.getAllRobots();
		if(endpoint.getHttpStatusCode()==HttpStatus.OK)
			robots = (ArrayList<RobotVO>)endpoint.getResponseObj();
		return robots;
	}

}
