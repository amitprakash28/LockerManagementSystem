package com.amit.model;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LockerUser extends Person{

	private Integer userId; 
	
	private Set<Locker> setOfLockers; 
	
	private Set<Bill> allBills; 
	
}
