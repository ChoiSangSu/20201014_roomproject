package com.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.project.dto.RoommasterDTO;

public interface RoomService {
	
	//조회
	public List<RoommasterDTO> selectList(String roomid) throws Exception;

	// 추가
	public int insert(RoommasterDTO rdto, List<MultipartFile> rfiles) throws Exception;

	// 삭제
	public int delete(String rnum) throws Exception;
	
	
}
