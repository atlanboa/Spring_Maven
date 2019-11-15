package com.ssafy.safefood.service;

import com.ssafy.safefood.vo.UserVO;

public interface UserService {
	void insertUser(UserVO user) throws Exception;
	void updateUser(UserVO user) throws Exception;
	void deleteUser(UserVO user) throws Exception;
	UserVO login(UserVO user) throws Exception;
}
