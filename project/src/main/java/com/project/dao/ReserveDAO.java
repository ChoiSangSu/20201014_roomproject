package com.project.dao;

import java.util.List;

import com.project.dto.ReserveDTO;

public interface ReserveDAO {
	
		//�߰�
		public int insert(ReserveDTO redto) throws Exception;
		//����
		public int delete(String rnum) throws Exception;
		//��ȸ	
		public List<ReserveDTO> selectList(String userid) throws Exception; 
}
