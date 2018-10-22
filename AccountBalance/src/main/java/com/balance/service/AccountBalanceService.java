package com.balance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balance.model.BankPojo;
import com.balance.repository.AccountBalanceRepository;


@Service
public class AccountBalanceService {
	

	@Autowired
	private AccountBalanceRepository abr;
	
	
	public int getAccountBalance(int accNo){
		
		BankPojo b=abr.findByAccNo(accNo);
		return b.getBalance();
	}
	
	
	public BankPojo create(int accNo,int balance)
	{
		return abr.save(new BankPojo(accNo,balance));
	}
	

}
