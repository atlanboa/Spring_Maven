package com.ssafy.service;

import java.util.List;

import com.ssafy.vo.MyProductVO;

public interface MyProductService {
	void addProduct(MyProductVO vo)throws Exception;
	List<MyProductVO> getProducts(String word) throws Exception;
}
