package com.saffy.spring;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.ssafy.vo.MyProductVO;

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
		List<MyProductVO> list = session.selectList("ProductMapper.getProduct","세탁기");
		for(MyProductVO vo : list) {
			System.out.println(vo);
		}
	}
}
