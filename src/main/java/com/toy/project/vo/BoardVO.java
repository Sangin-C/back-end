package com.toy.project.vo;

import lombok.Data;

@Data
public class BoardVO {
	
	private int id;
	private String title;
	private String username;
	private String contents;
	private String createdate;
	private String updatedate;
	private int likes;
	private int counts;

}
