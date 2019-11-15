package com.ssafy.safefood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.safefood.service.FoodService;
import com.ssafy.safefood.service.UserService;

@RestController
public class RestAPIController {

	@Autowired
	private FoodService foodService;
	
	@Autowired
	private UserService userService;
	
	
	
	
}
