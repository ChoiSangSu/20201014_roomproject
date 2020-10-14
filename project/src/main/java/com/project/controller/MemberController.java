package com.project.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.dto.MemberDTO;
import com.project.service.MemberService;
import com.project.service.NaverLoginService;

@Controller
@RequestMapping("member")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Resource
	private MemberService service;

	@Resource
	private NaverLoginService lservice;

	// login.jsp�� �̵�
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String join(HttpServletRequest request, Model model, HttpSession session)
			throws UnsupportedEncodingException {
		logger.info(request.getServletContext().getRealPath("/"));

		// ���̹� �α��� ����
		Map<String, String> resultmap = lservice.getLoginUrl();
		String apiURL = resultmap.get("apiURL");
		String state = resultmap.get("state");
		session.setAttribute("state", state);
		model.addAttribute("apiURL", apiURL);

		return "member/join";
	}

	// ȸ������ db�� ���� �� ����
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String join(MemberDTO dto, RedirectAttributes rattr) {
		logger.info(dto.toString());
		Map<String, Object> resultMap = service.insert(dto);
		rattr.addFlashAttribute("msg", resultMap.get("msg"));
		if ((int) resultMap.get("result") == 0) { // ȸ������ ����
			return "redirect:/main/slider";
		} else { // ȸ������ ����
			return "redirect:/member/";
		}
	}

}
