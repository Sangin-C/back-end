package com.toy.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.toy.project.vo.BoardVO;

@Mapper
public interface BoardMapper {
	
	//게시판 리스트
	List<BoardVO> boardList();
	
	//게시판 상세보기
	BoardVO boardInfo(int id);
	
	//게시판 등록
	void boardRegist(BoardVO board);
	
	//게시판 수정
	void boardUpdate(BoardVO board);
	
	//게시판 삭제
	void boardDelete(int id);
}
