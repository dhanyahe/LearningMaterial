package com.balance.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.balance.model.BankPojo;

public interface AccountBalanceRepository extends MongoRepository<BankPojo,String>{
	
	public BankPojo findByAccNo(int accNo);

}
