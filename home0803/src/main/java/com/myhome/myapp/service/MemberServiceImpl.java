package com.myhome.myapp.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhome.myapp.domain.MemberVo;
import com.myhome.myapp.persistance.MemberService_Mapper;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	SqlSession sqlSession;
	private MemberService_Mapper msm;
	
	@Autowired
	MemberServiceImpl(SqlSession sqlSession){
		this.msm = sqlSession.getMapper(MemberService_Mapper.class);
	}
	
	@Override
	public int memberInsert(MemberVo mv) {
		int value = msm.memberInsert(mv);
		return value;
	}

	@Override
	public MemberVo memberLogin(String memberId) {
		MemberVo mv = null;
		mv = msm.memberLogin(memberId);
		return mv;
	}
	
	
}
