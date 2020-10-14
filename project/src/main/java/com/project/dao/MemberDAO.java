package com.project.dao;

import java.util.List;

import com.project.dto.MemberDTO;
//�ڽ�Ŭ������ �����ؾ� �ϴ� �޼ҵ带 ����
public interface MemberDAO {
	//��ü��ȸ
	public List<MemberDTO> selectList();
	//�Ѱ���ȸ
	public MemberDTO selectOne(String userid);
	//�߰�
	public int insert(MemberDTO dto);
	//����
	public int update(MemberDTO dto);
	//����
	public int delete(String userid);
	//�н����� ����
	public int updatePw(MemberDTO dto);
	
}
