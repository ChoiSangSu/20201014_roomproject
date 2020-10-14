package com.project.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.dto.RfileDTO;

public interface RfileService {

	    //파일 저장하고 파일명을 리턴
		public List<String> fileUpload(List<MultipartFile> filename) throws Exception;
		//파일명 리스트를 입력받아 파일명 저장
		public int insert(String roomid, List<String> filenameList) throws Exception;
		//파일 리스트
		public List<RfileDTO> selectList(String roomid) throws Exception;
		//삭제
		public int delete(int rnum) throws Exception;
	
}
