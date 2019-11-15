package com.ssafy.spring.service;

import java.sql.SQLException;

import com.ssafy.spring.vo.MemberVO;

public interface MemberService {
	MemberVO loginCheck(MemberVO vo) throws SQLException;
	void add(MemberVO vo) throws Exception;
}
