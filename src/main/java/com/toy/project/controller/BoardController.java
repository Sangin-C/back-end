package com.toy.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toy.project.mapper.BoardMapper;
import com.toy.project.vo.BoardVO;
import com.toy.project.vo.UserVO;

@RestController
@RequestMapping("/boards")
public class BoardController {

	@Autowired
	BoardMapper boardMapper;
	
	@GetMapping
	public List<BoardVO> boardList(){
		System.out.println(boardMapper.boardList());
        System.out.println("게시판 리스트 출력 성공");
        return boardMapper.boardList();
	}
	
	@PostMapping
    void insertBoard(@RequestBody BoardVO board) {
        boardMapper.insertBoard(board);
        System.out.println("게시판 DB 저장 성공");
    }
	
	
}
