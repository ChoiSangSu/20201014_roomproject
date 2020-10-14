package com.project.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.dao.RfileDAO;
import com.project.dto.RfileDTO;

@Service
public class RfileServiceImpl implements RfileService {

	@Resource(name = "saveDir")
	String saveDir;

	@Resource
	private RfileDAO rdao;

	@Override
	public List<String> fileUpload(List<MultipartFile> files) throws Exception {
		List<String> list = new ArrayList<>();
		for (MultipartFile mf : files) {
			// 파일이름 생성
			System.out.println(mf.getOriginalFilename());
			if (mf.getOriginalFilename() != "") { // 파일명이 존재할때만 반복
				String filename = System.currentTimeMillis() + mf.getOriginalFilename();
				// 전송할 파일경로와 이름 생성
				File f = new File(saveDir, filename);
				try {
					mf.transferTo(f);
					list.add(filename); // 파일이름 추가
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	//추가
	@Override
	public int insert(String roomid, List<String> filenameList) throws Exception {
		for (String filename : filenameList) {
			RfileDTO rdto = new RfileDTO();
			rdto.setRoomid(roomid);
			rdto.setFilename(filename);
			rdao.insert(rdto);
		}
		return 0;
	}
	
	//조회
	@Override
	public List<RfileDTO> selectList(String roomid) throws Exception {
		
		return rdao.selectList(roomid);
	}

	//삭제
	@Override
	public int delete(int rnum) throws Exception {
		
		return rdao.delete(rnum);
	}

}
