package com.ssafy.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.rest.dao.BookDAO;
import com.ssafy.rest.vo.BookVO;
@Service
public class BookServiceImpl implements BookService{

	
	@Autowired
	private BookDAO bookDAO;
	
	@Override
	public boolean insertBook(BookVO vo) throws Exception {
		return bookDAO.insertBook(vo);
	}

	@Override
	public List<BookVO> getAllBooks() throws Exception {

		return bookDAO.getBooks();
	}

	@Override
	public List<BookVO> searchByTitle(String word) throws Exception {

		return bookDAO.searchByTitle(word);
	}

	@Override
	public List<BookVO> searchByPublisher(String word) throws Exception {
		
		return bookDAO.searchByPublisher(word);
	}

	@Override
	public List<BookVO> searchByPrice(int price) throws Exception {

		return bookDAO.searchByPrice(price);
	}

	@Override
	public BookVO getBook(String word) throws Exception {

		return bookDAO.searchByIsbn(word);
	}
	
	@Override
	public boolean deleteBook(String word) throws Exception {
		return bookDAO.delete(word);
		
	}

	@Override
	public BookVO getIsbn(String word) throws Exception {
		// TODO Auto-generated method stub
		return bookDAO.getIsbn(word);
	}

	@Override
	public boolean updateBook(BookVO vo) throws Exception {
		return bookDAO.update(vo);
		
	}

}
