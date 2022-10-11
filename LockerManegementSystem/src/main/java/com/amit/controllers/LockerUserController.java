package com.amit.controllers;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.model.LockerUser;
import com.amit.service.LockerUserService;

@RestController
@RequestMapping("/user")
public class LockerUserController {

	@Autowired
	private LockerUserService lockerUserService; 
	
	
	@PostMapping("/lockerusers")
	public LockerUser createLockerUserHandler(@RequestBody LockerUser lockerUser) {
		return lockerUserService.createLockerUser(lockerUser);
	} 
	
	
	@PostMapping("/lockers/{wid}/{lid}")
	public boolean bookLockerHandler(@NotNull @PathVariable("wid") Integer warehouseId, @NotNull @PathVariable("lid") Integer lockerUserId) {
		return lockerUserService.bookLocker(warehouseId, lockerUserId);
	}
	
	
	@PutMapping("/stores/{p}/{id}")
	public boolean storeLockerItemHandler(@NotNull @PathVariable("p") String lockerPassword, @NotNull @PathVariable("id") Integer lockerUserId,
			@NotNull String lockerName) {
		return lockerUserService.storeLockerItem(lockerPassword, lockerUserId, lockerName); 
	}
}
