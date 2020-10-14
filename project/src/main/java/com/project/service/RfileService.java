package com.project.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.dto.RfileDTO;

public interface RfileService {

	    //���� �����ϰ� ���ϸ��� ����
		public List<String> fileUpload(List<MultipartFile> filename) throws Exception;
		//���ϸ� ����Ʈ�� �Է¹޾� ���ϸ� ����
		public int insert(String roomid, List<String> filenameList) throws Exception;
		//���� ����Ʈ
		public List<RfileDTO> selectList(String roomid) throws Exception;
		//����
		public int delete(int rnum) throws Exception;
	
}
