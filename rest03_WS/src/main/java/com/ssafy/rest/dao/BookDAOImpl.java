package com.ssafy.rest.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.rest.vo.BookVO;

@Repository
public class BookDAOImpl implements BookDAO {
	final String ns = "BookMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public boolean insertBook(BookVO vo) throws Exception{	
		int result = sqlSession.insert(ns+"insertBook", vo);
		if(result > 0) return true;
		else return false;
	}
	
	/* (non-Javadoc)
	 * @see com.ssafy.model.IBookDAO#search()
	 */
	@Override
	public List<BookVO> getBooks() throws Exception{
        List<BookVO> list = sqlSession.selectList(ns+"getBooks");        

        return list;
	}
	/* (non-Javadoc)
	 * @see com.ssafy.model.IBookDAO#searchByTitle(java.lang.String)
	 */
	@Override
	public List<BookVO> searchByTitle(String word) throws Exception{
        List<BookVO> list = sqlSession.selectList(ns+"searchByTitle", word);
        return list;
	}
	/* (non-Javadoc)
	 * @see com.ssafy.model.IBookDAO#searchByPublisher(java.lang.String)
	 */
	@Override
	public List<BookVO> searchByPublisher(String word) throws Exception{

		 List<BookVO> list = sqlSession.selectList(ns+"searchByPublisher", word);        

        return list;
	}
	/* (non-Javadoc)
	 * @see com.ssafy.model.IBookDAO#searchByPrice(int)
	 */
	@Override
	public List<BookVO> searchByPrice(int price) throws Exception{
		List<BookVO> list = sqlSession.selectList(ns+"searchByPrice", price+"");
        return list;
	}
	/* (non-Javadoc)
	 * @see com.ssafy.model.IBookDAO#search(java.lang.String)
	 */
	@Override
	public BookVO searchByIsbn(String word) throws Exception{
        
       BookVO vo = sqlSession.selectOne(ns+"searchByIsbn", word);
        

        return vo;
	}

	/* (non-Javadoc)
	 * @see com.ssafy.model.IBookDAO#delete(java.lang.String)
	 */
	@Override
	public boolean delete(String word) throws Exception{
		int result = sqlSession.delete(ns+"delete", word);
		return result>0?true:false;
	}
	
	
	public BookVO getIsbn(String word) throws Exception{
		
        return sqlSession.selectOne(ns+"getIsbn", word);
	}
	
	public boolean update(BookVO vo) throws Exception{
		return sqlSession.update(ns+"update", vo)>0?true:false;
	}
	
	public static void main(String[] args) throws Exception {
		BookVO b = new BookDAOImpl().searchByIsbn("1233-111-111");
		System.out.println(b);
	}
	
}
