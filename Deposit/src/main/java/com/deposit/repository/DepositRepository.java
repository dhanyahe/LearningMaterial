package com.deposit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.deposit.model.BankPojo;

public interface DepositRepository extends MongoRepository<BankPojo,String>{

	public BankPojo findByAccNo(int accNo);
}
