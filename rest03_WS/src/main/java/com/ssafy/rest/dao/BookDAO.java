package com.ssafy.rest.dao;

import java.util.List;

import com.ssafy.rest.vo.BookVO;

public interface BookDAO {

	boolean insertBook(BookVO book) throws Exception;

	List<BookVO> getBooks() throws Exception;

	List<BookVO> searchByTitle(String title) throws Exception;

	List<BookVO> searchByPublisher(String publisher) throws Exception;

	List<BookVO> searchByPrice(int price) throws Exception;

	BookVO searchByIsbn(String isbn) throws Exception;
	
	BookVO getIsbn(String word) throws Exception;

	boolean delete(String isbn) throws Exception;
	boolean update(BookVO vo) throws Exception;
}