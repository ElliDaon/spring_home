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

	@Override
	public int memberInsert(MemberVo mv) {
		
		MemberService_Mapper msm = sqlSession.getMapper(MemberService_Mapper.class);
		int value = msm.memberInsert(mv);
		return value;
	}
	
	
}
