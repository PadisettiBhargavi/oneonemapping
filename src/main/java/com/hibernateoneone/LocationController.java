package com.hibernateoneone;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class LocationController {
	
	@Autowired 
	LocationRepo locationRepo;
	@PostMapping("/api/location")
	public ResponseEntity<Location>saveLocation(@RequestBody Location location){
		return new ResponseEntity<>(locationRepo.save(location),HttpStatus.CREATED);
	}
	@GetMapping("/api/location")
	public ResponseEntity<List<Location>> getAllLocation(){
		return new ResponseEntity<>(locationRepo.findAll(),HttpStatus.OK);
		
	}
	@GetMapping("/api/location/id")
	public ResponseEntity<Location>getLoactionById(@PathVariable int id){
		Optional<Location> location=locationRepo.findById(id);
		return location.map(value->new ResponseEntity<>(value,HttpStatus.OK))
				.orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PutMapping("/api/location/id")
	public ResponseEntity<Location> updateLocation(@PathVariable int id,@RequestBody Location updatedLocation){
		Optional<Location> existinglocation=locationRepo.findById(id);
		if(existinglocation.isPresent()) {
			Location location=existinglocation.get();
			location.setStreet(updatedLocation.getStreet());
			location.setCity(updatedLocation.getCity());
			location.setCode(updatedLocation.getCode());
			
			return new ResponseEntity<>(locationRepo.save(location),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
	}
	@DeleteMapping("/api/location/id")
	public ResponseEntity<Location> deletelocation(@PathVariable int id)
			{
		Optional<Location>location=locationRepo.findById(id);
		if(location.isPresent()) {
			locationRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
			}
	}


