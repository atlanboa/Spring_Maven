package com.ssafy.safefood.dao;


import com.ssafy.safefood.vo.UserVO;

public interface UserDao {
	void insertUser(UserVO user) throws Exception;
	void updateUser(UserVO user) throws Exception;
	void deleteUser(UserVO user) throws Exception;
	UserVO login(UserVO user) throws Exception;
}
