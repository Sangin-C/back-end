package com.toy.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toy.project.mapper.BoardMapper;
import com.toy.project.service.BoardService;
import com.toy.project.vo.BoardVO;

@RestController
@RequestMapping("/boards")
public class BoardController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BoardService boardService;
	
	@Autowired
	BoardMapper boardMapper;
	
	//JPA를 이용해서 전체 리스트 가져오기
	@GetMapping
	public ResponseEntity<List<BoardVO>> boardList(){
        System.out.println("게시판 리스트 출력 성공!");
        List<BoardVO> boards = boardService.findAll();
        return new ResponseEntity<List<BoardVO>>(boards, HttpStatus.OK);
	}
	
	//Mapper를 이용해서 상세 정보 가져오기
	@GetMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public BoardVO boardInfo(@PathVariable("id") int id) {
		System.out.println("게시판 조회 성공!");
		BoardVO boardVO = boardMapper.boardInfo(id);
		return boardVO;
	}
	
	//JPA를 이용해서 Insert하기
	@PostMapping
	public void boardRegist(@RequestBody BoardVO boardVO){
		System.out.println("게시판 등록 성공!");
		boardService.boardRegist(boardVO);
	}
	
	
}
