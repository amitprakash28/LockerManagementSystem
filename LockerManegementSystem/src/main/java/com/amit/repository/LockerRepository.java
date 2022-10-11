package com.amit.repository;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.amit.exception.LockerDoesnotExistsException;
import com.amit.exception.NoFreeLockersAvailableException;
import com.amit.model.Locker;

public interface LockerRepository {

	Locker createLocker(@Valid Locker locker);
	
	List<Locker> getAllAvailableLockers(@NotNull Integer warehouseId) throws NoFreeLockersAvailableException; 
	
	boolean cancelLockerReservation(@Valid Locker locker, @NotNull Integer warehouseId) throws LockerDoesnotExistsException; 
}
