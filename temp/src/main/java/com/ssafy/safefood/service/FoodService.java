package com.ssafy.safefood.service;

import java.util.List;

import com.ssafy.safefood.vo.FoodVO;

public interface FoodService {
	List<FoodVO> selectByFoodName(String name) throws Exception;
	List<FoodVO> selectByFoodMaker(String maker) throws Exception;
	List<FoodVO> selectByFoodMaterial(String material) throws Exception;
	FoodVO selectByFoodCode(String code) throws Exception;
}
