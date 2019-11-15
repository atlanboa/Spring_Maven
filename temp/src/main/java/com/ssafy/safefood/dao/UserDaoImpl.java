package com.ssafy.safefood.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.safefood.vo.UserVO;

@Repository
public class UserDaoImpl implements UserDao{
	
	private final String ns = "UserMapper.";
	
	@Autowired
	private SqlSession session;

	@Override
	public void insertUser(UserVO user) throws Exception {
		session.insert(ns+"insertUser", user);
	}

	@Override
	public void updateUser(UserVO user) throws Exception {
		session.update(ns+"updateUser", user);
	}

	@Override
	public void deleteUser(UserVO user) throws Exception {
		session.update(ns+"deleteUser", user);
	}

	@Override
	public UserVO login(UserVO user) throws Exception {
		return session.selectOne(ns+"login", user);		
	}
	
}
