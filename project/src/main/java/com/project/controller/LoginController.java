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

	// 로그인 체크
	@RequestMapping(value = "/")
	public String login(String userid, String passwd, HttpSession session, RedirectAttributes rattr) {
		logger.info(userid + " " + passwd);
		Map<String, Object> resultMap = service.loginCheck(userid, passwd);
		logger.debug(resultMap.toString());
		// 서비스의 메시지 화면에 전달
		rattr.addFlashAttribute("msg", resultMap.get("msg"));
		int result = (int) resultMap.get("result");
		// redirect : 화면이동 주소 이동(@RequestMapping에 의한 이동만가능)
		if (result == 0) { // 로그인 성공시
			session.setAttribute("userid", userid); // 세션에 아이디 저장
			session.setMaxInactiveInterval(60 * 60 * 2);
			
			return "redirect:/main/";
		} else {
			return "redirect:/login/";
		}
		
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session, RedirectAttributes rattr) {
		session.invalidate(); // 세션정보 소멸
		rattr.addFlashAttribute("msg", "로그아웃되었습니다.");
		return "redirect:/main/";
	}
}