package com.project.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.dto.RfileDTO;

@Repository
public class RfileDAOImpl implements RfileDAO{

	@Resource
		private SqlSession session;

	@Override
	public int insert(RfileDTO rdto) throws Exception {
		return session.insert("rfileMapper.insert",rdto);
	}

	@Override
	public int update(RfileDTO rdto) throws Exception {
		return session.update("rfileMapper.update",rdto);
	}

	@Override
	public int delete(int rnum) throws Exception {
		return session.delete("rfileMapper.delete",rnum);
	}

	@Override
	public List<RfileDTO> selectList(String roomid) throws Exception {
		
		return session.selectList("rfileMapper.selectList", roomid);
	}
}
