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
		// ���̵� �ߺ� üũ
		// ���强���ϸ� result :0, ���� result :1
		MemberDTO rdto = dao.selectOne(dto.getUserid());

		if (rdto == null) { // ���� ���̵� ������
			// ��ȣȭ ó��
			dto.setPasswd(encode.encode(dto.getPasswd())); // �򹮾�ȣ�� ��ȣ������ ����
			logger.info("dto:" + dto);

			// db�� ����
			int cnt = dao.insert(dto);
			logger.info(String.valueOf(cnt));
			msg = "ȸ������ �Ϸ�";
			result = 0;

		} else { // ���̵� ����
			msg = "���̵� �����մϴ�.";
			result = 1;
		}
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("msg", msg);
		resultMap.put("result", result);

		return resultMap;
	}

	// ȸ����ȸ
	@Override
	public MemberDTO selectOne(String userid) {
		return dao.selectOne(userid);
	}

	// �н����� ��ġ ���� üũ
	@Override
	public int passCheck(String userid, String oldpasswd) {
		MemberDTO dto = dao.selectOne(userid);
		String msg = null;
		int result = -1;
		if (encode.matches(oldpasswd, dto.getPasswd())) { // �н����� ��ġ
			result = 0;
		} else { // �н����� ����ġ
			result = 1;
		}

		return result;

	}

}
