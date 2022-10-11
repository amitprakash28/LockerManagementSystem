package com.amit.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.amit.exception.LockerDoesnotExistsException;
import com.amit.exception.UserDoesnotExistsException;
import com.amit.model.Bill;
import com.amit.model.Locker;
import com.amit.model.LockerItem;
import com.amit.model.LockerUser;
import com.amit.model.Warehouse;
import com.amit.repository.LockerUserRepository;
import com.amit.utils.Locker_Booking_status;
import com.amit.utils.Payment_Mode;

public class LockerUserService implements LockerUserRepository{

	@Override
	public LockerUser createLockerUser(@Valid LockerUser lockerUser) {
		/* takes lockerUser from the client and persist in the DB
		 * */
		return null;
	}

	@Override
	public boolean bookLocker(@NotNull Integer warehouseId, @NotNull Integer lockerUserId) throws UserDoesnotExistsException{
		/* first find whether a LockerUser exists or not with the provided LockerId
		 * if yes, then find the Warehouse with the provided warehouseId 
		 * if found, then find all the available lockers with enum value as AVAILABLE
		 * user can book one or many as per wish and pay accordingly with choice of Payment_Mode
		 * 
		 * if no LockerUser found with the provided methid would throw UserDoesnotExistsException
		 * */
		
		LockerUser foundedLockerUserFromDB = new LockerUser(); //fetched from the DB using lockerUserId
		Set<Bill> lockerUserBills = foundedLockerUserFromDB.getAllBills();
		Warehouse foundedWarehouseFromDB = new Warehouse(); //fetched from the DB using warehouseId
		for(Locker locker : foundedWarehouseFromDB.getAllLockersInWarehouse()) {
			if(locker.getLockerAvailability().equals(Locker_Booking_status.AVAILABLE)) {
				foundedLockerUserFromDB.getSetOfLockers().add(locker);
				Bill bill = new Bill(); 
				bill.setModeOfPayment(Payment_Mode.UPI);
				bill.setLocalDateTime(LocalDateTime.now());	
				lockerUserBills.add(bill);
			}
		}
		return true;
	}

	
	@Override
	public boolean storeLockerItem(@NotNull String lockerPassword, @NotNull Integer lockerUserId,
			@NotNull String lockerName) throws LockerDoesnotExistsException {
		LockerUser foundedLockerUserFromDB = new LockerUser(); //fetched from the DB using lockerUserId
		for(Locker locker : foundedLockerUserFromDB.getSetOfLockers()) {
			if(locker.getLockerName().equals(lockerName) && locker.getPassword().equals(lockerPassword)) {
				locker.setLockerItem(new LockerItem());
			}
		}
		return false;
	}

	
	
	
	
	
	
	
	
	
	
	

}
