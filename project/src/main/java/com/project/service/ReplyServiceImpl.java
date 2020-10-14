package com.project.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.BoardDAO;
import com.project.dao.ReplyDAO;
import com.project.dto.ReplyDTO;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Resource
	private ReplyDAO rdao;
	
	@Resource
	private BoardDAO bdao;
	
	@Transactional
	@Override
	public int insert(ReplyDTO rdto) throws Exception{
		//����� �߰� �ɶ� �Խ����� ��� �� +1
		bdao.replycntUp_update(rdto.getBnum());
		return rdao.insert(rdto);
	}

	@Override
	public int update(ReplyDTO rdto) throws Exception{
		// TODO Auto-generated method stub
		return rdao.update(rdto);
	}

    @Transactional
	@Override
	public int delete(int rnum,int bnum) throws Exception{
    	//����� ���� �ɶ� �Խ����� ��� �� -1
    	bdao.replycntDown_update(bnum);
		return rdao.delete(rnum,bnum);
	}

	@Override
	public List<ReplyDTO> selectList(int bnum) throws Exception{
		return rdao.selectList(bnum);
	}

	@Override
	public ReplyDTO selectOne(int rnum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete_bnum(int bnum) throws Exception{
		// �Խù��� ��� ����
		
		bdao.replycntDown_update(bnum);
		return rdao.delete_bnum(bnum);
	}

}
