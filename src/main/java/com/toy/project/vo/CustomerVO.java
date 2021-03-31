package com.toy.project.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name="TB_CUSTOMER_INFO")	//@Entity는 JPA가 관리하는 클래스를 명시한다. 테이블과 매핑
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomerVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int IDX;
	String customerId;
	String customerPw;
	String customerName;
	String customerAge;
	String customerPhonenum;
	String customerAddr;
	String registDt;
	String updateDt;
	
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
