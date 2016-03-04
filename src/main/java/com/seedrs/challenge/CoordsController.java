package com.seedrs.challenge;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seedrs.challenge.entities.Coordinate;
import com.seedrs.challenge.entities.RestCoord;

@RestController
public class CoordsController {

	@Autowired(required=true)
	CoordinateRepository coords;
	
	/**
	 * Add a new coordinate to the database
	 * @param x - coordinate X;
	 * @param y - coordinate Y;
	 */
	@RequestMapping("/addCoordinate/{x}/{y}")
	public ResponseEntity<String> addCoordinate(@PathVariable int x, @PathVariable int y){
		try{
			if(coords.findByCoordinateXAndCoordinateY(x, y) == null){
				Coordinate point = new Coordinate(x, y);
				System.out.println("Saving coordinate to database");
				coords.save(point);
				return new ResponseEntity<String>(HttpStatus.OK);
			}else{
				System.out.println("That coordinate is already stored");
				return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	/**
	 * Get a REST representation of the coordinates saved in the database
	 * @return A REST representation of the coordinates
	 */
	@RequestMapping("/getSavedCoordinates")
	public ResponseEntity<List<RestCoord> > getCoordinates(){
		List<RestCoord> list = new ArrayList<RestCoord>();
		try{
			for(Coordinate c : coords.findAll()){
				RestCoord rc = new RestCoord(c.getCoordinateX(), c.getCoordinateY());
				list.add(rc);
			}
			return new ResponseEntity<List<RestCoord> >(list, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<List<RestCoord> >(HttpStatus.SERVICE_UNAVAILABLE);
		}


	}
	
	@RequestMapping("/find/{x}/{y}")
	public Coordinate findCoord(@PathVariable int x, @PathVariable int y){
		Coordinate c = coords.findByCoordinateXAndCoordinateY(x, y);
		System.out.println(c);
		return c;
	}
}
