package com.amit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person {
	
	private String name; 
	private Address address;
	private Contact contactDetails;
}
