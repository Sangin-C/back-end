package com.toy.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toy.project.service.CustomerService;
import com.toy.project.vo.CustomerVO;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping
	public ResponseEntity<List<CustomerVO>> customerList(){
		System.out.println("고객 전체 리스트 출력.....");
		List<CustomerVO> customerList = customerService.findAll();
		return new ResponseEntity<List<CustomerVO>>(customerList, HttpStatus.OK);
	}
}
