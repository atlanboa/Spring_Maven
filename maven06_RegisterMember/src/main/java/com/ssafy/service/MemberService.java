package com.ssafy.service;

import java.util.List;

import com.ssafy.model.MemberVO;

public interface MemberService {
	void registerMember(MemberVO vo) throws Exception;
	Object idcheck(String id) throws Exception;
	MemberVO login(MemberVO vo) throws Exception;
	void updateMember(MemberVO vo) throws Exception;
	List<MemberVO> findByAddress(String address) throws Exception;
	List<String> getAddressKind() throws Exception;
	List<MemberVO> getAllMember() throws Exception;
}
