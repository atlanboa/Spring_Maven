package com.ssafy.rest.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.ssafy.rest.vo.BookVO;

public class MyBatisJUnitTest {

	@Test
	public void unit() throws Exception{
		Reader r = Resources.getResourceAsReader("sql/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		List<BookVO> list = session.selectList("BookMapper.getBooks");
		
		for(BookVO rvo:list) {
			System.out.println(rvo);
		}
		
	}
	
}
