package com.amit.service;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import com.amit.exception.LockerDoesnotExistsException;
import com.amit.exception.NoFreeLockersAvailableException;
import com.amit.model.Locker;
import com.amit.model.Warehouse;
import com.amit.repository.LockerRepository;
import com.amit.utils.Locker_Booking_status;

public class LockerService implements LockerRepository{

	@Override
	public Locker createLocker(@Valid Locker locker) {
		/*
		 * save the locker object
		 * intially the booking_status would be available
		 * */
		return null;
	}

	@Override
	public List<Locker> getAllAvailableLockers(Integer warehouseId) throws NoFreeLockersAvailableException{
		/* find the warehouse using provided id
		 * get all its lockers
		 * check for availability for each lockers
		 * if not any found then method would throw an NoFreeLockersAvailableException.
		 * */
		List<Locker> allAvailableLockers = new ArrayList<>(); 
		Warehouse foundWarehouse = new Warehouse(); //fetched from DB
		for(Locker locker : foundWarehouse.getAllLockersInWarehouse()) {
			if(locker.getLockerAvailability().equals(Locker_Booking_status.AVAILABLE)) {
				allAvailableLockers.add(locker);
			}
		}
		
		if(allAvailableLockers.size() != 0) {
			return allAvailableLockers;
		}
		else {
			throw new NoFreeLockersAvailableException("No Free Lockers currently available to book");
		}
	}

	
	@Override
	public boolean cancelLockerReservation(Locker locker, Integer warehouseId) throws LockerDoesnotExistsException {
		/* find the warehouse using provided id
		 * get all its lockers
		 * match locker instance with the id of provided locker
		 * if matched then make its availability
		 * else, will throw an LockerDoesnotExistsException.
		 * */
		Warehouse foundWarehouse = new Warehouse(); //fetched from DB
		for(Locker LockersInWarehouse : foundWarehouse.getAllLockersInWarehouse()) {
			if(LockersInWarehouse.getLockerId() == locker.getLockerId() && LockersInWarehouse.getPassword().equals(locker.getPassword())) {
				LockersInWarehouse.getLockerItem().setLockerItemId(null);
				LockersInWarehouse.setLockerAvailability(Locker_Booking_status.AVAILABLE);
			}
		}
		
		return false;
	}




	
}
