package com.deposit.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.deposit.model.BankPojo;
import com.deposit.repository.DepositRepository;

public class DepositService {
	
	
	@Autowired
	private DepositRepository dr;
	
	@Autowired
	private BankPojo b;
	
	
	public BankPojo deposit(int amount){
		
		BankPojo b=dr.findByAccNo(amount);
		b.setBalance(b.getBalance()+amount);
		return b;
		
		
	}

}
