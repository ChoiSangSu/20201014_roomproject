package com.project.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.project.dto.BFileDTO;

public interface BFileService  {
	//���� �����ϰ� ���ϸ��� ����
	public List<String> fileUpload(List<MultipartFile> files) throws Exception;
	//���ϸ� ����Ʈ�� �Է¹޾� ���ϸ� ����
	public int insert(int bnum, List<String> filenameList) throws Exception;
	//���� ����Ʈ
	public List<BFileDTO> selectList(int bnum) throws Exception;
	//����
	public int delete(int bnum) throws Exception;
	//������ �Ϻ� ���� ����
	public int delete_part(int bnum, List<Integer> fnumList) throws Exception;
	//���� �ٿ�ε�
	public void fileDownload(String filename, HttpServletResponse response) throws Exception;
	
	
}