package com.amit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.model.Locker;
import com.amit.service.LockerService;

@RestController
@RequestMapping("/locker")
public class LockerController {

	@Autowired
	private LockerService lockerService;
	
	
	@PostMapping("/lockers")
	public Locker createLockerHandler(@RequestBody Locker locker) {
		return lockerService.createLocker(locker);
	}
	
	
	@GetMapping("/lockers/{id}")
	public List<Locker> getAllAvailableLockersHandler(@PathVariable("id") Integer warehouseId){
		return lockerService.getAllAvailableLockers(warehouseId);
	}
	
	
	@DeleteMapping("/lockers/{id}")
	public boolean cancelLockerReservation(@RequestBody Locker locker, @PathVariable("id") Integer warehouseId) {
		return lockerService.cancelLockerReservation(locker, warehouseId);
	}
}
