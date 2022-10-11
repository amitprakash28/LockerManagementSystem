package com.amit.repository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.amit.exception.LockerDoesnotExistsException;
import com.amit.exception.UserDoesnotExistsException;
import com.amit.model.LockerUser;

public interface LockerUserRepository {

	LockerUser createLockerUser(@Valid LockerUser lockerUser);
	
	boolean bookLocker(@NotNull Integer warehouseId, @NotNull Integer lockerUserId) throws UserDoesnotExistsException;
	
	boolean storeLockerItem(@NotNull String lockerPassword, @NotNull Integer lockerUserId, @NotNull String lockerName) throws LockerDoesnotExistsException;
	
}
