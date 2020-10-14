package com.project.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.dao.MemberDAO;
import com.project.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Resource
	private MemberDAO dao;

	@Resource
	private BCryptPasswordEncoder encode;

	@Override
	public Map<String, Object> insert(MemberDTO dto) {
		String msg = null;
		int result = -1;
		// 아이디 중복 체크
		// 저장성공하면 result :0, 실패 result :1
		MemberDTO rdto = dao.selectOne(dto.getUserid());

		if (rdto == null) { // 기존 아이디 미존재
			// 암호화 처리
			dto.setPasswd(encode.encode(dto.getPasswd())); // 평문암호를 암호문으로 변경
			logger.info("dto:" + dto);

			// db에 저장
			int cnt = dao.insert(dto);
			logger.info(String.valueOf(cnt));
			msg = "회원가입 완료";
			result = 0;

		} else { // 아이디 존재
			msg = "아이디가 존재합니다.";
			result = 1;
		}
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("msg", msg);
		resultMap.put("result", result);

		return resultMap;
	}

	// 회원조회
	@Override
	public MemberDTO selectOne(String userid) {
		return dao.selectOne(userid);
	}

	// 패스워드 일치 여부 체크
	@Override
	public int passCheck(String userid, String oldpasswd) {
		MemberDTO dto = dao.selectOne(userid);
		String msg = null;
		int result = -1;
		if (encode.matches(oldpasswd, dto.getPasswd())) { // 패스워드 일치
			result = 0;
		} else { // 패스워드 불일치
			result = 1;
		}

		return result;

	}

}
