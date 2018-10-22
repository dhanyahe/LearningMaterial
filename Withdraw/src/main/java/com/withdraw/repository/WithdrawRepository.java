package com.withdraw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.withdraw.model.BankPojo;

public interface WithdrawRepository extends MongoRepository<BankPojo,String>{

	public BankPojo findByAccNo(int accNo);

}
