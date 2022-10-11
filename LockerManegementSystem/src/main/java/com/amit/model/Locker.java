package com.amit.model;
import javax.validation.constraints.NotNull;

import com.amit.utils.Locker_Booking_status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Setter
@Getter
public class Locker{

	@NotNull
	private Integer lockerId;
	
	@NotNull	
	private String lockerName; 
	
	@NotNull
	private String password; 
	
	private Locker_Booking_status lockerAvailability; 
	
	private LockerItem lockerItem;
	
	private Warehouse lockerWarehouse; 

}
