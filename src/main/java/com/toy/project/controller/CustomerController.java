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

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	//리스트
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE }) //JSON 타입만 리턴하겠다는것임.
	//ResponseEntity는 개발자가 결과 데이터와 HTTP 상태 코드를 직접 제어할수 있는 클래스이다.
	//개발자는 404나 500같은 HTTP 상태모드를 전송하고 싶은 데이터와 함께 전송할수 있기 때문에 좀더 세밀한 제어가 필요한 경우 사용할 수 있다. 
	public ResponseEntity<List<CustomerVO>> customerList(){
		log.info("=========== customerList() 실행 ===========");
		List<CustomerVO> customerList = customerService.customerList();
		return new ResponseEntity<List<CustomerVO>>(customerList, HttpStatus.OK);
	}
	
	//상세조회
	@GetMapping(value= "/{idx}", 
			produces = { MediaType.APPLICATION_JSON_VALUE }) //JSON 타입만 리턴하겠다는것임.
	public ResponseEntity<CustomerVO> customerInfo(@PathVariable("idx") Long idx){
		log.info("=========== customerInfo() 실행 ===========");
		Optional<CustomerVO> customer = customerService.customerInfo(idx);
		return new ResponseEntity<CustomerVO>(customer.get(), HttpStatus.OK);
	}
	
	//등록
	@PostMapping
	public ResponseEntity<Void> customerRegist(@RequestBody CustomerVO customerVO){
		log.info("=========== customerRegist() 실행 ===========");
		customerService.customerRegist(customerVO);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	//수정
	@PutMapping(value="/{idx}")
	public ResponseEntity<Void> customerUpdate(@PathVariable("idx") Long idx, @RequestBody CustomerVO customerVO){
		log.info("=========== customerUpdate() 실행 ===========");
		customerService.customerUpdate(idx, customerVO);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	//삭제
	@DeleteMapping(value="/{idx}")
	public ResponseEntity<Void> customerInfoDelete(@PathVariable("idx") Long idx) {
		log.info("=========== customerDelete() 실행 ===========");
		customerService.customerInfoDelete(idx);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
