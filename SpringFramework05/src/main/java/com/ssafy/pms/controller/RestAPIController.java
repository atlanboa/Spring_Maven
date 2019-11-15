package com.ssafy.pms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.pms.dto.Phone;
import com.ssafy.pms.service.IPhoneService;

@RestController
public class RestAPIController {

	@Autowired
	private IPhoneService service;
	
	@GetMapping("/phone")
	public ResponseEntity<List<Phone>> select(){
		try {
			List<Phone> selected = service.select();
			return new ResponseEntity(selected, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/phone")
	public ResponseEntity insert(@RequestBody Phone phone){
		try {
			service.insert(phone);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@PutMapping("/phone")
	public ResponseEntity update(@RequestBody Phone phone){
		try {
//			System.out.println(phone);
			service.update(phone);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(phone);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/phone/{num}")
	public ResponseEntity<Phone> select(@PathVariable String num){
		try {
			Phone phone = new Phone();
			phone.setNum(num);
			Phone selected = service.select(phone);
			return new ResponseEntity(selected, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/phone")
	public ResponseEntity delete(@RequestBody Phone phone) {
		try {
			List<String> list = new ArrayList<>();
			list.add(phone.getNum());
			service.delete(list);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_MODIFIED);
		}
		
	}
	
}
