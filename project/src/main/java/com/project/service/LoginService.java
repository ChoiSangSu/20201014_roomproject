package com.project.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.dao.MemberDAO;
import com.project.dto.MemberDTO;

@Service
public class LoginService {
	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);
	
	@Resource
	private MemberDAO dao;
	@Resource
	private BCryptPasswordEncoder encode;
	
	public Map<String, Object> loginCheck(String userid, String passwd) {
		//result : 0(�α��μ���), 1(���̵������), 2(�н��������ġ)
		logger.debug(userid);
		String msg = null;
		int result = -1;
		MemberDTO mdto = dao.selectOne(userid);
		System.out.println(mdto);
		if (mdto == null) { //���̵� ����
			msg = "���̵� �����ϴ�.";
			result = 1;
		}else {
			//���� ��ȣȭ��Ų ���� db�� ����� ��ȣ���� ��
			if (encode.matches(passwd, mdto.getPasswd())) {
				msg = "�α��� ����";
				result = 0;
			}else {
				msg = "�н����尡 ����ġ";
				result = 2;
			}
		}
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("msg", msg);
		resultMap.put("result", result);
		return resultMap;
		
	}
}
