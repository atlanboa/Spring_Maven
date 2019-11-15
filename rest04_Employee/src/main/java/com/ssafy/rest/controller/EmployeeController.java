package com.ssafy.rest.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.rest.service.EmpService;
import com.ssafy.restful.vo.EmployeeDto;

@RestController
//@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmpService service;
	
	@GetMapping("/findAllEmployees")
	public ResponseEntity<List<EmployeeDto>> findAllEmployees() throws Exception{
		List<EmployeeDto> emps=service.findAllEmployees();
		if(emps.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity(emps, HttpStatus.OK);
	}	
	
	@GetMapping("/getEmployeesTotal")
	public ResponseEntity getEmployeesTotal() throws Exception{
		int total=service.getEmployeesTotal();
		if(total==0) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity(total, HttpStatus.OK);
	}
	
	@GetMapping("/findEmployeeById/{id}")
	public ResponseEntity findEmployeeById(@PathVariable int id) throws Exception{
		EmployeeDto emp=service.findEmployeeById(id);
		if(emp==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity(emp, HttpStatus.OK);
	}
	@GetMapping("/findLikeEmployees/{name}")
	public ResponseEntity<List<EmployeeDto>> findLikeEmployees(@PathVariable String name) throws Exception{
		List<EmployeeDto> emps=service.findLikeEmployees(name);
		if(emps.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity(emps, HttpStatus.OK);
	}
	
	@GetMapping("/findEmployeesByManagerId/{manager_id}")
	public ResponseEntity<List<EmployeeDto>> findEmployeesByManagerId(@PathVariable int manager_id) throws Exception{
		List<EmployeeDto> emps=service.findEmployeesByManagerId(manager_id);
		if(emps.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity(emps, HttpStatus.OK);
	}
	
	@PostMapping("/addEmployee")
	public ResponseEntity addEmployee(@RequestBody EmployeeDto dto) throws Exception{
		service.addEmployee(dto);
		return new ResponseEntity(HttpStatus.OK);
	}
	@PutMapping("/updateEmployee")
	public ResponseEntity updateEmployee(@RequestBody EmployeeDto dto) throws Exception{
		boolean result=service.updateEmployee(dto);
		if(!result)return new ResponseEntity(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity(HttpStatus.OK);
	}
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity deleteEmployee(@PathVariable int id) throws Exception{
		boolean result=service.deleteEmployee(id);
		if(!result)return new ResponseEntity(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity(HttpStatus.OK);
	}	
}





















