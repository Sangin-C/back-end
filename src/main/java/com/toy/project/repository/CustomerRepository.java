package com.toy.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toy.project.vo.CustomerVO;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerVO, Integer>{
	
	//고객 전체 리스트
	public List<CustomerVO> findAll();
	
}
