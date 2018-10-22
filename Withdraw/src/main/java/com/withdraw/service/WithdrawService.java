package com.withdraw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.withdraw.model.BankPojo;
import com.withdraw.repository.WithdrawRepository;


@Service
public class WithdrawService {
	
	
	@Autowired
	private WithdrawRepository wr;
	
	
	
	public BankPojo withdraw(int amount){
		
		BankPojo b=wr.findByAccNo(amount);
		b.setBalance(b.getBalance()+amount);
		return b;
		
		
	}

}
