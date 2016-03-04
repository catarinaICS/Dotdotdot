package com.seedrs.challenge.entities;

/**
 * A class for the REST representation of a coordinate.
 * @author catarina
 *
 */
public class RestCoord {
	
	private int x;
	private int y;
	
	public RestCoord(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	

}
