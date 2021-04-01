package com.toy.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.toy.project.repository.CustomerRepository;
import com.toy.project.vo.CustomerVO;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	//고객 리스트
	public List<CustomerVO> customerList(){
		List<CustomerVO> customerList = new ArrayList<>();
		customerRepository.findAll().forEach(e -> customerList.add(e));
		return customerList;
	}
	
	//고객 정보 상세조회
	public Optional<CustomerVO> customerInfo(int idx){
		Optional<CustomerVO> customer = customerRepository.findById(idx);
		return customer;
	}
	
	//고객 정보 저장
	public CustomerVO customerRegist(CustomerVO customerVO) {
		customerRepository.save(customerVO);
		return customerVO;
	}
	
	//고객 정보 수정
	public void customerUpdate(int idx, CustomerVO customerVO) {
		Optional<CustomerVO> customer = customerRepository.findById(idx);
		
		if(customer.isPresent()) {
			customer.get().setCustomerPhonenum(customerVO.getCustomerPhonenum());
			customer.get().setCustomerAge(customerVO.getCustomerAge());
			customer.get().setCustomerAddr(customerVO.getCustomerAddr());
		}
	}
	
	//고객 정보 삭제
	public void customerInfoDelete(int idx) {
		customerRepository.deleteById(idx);
	}
	
}
