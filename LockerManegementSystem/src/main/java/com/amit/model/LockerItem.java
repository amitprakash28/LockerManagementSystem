package com.amit.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LockerItem {
 
	private Integer lockerItemId; 
	
	private String lockerItemName; 
	
	private LockerUser lockerUser; 
	
}
