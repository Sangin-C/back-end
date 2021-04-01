package com.toy.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toy.project.service.CustomerService;
import com.toy.project.vo.CustomerVO;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	//리스트
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE }) //JSON 타입만 리턴하겠다는것임.
	public ResponseEntity<List<CustomerVO>> customerList(){
		System.out.println("고객 전체 리스트 출력.....");
		List<CustomerVO> customerList = customerService.customerList();
		return new ResponseEntity<List<CustomerVO>>(customerList, HttpStatus.OK);
	}
	
	//상세조회
	@GetMapping(value= "/{idx}", 
			produces = { MediaType.APPLICATION_JSON_VALUE }) //JSON 타입만 리턴하겠다는것임.
	public ResponseEntity<CustomerVO> customerInfo(@PathVariable("idx") int idx){
		Optional<CustomerVO> customer = customerService.customerInfo(idx);
		return new ResponseEntity<CustomerVO>(customer.get(), HttpStatus.OK);
	}
	
	//등록
	@PostMapping
	public void customerRegist(@RequestBody CustomerVO customerVO){
		customerService.customerRegist(customerVO);
	}
	
	//수정
	@PutMapping(value="/{idx}")
	public void customerUpdate(@PathVariable("idx") int idx, @RequestBody CustomerVO customerVO){
		customerService.customerUpdate(idx, customerVO);
	}
	
	//삭제
	@DeleteMapping(value="/{idx}")
	public void customerInfoDelete(@PathVariable("idx") int idx) {
		customerService.customerInfoDelete(idx);
	}
	
	
}
