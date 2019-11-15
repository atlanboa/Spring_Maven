package com.ssafy.rest.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.rest.domain.Greet;

@RestController
public class SampleController {
//	추가
	private static final String template = "Hello %s!!!";
	private static final AtomicLong counter = new AtomicLong();
	
//	@RequestMapping("/hello")
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String sayHello() {
		return "Hello RestfulAPI!!!";
	}
	
	@GetMapping("/greet")
	public Greet sayGreet() {
		Greet vo = new Greet(1029L, "Hi Good Morning!!");
		return vo;
	}
	
	
	//http://127.0.0.1:8888/rest/greet2/200
	@GetMapping("/greet2/{id}")
	public String sayGreet2(@PathVariable int id) {
		return "Hello Greet2";
	}
	
//	http://localhost:8888/rest/greet3?name=%EC%9D%B4%EB%A6%84
//	@GetMapping("/greet3")
//	public Greet sayGreet3(@RequestParam String name) {
//		return new Greet(234L, "방가방가");
//	}
	
	@GetMapping("/greet3")
	public Greet sayGreet3(@RequestParam(value="name", required=false, defaultValue="world") String name) {
		return new Greet(counter.incrementAndGet(), String.format(template, name));
	}
}
