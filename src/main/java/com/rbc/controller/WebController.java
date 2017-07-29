package com.rbc.controller;

import java.security.Principal;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rbc.model.RobotVO;
import com.rbc.resthandler.Endpoint;
import com.rbc.service.WebServiceBO;

@Controller
public class WebController {
	
	@Autowired
	WebServiceBO webServiceBO;
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public ModelAndView home(ModelAndView mv, Principal principal) {
		String uName = principal.getName();
		String viewName = uName.equalsIgnoreCase("userA")?("Home"):("HomeB");
		mv.setViewName(viewName);
		return mv;
	}
	
	/*@RequestMapping(value="/getRobo",method=RequestMethod.GET)
	public RobotVO getRobot() {
		RobotVO robot = new RobotVO();
		robot.setName("Prasad");
		robot.setPrice(123);
		robot.setRobotId(1);
		return robot;
	}

	
	@RequestMapping(value="/robot",method=RequestMethod.POST)
	public String addRobot(@RequestBody RobotVO robot) throws Exception{
		Endpoint endpoint = webServiceBO.addRobot(robot);
		RobotVO robo = (RobotVO)endpoint.getResponseObj();
        return "Home";
	}
	
	@RequestMapping(value="/robot/{robotId}",method=RequestMethod.GET)
	public String getRobot(@RequestParam("robotId") int id) throws Exception{
		Endpoint endpoint = webServiceBO.getRobot(id);
		RobotVO robo = (RobotVO)endpoint.getResponseObj();
		return "Home";
	}
	
	@RequestMapping(value="/robot/{robotId}",method=RequestMethod.DELETE)
	public String deleteRobot(@RequestParam("robotId") int id) throws Exception{
		Endpoint endpoint = webServiceBO.deleteRobot(id);
		RobotVO robo = (RobotVO)endpoint.getResponseObj();
		return "Home";
	}
	
*/
	
}
