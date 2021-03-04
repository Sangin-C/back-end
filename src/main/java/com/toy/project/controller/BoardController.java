package com.toy.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toy.project.mapper.BoardMapper;
import com.toy.project.vo.BoardVO;

@RestController
@RequestMapping("/boards")
public class BoardController {

	@Autowired
	BoardMapper boardMapper;
	
	@GetMapping
	public List<BoardVO> boardList(){
		System.out.println(boardMapper.boardList());
        System.out.println("유저리스트 출력 성공");
        return boardMapper.boardList();
	}
}
