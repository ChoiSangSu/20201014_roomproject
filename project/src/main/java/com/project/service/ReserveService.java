package com.project.service;

import java.util.List;

import com.project.dto.ReserveDTO;

public interface ReserveService {
	
    	//조회
		public List<ReserveDTO> selectList(String userid) throws Exception;

		// 추가
		public int insert(ReserveDTO redto) throws Exception;

		// 삭제
		public int delete(String rnum) throws Exception;
		
}
