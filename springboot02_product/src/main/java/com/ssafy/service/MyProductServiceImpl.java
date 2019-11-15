package com.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.MyProductDAO;
import com.ssafy.vo.MyProductVO;

@Service
public class MyProductServiceImpl implements MyProductService{
	
	@Autowired
	private MyProductDAO myProductDAO;
	
	@Override
	public void addProduct(MyProductVO vo) throws Exception {
		myProductDAO.addProduct(vo);		
	}
	@Override
	public List<MyProductVO> getProducts(String word) throws Exception {
		return myProductDAO.getProducts(word);
	}
}
