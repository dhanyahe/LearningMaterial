package com.balance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.balance.model.BankPojo;
import com.balance.service.AccountBalanceService;


@RestController
public class AccountBalanceController {
	@Autowired
	private AccountBalanceService service;
	
	

	@RequestMapping("/create")
	public BankPojo create(@RequestParam int accNo,@RequestParam int balance)
	{
		 BankPojo b= service.create(accNo,balance);
		return b;
	}
	
	@RequestMapping(value="/getAccountBalance/{accNo}")
	public int getAmount(@PathVariable("accNo") final int accNo)
	{
		return service.getAccountBalance(accNo); 
	}
	
	

}
