package com.seedrs.challenge;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.seedrs.challenge.entities.Coordinate;

@Repository
public interface CoordinateRepository extends MongoRepository<Coordinate, String>{
	public Coordinate findByCoordinateXAndCoordinateY(int coordinateX, int coordinateY);
}
