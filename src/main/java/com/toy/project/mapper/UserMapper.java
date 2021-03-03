package com.toy.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.toy.project.vo.UserVO;

@Mapper
public interface UserMapper {
  	List<UserVO> userList();
    UserVO fetchUserByID(int id);
    void updateUser(UserVO user);
    void insertUser(UserVO user);
    void deleteUser(int id);
}
