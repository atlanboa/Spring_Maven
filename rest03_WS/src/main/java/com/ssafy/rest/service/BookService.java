package com.ssafy.rest.service;

import java.util.List;

import com.ssafy.rest.vo.BookVO;

public interface BookService {
	
	boolean insertBook(BookVO vo) throws Exception;
	public List<BookVO> getAllBooks() throws Exception;
	List<BookVO> searchByTitle(String word) throws Exception;
	List<BookVO> searchByPublisher(String word) throws Exception;
	List<BookVO> searchByPrice(int price) throws Exception;
	BookVO getBook(String word) throws Exception;
	boolean deleteBook(String word) throws Exception;
	BookVO getIsbn(String word) throws Exception;
	boolean updateBook(BookVO vo) throws Exception;
}
