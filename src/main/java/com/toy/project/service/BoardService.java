package com.toy.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toy.project.repository.BoardRepository;
import com.toy.project.vo.BoardVO;

@Service
public class BoardService {
	
	@Autowired
	BoardRepository boardRepository;
	
	public List<BoardVO> findAll(){
		List<BoardVO> boards = new ArrayList<>();
		boardRepository.findAll().forEach(e -> boards.add(e));
		return boards;
	}
	
}
