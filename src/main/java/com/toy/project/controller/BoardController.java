package com.toy.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toy.project.service.BoardService;
import com.toy.project.vo.BoardVO;

@RestController
@RequestMapping("/boards")
public class BoardController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BoardService boardService;
	
	@GetMapping
	public ResponseEntity<List<BoardVO>> boardList(){
        System.out.println("게시판 리스트 출력 성공");
        List<BoardVO> boards = boardService.findAll();
        return new ResponseEntity<List<BoardVO>>(boards, HttpStatus.OK);
	}
	
}
