package com.seedrs.challenge.entities;

import org.springframework.data.annotation.Id;

public class Coordinate {

	@Id
	private String id;
	
	private int coordinateX;
	private int coordinateY;
		
	public Coordinate() {}
	
	public Coordinate(int coordinateX, int coordinateY){
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
	}
	
	public int getCoordinateX() {
		return coordinateX;
	}
	
	public int getCoordinateY() {
		return coordinateY;
	}
	
	@Override
	public String toString() {
		return "("+coordinateX + ","+coordinateY+")";
	}
	
	
}
