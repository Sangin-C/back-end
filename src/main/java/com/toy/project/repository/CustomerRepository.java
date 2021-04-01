package com.toy.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toy.project.vo.CustomerVO;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerVO, Integer>{
	
}
