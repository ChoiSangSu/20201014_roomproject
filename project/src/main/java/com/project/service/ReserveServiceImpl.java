package com.project.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.project.dao.ReserveDAO;
import com.project.dto.ReserveDTO;

@Service
public class ReserveServiceImpl implements ReserveService{

	@Resource
	private ReserveDAO redao;
	
	@Override
	public List<ReserveDTO> selectList(String userid) throws Exception {
		List<ReserveDTO> list = redao.selectList(userid);
		return list;
	}

	@Override
	public int insert(ReserveDTO redto) throws Exception {
		int cnt = redao.insert(redto);
		return cnt;
	}

	@Override
	public int delete(String rnum) throws Exception {
		int cnt = redao.delete(rnum);
		return cnt;
	}

}
