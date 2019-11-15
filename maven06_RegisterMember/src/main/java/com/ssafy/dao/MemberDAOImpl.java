package com.ssafy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.model.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{

	final String ns ="MemberMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void registerMember(MemberVO vo) throws Exception {
		sqlSession.insert(ns+"registerMember", vo);
	}

	@Override
	public Object idcheck(String id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ns+"idcheck", id);
	}

	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ns+"login", vo);
	}

	@Override
	public void updateMember(MemberVO vo) throws Exception {
		 sqlSession.update(ns+"updateMember", vo);
		
	}

	@Override
	public List<MemberVO> findByAddress(String address) throws Exception {

		return sqlSession.selectList(ns+"findByAddress", address);
	}

	@Override
	public List<String> getAddressKind() throws Exception {
		// TODO Auto-generated method stub
		return  sqlSession.selectList(ns+"getAddressKind");
	}

	@Override
	public List<MemberVO> getAllMember() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(ns+"getAllMember");
	}

}
