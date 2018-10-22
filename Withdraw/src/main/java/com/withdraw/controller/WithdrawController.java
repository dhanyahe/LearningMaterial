package com.withdraw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.withdraw.service.WithdrawService;


@RestController
public class WithdrawController {
	
	@Autowired
	private WithdrawService ws;
	
	 @Autowired
	    private DiscoveryClient discoveryClient;

	@RequestMapping("/withdraw")
	public com.withdraw.model.BankPojo depositAmount(int amount){
		
	return 	ws.withdraw(amount);
		
		
	}
	
	
	

}
