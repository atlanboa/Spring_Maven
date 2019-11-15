package com.ssafy.pms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.pms.dto.Phone;
import com.ssafy.pms.dto.UserInfo;

@Repository
public class PhoneDAOImpl implements IPhoneDAO{

	private final String ns = "sql.pms.";
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(Phone phone) throws Exception {

		return sqlSession.insert(ns+"insert", phone);
	}

	@Override
	public int delete(List<String> list) throws Exception {
		// 
		return sqlSession.delete(ns+"delete", list);
	}

	@Override
	public Phone select(Phone phone) throws Exception {

		return sqlSession.selectOne(ns+"select", phone);
	}

	@Override
	public List<Phone> select() throws Exception {

		return sqlSession.selectList(ns+"select");
	}

	@Override
	public UserInfo select(UserInfo user) throws Exception {

		return sqlSession.selectOne(ns+"selectUser", user);
	}

	@Override
	public int update(Phone phone) throws Exception {

		return sqlSession.update(ns+"update", phone);
	}

}
