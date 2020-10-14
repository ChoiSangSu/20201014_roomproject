package com.project.dao;

import java.util.List;

import com.project.dto.RfileDTO;

public interface RfileDAO {

		//�߰�
		public int insert(RfileDTO rdto) throws Exception;
		//����
		public int update(RfileDTO rdto) throws Exception;
		//����
		public int delete(int rnum) throws Exception;
		//������ȸ
		public List<RfileDTO> selectList(String roomid) throws Exception;
		
		
}
