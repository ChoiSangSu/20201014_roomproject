package com.project.dao;


import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.dto.RoommasterDTO;

@Repository
public class RoommasterDAOImpl implements RoommasterDAO{
	
	@Resource
	private SqlSession session;

	@Override
	public int insert(RoommasterDTO rdto) throws Exception {
		return session.insert("roommasterMapper.insert",rdto) ;
	}

	@Override
	public int update(RoommasterDTO rdto) throws Exception {
		return session.update("roommasterMapper.update",rdto);
	}

	@Override
	public int delete(String roomid) throws Exception {
		return session.delete("roommasterMapper.delete",roomid);
	}

	@Override
	public List<RoommasterDTO> selectList(String roomid) throws Exception {
	
		return session.selectList("roommasterMapper.selectList",roomid);
	}
	
	

}
