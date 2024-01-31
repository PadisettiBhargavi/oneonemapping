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

public class NexEmployeeController {
@Autowired 
NexEmployeeRepo nexemployeeRepo;
@PostMapping("/api/nexemployee")
public ResponseEntity<NexEmployee>saveNexEmployee(@RequestBody NexEmployee nexemployee){
	return new ResponseEntity<>(nexemployeeRepo.save(nexemployee),HttpStatus.CREATED);
}
@GetMapping("/api/nexemployee")
public ResponseEntity<List<NexEmployee>> getAllNexEmployees(){
	return new ResponseEntity<>(nexemployeeRepo.findAll(),HttpStatus.OK);
	
}
@GetMapping("/api/nexemployee/id")
public ResponseEntity<NexEmployee>getNexEmployeeById(@PathVariable int id){
	Optional<NexEmployee> nexemployee=nexemployeeRepo.findById(id);
	return nexemployee.map(value->new ResponseEntity<>(value,HttpStatus.OK))
			.orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
}

@PutMapping("/api/nexemployee/id")
public ResponseEntity<NexEmployee> updateNexEmployee(@PathVariable int id,@RequestBody NexEmployee updatedNexEmployee){
	Optional<NexEmployee> existingNexEmployee=nexemployeeRepo.findById(id);
	if(existingNexEmployee.isPresent()) {
		NexEmployee nexemployee=existingNexEmployee.get();
		nexemployee.setName(updatedNexEmployee.getName());
		nexemployee.setDob(updatedNexEmployee.getName());
		nexemployee.setGender(updatedNexEmployee.getName());
		nexemployee.setSalary(updatedNexEmployee.getSalary());
		return new ResponseEntity<>(nexemployeeRepo.save(nexemployee),HttpStatus.OK);
	}
	else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
}
@DeleteMapping("/api/nexemployee/id")
public ResponseEntity<NexEmployee> deleteNexEmployee(@PathVariable int id)
		{
	Optional<NexEmployee> nexemployee=nexemployeeRepo.findById(id);
	if(nexemployee.isPresent()) {
		nexemployeeRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
		}
}
