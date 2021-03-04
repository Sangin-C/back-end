package com.toy.project.vo;

import lombok.Data;

@Data
public class BoardVO {
	
	int id;
	String title;
	String username;
	String contents;
	String createdate;
	String updatedate;
	int likes;
	int counts;
	
}
