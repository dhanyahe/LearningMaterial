package com.withdraw.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="bank")
public class BankPojo {
	
	@Id
	private int accNo;
	private int balance;
	
	
	
	
	
	public BankPojo(int accNo, int balance) {
		super();
		this.accNo = accNo;
		this.balance = balance;
	}
	
	
	@Override
	public String toString() {
		return "BankPojo [accNo=" + accNo + ", balance=" + balance + "]";
	}


	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	

}
