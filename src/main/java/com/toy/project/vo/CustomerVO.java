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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter	//가장많이 사용되는 어노테이션..자동으로 getXxx() setXxx() 메소드를 생성해준다.
@ToString(exclude = "idx")	//toString() 메소드를 자동으로 생성해준다. exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외시킬수 있다.
@Entity(name="tb_customer_info")	//@Entity는 JPA가 관리하는 클래스를 명시한다. 테이블과 매핑 (테이블 명을 명시해야한다)
@NoArgsConstructor(access = AccessLevel.PRIVATE)	//@@NoArgsConstructor는 파라미터가 없는 기본 생성자를 생성한다. EX) CustomerVO cutomer = new CustomerVO();
// @Data 어노테이션을 사용하면 모든 설정을 한꺼번에 자동으로 주입해준다. 하지만 쓰이지않는 설정들이 들어있을수 있으니 어노테이션을 따로 설정해주는것이 좋다.
public class CustomerVO {

	@Id //@Id를 사용하여 기본키(PK)로 지정 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Table생성시 id를 AUTO_INCREMENT로 설정하였기떄문에 자동으로 생성되도록 @GeveratedValue를 사용
	Long idx;
	private String customerId;
	private String customerPw;
	private String customerName;
	private int customerAge;
	private String customerPhonenum;
	private String customerAddr;
	@CreationTimestamp
	private LocalDateTime registDt;
	@UpdateTimestamp
	private LocalDateTime updateDt;
	
	@Builder
	public CustomerVO(String customerId, String customerPw, String customerName, int customerAge, String customerPhonenum, String customerAddr) {
		this.customerId = customerId;
		this.customerPw = customerPw;
		this.customerName = customerName;
		this.customerAge = customerAge;
		this.customerPhonenum = customerPhonenum;
		this.customerAddr = customerAddr;
	}
}
