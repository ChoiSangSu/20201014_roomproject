package com.project.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.service.LoginService;

@Controller
@RequestMapping("login")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Resource
	private LoginService service;

	// �α��� üũ
	@RequestMapping(value = "/")
	public String login(String userid, String passwd, HttpSession session, RedirectAttributes rattr) {
		logger.info(userid + " " + passwd);
		Map<String, Object> resultMap = service.loginCheck(userid, passwd);
		logger.debug(resultMap.toString());
		// ������ �޽��� ȭ�鿡 ����
		rattr.addFlashAttribute("msg", resultMap.get("msg"));
		int result = (int) resultMap.get("result");
		// redirect : ȭ���̵� �ּ� �̵�(@RequestMapping�� ���� �̵�������)
		if (result == 0) { // �α��� ������
			session.setAttribute("userid", userid); // ���ǿ� ���̵� ����
			session.setMaxInactiveInterval(60 * 60 * 2);
			
			return "redirect:/main/";
		} else {
			return "redirect:/login/";
		}
		
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session, RedirectAttributes rattr) {
		session.invalidate(); // �������� �Ҹ�
		rattr.addFlashAttribute("msg", "�α׾ƿ��Ǿ����ϴ�.");
		return "redirect:/main/";
	}
}