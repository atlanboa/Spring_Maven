package com.ssafy.pms.dao;

import java.util.List;

import com.ssafy.pms.dto.Phone;
import com.ssafy.pms.dto.UserInfo;

public interface IPhoneDAO {
	int insert(Phone phone) throws Exception;
	int update(Phone phone) throws Exception;
	int delete(List<String> list) throws Exception;
	//오버로딩 기법
	Phone select(Phone phone) throws Exception;
	List<Phone> select() throws Exception;
	UserInfo select(UserInfo user) throws Exception;//id와 다르게 사용
	
}
