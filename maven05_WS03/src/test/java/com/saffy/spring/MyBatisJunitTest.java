package com.saffy.spring;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.ssafy.spring.vo.BookVO;
import com.ssafy.spring.vo.MemberVO;

/*
 * a class for MyBatis Framework Unit Test
 * 가장 중요한 단위테스트
 */
public class MyBatisJunitTest {
	
	@Test
	public void unit() throws Exception{
		Reader r  = Resources.getResourceAsReader("mybatis/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
//		MyProductVO pvo = new MyProductVO("손빨래 세탁기", "엘지", 56000);
//		int result = session.insert("ProductMapper.addProduct", pvo);
//		session.commit();
//		
//		System.out.println("Product Insert ok");
//		System.out.println(pvo.getId()+" "+pvo.getName());
		
//		BookVO pvo = new BookVO("1235-123-123", "Test", "TestCat", "TestCountry", "1993-06-30", "TestPublisher", "TestAuthor", 10000, "원", "TestDesc");
//		session.insert("BookMapper.insertBook", pvo);
//		session.commit();
//		
//		System.out.println(pvo);

//		List<BookVO> list = session.selectList("BookMapper.searchByPrice", 20000+"");
//		for(BookVO vo : list) {
//			System.out.println(vo);
//		}		
		
		MemberVO pvo = new MemberVO("test", "test", "test", "testNick", "test@test.com", "testhomeP", "test street", "test test2".split(" "));
//		session.insert("MemberMapper.add", pvo);
//		session.commit();
//		System.out.println(pvo);
		
		MemberVO rvo = session.selectOne("MemberMapper.loginCheck", pvo);
		System.out.println(rvo);
		
		
	}
}
