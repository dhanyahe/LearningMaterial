package com.deposit.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.deposit.model.BankPojo;
import com.deposit.service.DepositService;


public class DepositController {

	@Autowired
	private DepositService ds;
	
	 @Autowired
	    private DiscoveryClient discoveryClient;

	
	
    @Autowired
    //private DiscoveryClient discoveryClient;
    private LoadBalancerClient loadBalancer;
    
    @RequestMapping(value="/deposit")
    public BankPojo deposit(@RequestParam int amount, @RequestParam int accountNumber)
    {
           ServiceInstance serviceInstance=loadBalancer.choose("AccountBalance");
           String baseUrl=serviceInstance.getUri().toString();
           baseUrl=baseUrl+"/getAccountBalance/"+accountNumber;
           
           RestTemplate restTemplate = new RestTemplate();
           ResponseEntity<Double> response=null;
           try{
           response=restTemplate.exchange(baseUrl,
                        HttpMethod.GET, getHeaders() ,Double.class);
           }catch (Exception ex)
           {
                  System.out.println(ex);
           }
           double accountBalance=response.getBody();
           return ds.deposit(amount);
           
    }
    
    private static HttpEntity<?> getHeaders() throws IOException {
           HttpHeaders headers = new HttpHeaders();
           headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
           return new HttpEntity<>(headers);
    }

	
	
	
	
}
