package com.project.dao;

import java.util.List;

import com.project.dto.RoommasterDTO;

public interface RoommasterDAO {
	//추가
	public int insert(RoommasterDTO rdto) throws Exception;
	//수정
	public int update(RoommasterDTO rdto) throws Exception;
	//삭제
	public int delete(String roomid) throws Exception;
	//조회
	public List<RoommasterDTO> selectList(String roomid) throws Exception;
}
