package com.ssafy.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.rest.service.BookService;
import com.ssafy.rest.vo.BookVO;

@RestController
//@RequestMapping("/api")
public class RestApiController{
	
//	final String logger = "";
//	final String OK = "";
//	final String FAIL = "";
	
	@Autowired
	private BookService service;
	
	
	@GetMapping("/getAllBooks")
	public ResponseEntity<List<BookVO>> getAllbooks() throws Exception{
		System.out.println("getAllBooks 진입");
		List<BookVO> books = service.getAllBooks();
		for(BookVO vo: books) {
			System.out.println(vo);
		}
		if(books.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(books, HttpStatus.OK);
	}
	
	@GetMapping("/getBook/{isbn}")
	public ResponseEntity<BookVO> getBook(@PathVariable String isbn) throws Exception{
		BookVO book = service.getBook(isbn);
		if(book==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(book, HttpStatus.OK);
	}
	
	@PostMapping("/insertBook")
	public ResponseEntity insertBook(@RequestBody BookVO book) throws Exception{
		System.out.println("insertBook");
		boolean result = service.insertBook(book);
		
		System.out.println(book);
		if(!result) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(HttpStatus.OK);
	}
	
	@PostMapping("/updateBook")
	public ResponseEntity updateBook(@RequestBody BookVO book) throws Exception{	
		System.out.println("update book");
		boolean result = service.updateBook(book);
		if(!result) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping("/deleteBook/{isbn}")
	public ResponseEntity deleteBook(@PathVariable String isbn) throws Exception{
		boolean result = service.deleteBook(isbn);
		if(!result) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(HttpStatus.OK);
	}
	
}
