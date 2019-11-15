package com.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.MemberDAO;
import com.ssafy.model.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	
	@Override
	public void registerMember(MemberVO vo) throws Exception {
		memberDAO.registerMember(vo);
		
	}

	@Override
	public Object idcheck(String id) throws Exception {
		return memberDAO.idcheck(id);
	}

	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		return memberDAO.login(vo);
	}

	@Override
	public void updateMember(MemberVO vo) throws Exception {
		memberDAO.updateMember(vo);
	}

	@Override
	public List<MemberVO> findByAddress(String address) throws Exception {
		return memberDAO.findByAddress(address);
	}

	@Override
	public List<String> getAddressKind() throws Exception {
		return memberDAO.getAddressKind();
	}

	@Override
	public List<MemberVO> getAllMember() throws Exception {
		return memberDAO.getAllMember();
	}

}
