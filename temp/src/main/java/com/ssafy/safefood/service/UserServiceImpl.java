package com.ssafy.safefood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.safefood.dao.UserDao;
import com.ssafy.safefood.vo.UserVO;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserDao dao;
	
	
	@Override
	public void insertUser(UserVO user) throws Exception {
		dao.insertUser(user);
	}

	@Override
	public void updateUser(UserVO user) throws Exception {
		dao.updateUser(user);
	}

	@Override
	public void deleteUser(UserVO user) throws Exception {
		dao.deleteUser(user);
	}

	@Override
	public UserVO login(UserVO user) throws Exception {
		return dao.login(user);
	}

}
