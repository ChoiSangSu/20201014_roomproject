package com.project.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.dto.ReserveDTO;

@Repository
public class ReserveDAOImpl implements ReserveDAO {

	@Resource
	private SqlSession session;
	
	@Override
	public int insert(ReserveDTO redto) throws Exception {
		return session.insert("reserveMapper.insert",redto);
	}

	@Override
	public int delete(String rnum) throws Exception {
		return session.delete("reserveMapper.delete",rnum);
	}

	@Override
	public List<ReserveDTO> selectList(String userid) throws Exception {
		return session.selectList("reserveMapper.select",userid);
		
	}

}
