package com.project.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.project.dao.RoommasterDAO;
import com.project.dto.RoommasterDTO;

@Service
public class RoomServiceImpl implements RoomService {

	@Resource
	private RoommasterDAO rdao;
	
	@Resource
	private RfileService rservice;
	
	  @Transactional
	  @Override 
	  public int insert(RoommasterDTO rdto, List<MultipartFile> rfiles) throws Exception { 
		  int cnt = rdao.insert(rdto);
		  String roomid = rdto.getRoomid();
		  List<String> filenameList = rservice.fileUpload(rfiles); //파일 추가
		  rservice.insert(roomid, filenameList);
		  return cnt; 
	  }
	 
	@Override
	public int delete(String rnum) throws Exception {
		
		return 0;
	}

	@Override
	public List<RoommasterDTO> selectList(String roomid) throws Exception {
		List<RoommasterDTO> rlist = rdao.selectList(roomid);
		return rlist;
	}

}
