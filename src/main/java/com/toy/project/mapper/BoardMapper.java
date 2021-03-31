package com.toy.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.toy.project.vo.BoardVO;

@Mapper
public interface BoardMapper {
	
	//게시판 리스트
	List<BoardVO> boardList();
	
	//게시판 등록
	void insertBoard(BoardVO board);
	
	//게시판 수정
	void updateBoard(BoardVO board);
	
	//게시판 삭제
	void deleteBoard();
}
