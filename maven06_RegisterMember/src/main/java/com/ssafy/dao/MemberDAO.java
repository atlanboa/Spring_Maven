package com.ssafy.dao;

import java.util.List;

import com.ssafy.model.MemberVO;

public interface MemberDAO {

	void registerMember(MemberVO vo) throws Exception;
	Object idcheck(String id) throws Exception;
	MemberVO login(MemberVO vo) throws Exception;
	void updateMember(MemberVO vo) throws Exception;
	List<MemberVO> findByAddress(String address) throws Exception;
	List<String> getAddressKind() throws Exception;
	List<MemberVO> getAllMember() throws Exception;
	
	
}
