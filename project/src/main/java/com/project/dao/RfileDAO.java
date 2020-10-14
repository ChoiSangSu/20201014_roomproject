package com.project.dao;

import java.util.List;

import com.project.dto.RfileDTO;

public interface RfileDAO {

		//추가
		public int insert(RfileDTO rdto) throws Exception;
		//수정
		public int update(RfileDTO rdto) throws Exception;
		//삭제
		public int delete(int rnum) throws Exception;
		//파일조회
		public List<RfileDTO> selectList(String roomid) throws Exception;
		
		
}
