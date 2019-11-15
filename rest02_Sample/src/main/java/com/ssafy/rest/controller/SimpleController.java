package com.ssafy.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.rest.vo.Person;

@RestController
@RequestMapping("/sample")
public class SimpleController {

	//1. 단순 문자열을 반환하는 경우
	//http://localhost:8888/rest/sample/hello
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello Rest";
	}
	//2. 객체를 반환하는 경우.. JSON으로 변환이 필ㅇ.. 라이브러리 json-databind를 추가
	@GetMapping("/hello2")
	public Person sayHello2() {
		Person p = new Person();
		p.setName("길동이");
		p.setAddr("여의도");
		return p;
	}
	
	//3. 리스트를 반환하는 경우... 실제로 가장 많이 반환되는 타입이다. service.getAllEmployee
	@GetMapping("/allPerson")
	public List<Person>  sayAllPerson(){
		
		List<Person> list = new ArrayList<Person>();
		for(int i=0; i<3; i++) {
			
			Person p = new Person();
			p.setName("동이"+i);
			p.setAddr("여의도 "+i);
			list.add(p);
		}
		return list;
	}
	
	//4. Map을 반환하는 경우
	@GetMapping("/sendGreet")
	public Map<Integer, Person> sendGreet(){
		Map<Integer, Person> map = new HashMap<Integer, Person>();
		for(int i=0; i<3; i++) {
			
			Person p = new Person();
			p.setName("동이"+i);
			p.setAddr("여의도 "+i);
			map.put(i, p);
		}
		return map;
	}
	
	
}
