package com.ssafy.safefood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.safefood.dao.FoodDao;
import com.ssafy.safefood.vo.FoodVO;

@Service
public class FoodServiceImpl implements FoodService{

	
	@Autowired
	private FoodDao dao;
	
	@Override
	public List<FoodVO> selectByFoodName(String name) throws Exception {
		return dao.selectByFoodName(name);
	}

	@Override
	public List<FoodVO> selectByFoodMaker(String maker) throws Exception {
		return dao.selectByFoodMaker(maker);
	}

	@Override
	public List<FoodVO> selectByFoodMaterial(String material) throws Exception {
		return dao.selectByFoodMaterial(material);
	}

	@Override
	public FoodVO selectByFoodCode(String code) throws Exception {
		return dao.selectByFoodCode(code);
	}

}
