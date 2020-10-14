package com.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.project.dto.RoommasterDTO;

public interface RoomService {
	
	//��ȸ
	public List<RoommasterDTO> selectList(String roomid) throws Exception;

	// �߰�
	public int insert(RoommasterDTO rdto, List<MultipartFile> rfiles) throws Exception;

	// ����
	public int delete(String rnum) throws Exception;
	
	
}
