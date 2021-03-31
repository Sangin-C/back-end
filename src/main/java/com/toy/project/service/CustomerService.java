package com.toy.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toy.project.repository.CustomerRepository;
import com.toy.project.vo.CustomerVO;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public List<CustomerVO> findAll(){
		List<CustomerVO> customerList = new ArrayList<>();
		customerRepository.findAll().forEach(e -> customerList.add(e));
		return customerList;
	}
}
