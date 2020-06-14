package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.OrderSMS;
import com.repository.OrderSMSRepository;

@Component
@RestController
@RequestMapping("/OrderSMS")
public class OrderSMSController {

	@Autowired
	OrderSMSRepository repository;
	
    @RequestMapping(method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public Long create(@RequestBody OrderSMS orderSMS) {
		repository.save(orderSMS);
		return orderSMS.getId();
	}
	
    @RequestMapping(value = "/all") 
    public List<OrderSMS> read(){
    	return (List<OrderSMS>) repository.findAll();
    	
    }
    
    @RequestMapping(value = "/{id}")
    public Optional<OrderSMS> read(@PathVariable Long id){
    	return repository.findById(id);
    }
	
	
}
