package com.toy.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.toy.project.vo.UserVO;

@Mapper
public interface UserMapper {
	
	//유저 리스트
  	List<UserVO> userList();
  	
  	//유저 상세조회
    UserVO userInfo(int id);
    
    //유저 수정
    void updateUser(UserVO user);
    
    //유저 등록
    void insertUser(UserVO user);
    
    //유저 삭제
    void deleteUser(int id);
}
