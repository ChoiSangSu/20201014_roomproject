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

	// ���̹� �α��� �����ڵ� �ݹ� ����
	// code:�����ڵ� , state : ���ǿ� ����� �� (Ŭ���̾�Ʈ ������ ����)
	@RequestMapping("/callback")
	public String callback(String code, String state, RedirectAttributes rdattr, HttpSession session)
			throws ParseException, java.text.ParseException, org.json.simple.parser.ParseException {
		System.out.println("code : " + code);
		System.out.println("state : " + state);
		// ������ state���� �Ѱܹ��� state�� ��ġ
		String savestate = (String) session.getAttribute("state");
		if (savestate.equals(state)) {
			Map<String, String> resultmap = lservice.getUserInfo(code, savestate); // ���������� ��û�� �� �ִ� �� ��û

			rdattr.addFlashAttribute("email", resultmap.get("email"));
			rdattr.addFlashAttribute("name", resultmap.get("name"));

			if (resultmap.get("joinflag") == null) {
				return "redirect:/member/";
			} else {
				if (resultmap.get("joinflag").equals("1")) {
					rdattr.addFlashAttribute("joinflag", resultmap.get("joinflag"));
					rdattr.addFlashAttribute("flag", "���̹� ���� �α���");
				}
			}

		} else {
			System.out.println("��������");

		}

		return "redirect:/member/";
	}
}
