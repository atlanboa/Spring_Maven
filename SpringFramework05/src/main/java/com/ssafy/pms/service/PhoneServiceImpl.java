package com.ssafy.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.pms.dao.IPhoneDAO;
import com.ssafy.pms.dto.Phone;
import com.ssafy.pms.dto.UserInfo;

@Service
public class PhoneServiceImpl implements IPhoneService{

	@Autowired
	private IPhoneDAO dao; 
	
	
	@Override
	public int insert(Phone phone) throws Exception {

		return dao.insert(phone);
	}

	@Override
	public int delete(List<String> list) throws Exception {

		return dao.delete(list);
	}

	@Override
	public Phone select(Phone phone) throws Exception {

		return dao.select(phone);
	}

	@Override
	public List<Phone> select() throws Exception {

		return dao.select();
	}

	@Override
	public UserInfo select(UserInfo user) throws Exception {
		return dao.select(user);
	}

	@Override
	public int update(Phone phone) throws Exception {

		return dao.update(phone);
	}

}
