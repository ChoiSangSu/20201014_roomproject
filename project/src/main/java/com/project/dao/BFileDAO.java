package com.project.dao;

import java.util.List;

import com.project.dto.BFileDTO;

public interface BFileDAO {
	//������ȸ
	public List<BFileDTO> selectList(int bnum) throws Exception;
	//�߰�
	public int insert(BFileDTO fdto) throws Exception;
	//����
	public int update(BFileDTO fdto) throws Exception;
	//����
	public int delete(int bnum) throws Exception;
	//������ �Ϻ����� ����
	public int delete_part(int bnum, String fnums);
	//���ν��� �׽�Ʈ
	public int procTest(BFileDTO fdto) throws Exception;
}