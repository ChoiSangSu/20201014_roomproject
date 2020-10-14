package com.project.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	@Resource
	private SqlSession session;
	
	//�Ѱ���ȸ
	@Override
	public MemberDTO selectOne(String userid) {
		return session.selectOne("memberMapper.selectOne",userid);
	}
	
	//ȸ���߰�
	@Override
	public int insert(MemberDTO dto) {
		return session.insert("memberMapper.insert",dto);
	}
	
	//ȸ������
	@Override
	public int update(MemberDTO dto) {
		return session.update("memberMapper.update", dto);
	}

	//��ü��ȸ
	@Override
	public List<MemberDTO> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	//����
	@Override
	public int delete(String userid) {
		return session.delete("memberMapper.delete", userid);
	}

	@Override
	public int updatePw(MemberDTO dto) {
		return session.update("memberMapper.updatePw", dto);
	}
	
	
	
	
	
	
}
