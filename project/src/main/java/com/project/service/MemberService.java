package com.project.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.project.dto.MemberDTO;

public interface MemberService {
	public Map<String, Object> insert(MemberDTO dto);
	public MemberDTO selectOne(String userid);
	public int passCheck(String userid, String oldpasswd);
}
