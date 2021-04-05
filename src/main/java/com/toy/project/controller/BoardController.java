package com.toy.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toy.project.mapper.BoardMapper;
import com.toy.project.vo.BoardVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/boards")
public class BoardController {
	
	@Autowired
	BoardMapper boardMapper;
	
	//게시판 리스트
	@GetMapping
	public List<BoardVO> boardList(){
		log.info("=========== boardList() 실행 ===========");
        System.out.println("게시판 리스트 출력 성공!");
        List<BoardVO> boards = boardMapper.boardList();
        return boards;
	}
	
	//게시판 상세보기
	@GetMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public BoardVO boardInfo(@PathVariable("id") int id) {
		log.info("=========== boardInfo 실행 ===========");
		BoardVO boardVO = boardMapper.boardInfo(id);
		return boardVO;
	}
	
	//게시판 등록
	@PostMapping
	public void boardRegist(@RequestBody BoardVO boardVO){
		log.info("=========== boardRegist() 실행 ===========");
		boardMapper.boardRegist(boardVO);
	}
	
	//게시판 수정
	@PutMapping(value="/{id}")
	public void boardUpdate(@PathVariable("id") int id, @RequestBody BoardVO boardVO) {
		log.info("=========== boardUpdate() 실행 ===========");
		boardMapper.boardUpdate(boardVO);
	}
	
	//게시판 삭제
	@DeleteMapping(value="/{id}")
	public void boardDelete(@PathVariable("id") int id) {
		log.info("=========== boardDelete() 실행 ===========");
		boardMapper.boardDelete(id);
	}
	
}
