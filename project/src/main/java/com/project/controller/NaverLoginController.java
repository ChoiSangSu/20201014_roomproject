package com.project.controller;

import java.text.ParseException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.service.NaverLoginService;

@Controller
@RequestMapping("/naverlogin")
public class NaverLoginController {

	@Resource
	private NaverLoginService lservice;

	// 네이버 로그인 인증코드 콜백 맵핑
	// code:인증코드 , state : 세션에 저장된 값 (클라이언트 인증을 위한)
	@RequestMapping("/callback")
	public String callback(String code, String state, RedirectAttributes rdattr, HttpSession session)
			throws ParseException, java.text.ParseException, org.json.simple.parser.ParseException {
		System.out.println("code : " + code);
		System.out.println("state : " + state);
		// 세션의 state값과 넘겨받은 state값 일치
		String savestate = (String) session.getAttribute("state");
		if (savestate.equals(state)) {
			Map<String, String> resultmap = lservice.getUserInfo(code, savestate); // 개인정보를 요청할 수 있는 값 요청

			rdattr.addFlashAttribute("email", resultmap.get("email"));
			rdattr.addFlashAttribute("name", resultmap.get("name"));

			if (resultmap.get("joinflag") == null) {
				return "redirect:/member/";
			} else {
				if (resultmap.get("joinflag").equals("1")) {
					rdattr.addFlashAttribute("joinflag", resultmap.get("joinflag"));
					rdattr.addFlashAttribute("flag", "네이버 간편 로그인");
				}
			}

		} else {
			System.out.println("인증에러");

		}

		return "redirect:/member/";
	}
}
