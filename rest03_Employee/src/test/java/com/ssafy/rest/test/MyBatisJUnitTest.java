package com.ssafy.rest.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.ssafy.restful.vo.EmployeeDto;

public class MyBatisJUnitTest {

	@Test
	public void unit() throws Exception{
		Reader r = Resources.getResourceAsReader("sql/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		List<EmployeeDto> list = session.selectList("EmpMapper.findAllEmployees");
		
		for(EmployeeDto rvo:list) {
			System.out.println(rvo);
		}
		
	}
	
}
