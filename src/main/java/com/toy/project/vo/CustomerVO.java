package com.toy.project.vo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name="tb_customer_info")	//@Entity는 JPA가 관리하는 클래스를 명시한다. 테이블과 매핑
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomerVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idx;
	String customerId;
	String customerPw;
	String customerName;
	String customerAge;
	String customerPhonenum;
	String customerAddr;
	@CreationTimestamp
	LocalDateTime registDt;
	@UpdateTimestamp
	LocalDateTime updateDt;
	
	@Builder
	public CustomerVO(String customerId, String customerPw, String customerName, String customerAge, String customerPhonenum, String customerAddr) {
		this.customerId = customerId;
		this.customerPw = customerPw;
		this.customerName = customerName;
		this.customerAge = customerAge;
		this.customerPhonenum = customerPhonenum;
		this.customerAddr = customerAddr;
	}
}
