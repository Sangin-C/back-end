package com.toy.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toy.project.vo.BoardVO;

@Repository
public interface BoardRepository extends JpaRepository<BoardVO, Integer>{
	
	public List<BoardVO> findAll();

}
