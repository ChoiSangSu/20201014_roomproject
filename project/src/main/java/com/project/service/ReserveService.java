package com.project.service;

import java.util.List;

import com.project.dto.ReserveDTO;

public interface ReserveService {
	
    	//��ȸ
		public List<ReserveDTO> selectList(String userid) throws Exception;

		// �߰�
		public int insert(ReserveDTO redto) throws Exception;

		// ����
		public int delete(String rnum) throws Exception;
		
}
