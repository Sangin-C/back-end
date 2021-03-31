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
@Entity(name="BOARDS")	//@Entity는 JPA가 관리하는 클래스를 명시한다. 테이블과 매핑 (테이블 명을 명시해야한다)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardVO {
	
	@Id	//@Id를 사용하여 기본키(PK)로 지정 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//Table생성시 id를 AUTO_INCREMENT로 설정하였기떄문에 자동으로 생성되도록 @GeveratedValue를 사용
	int id;
	String title;
	String username;
	String contents;
	String createdate;
	String updatedate;
	Integer likes;
	Integer counts;
	
	@Builder
	public BoardVO(String title, String username, String contents, String createdate, String updatedate, int likes, int counts) {
		this.title = title;
		this.username = username;
		this.contents = contents;
		this.createdate = createdate;
		this.updatedate = updatedate;
		this.likes = likes;
		this.counts = counts;
	}

}
