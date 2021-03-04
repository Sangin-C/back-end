package com.toy.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.toy.project.vo.BoardVO;

@Mapper
public interface BoardMapper {
	List<BoardVO> boardList();
}
