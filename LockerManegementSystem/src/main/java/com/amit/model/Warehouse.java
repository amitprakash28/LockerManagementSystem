package com.amit.model;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Warehouse {

	private Address warehouseAddress; 
	private Integer warehouseId; 
	private String warehouseName; 
	
	private Set<Locker> allLockersInWarehouse; 
}
