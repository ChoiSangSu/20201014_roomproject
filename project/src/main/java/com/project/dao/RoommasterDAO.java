package com.project.dao;

import java.util.List;

import com.project.dto.RoommasterDTO;

public interface RoommasterDAO {
	//�߰�
	public int insert(RoommasterDTO rdto) throws Exception;
	//����
	public int update(RoommasterDTO rdto) throws Exception;
	//����
	public int delete(String roomid) throws Exception;
	//��ȸ
	public List<RoommasterDTO> selectList(String roomid) throws Exception;
}
