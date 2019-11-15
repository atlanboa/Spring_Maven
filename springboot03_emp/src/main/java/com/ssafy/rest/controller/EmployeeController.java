package com.ssafy.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.rest.service.EmpService;
import com.ssafy.rest.vo.EmployeeDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
@Api(tags = {"SSAFY HRM"}, description="SSAFY HRM resource API (Test)")
public class EmployeeController {

	@Autowired
	private EmpService service;
	
	@ApiOperation(value = "모든 사원의 정보를 반환한다.", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "인증 오류 입니다"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "URL not found error")
	})
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





















