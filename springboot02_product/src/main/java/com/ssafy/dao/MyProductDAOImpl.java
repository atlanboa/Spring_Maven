package com.ssafy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.vo.MyProductVO;

@Repository
public class MyProductDAOImpl implements MyProductDAO{
	final String  ns = "ProductMapper.";
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void addProduct(MyProductVO vo) throws Exception {
		sqlSession.insert(ns+"addProduct", vo);
		
	}
	@Override
	public List<MyProductVO> getProducts(String word) throws Exception {
		return sqlSession.selectList(ns+"getProducts", word);
	}

}
