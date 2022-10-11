package com.amit.model;

import java.time.LocalDateTime;

import com.amit.utils.Payment_Mode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Bill {

	private Integer billId; 
	private Payment_Mode modeOfPayment; 
	private LocalDateTime localDateTime; 
}
