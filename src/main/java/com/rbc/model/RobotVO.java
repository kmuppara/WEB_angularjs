package com.rbc.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class RobotVO {
	
	@JsonProperty
	private int robotId;
	@JsonProperty
	private String name;
	@JsonProperty
	private int price;
	
	public int getRobotId() {
		return robotId;
	}
	public void setRobotId(int robotId) {
		this.robotId = robotId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "RobotVO [robotId=" + robotId + ", name=" + name + ", price=" + price + "]";
	}

}
