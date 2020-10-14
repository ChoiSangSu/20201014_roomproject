package com.project.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.dto.ReserveDTO;
import com.project.service.ReserveService;

@Controller
@RequestMapping("reserve")
public class ReserveController {

	@Resource
	private ReserveService reservice;

	private static final Logger logger = LoggerFactory.getLogger(ReserveController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String reserve(@ModelAttribute("roomid") String roomid) {

		return "reserve/reserve";
	}

	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public String reservego(ReserveDTO redto, RedirectAttributes rattr) throws Exception {
		System.out.println("Controller 예약" + redto);
		reservice.insert(redto);
		rattr.addFlashAttribute("msg", "예약 되었습니다");
		return "redirect:/main/slider";
	}

	// 예약 확인
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String roomSelect(String userid, Model model) throws Exception {
		List<ReserveDTO> list = reservice.selectList(userid);
		model.addAttribute("list", list);
		return "reserve/resultReserve";
	}

	// 예약 취소

	@RequestMapping(value = "/cancle", method = RequestMethod.GET)
	public String roomCancle(String rnum, RedirectAttributes rattr) throws Exception {
		int cnt = reservice.delete(rnum);
		rattr.addFlashAttribute("msg", "취소 되었습니다");
		return "redirect:/main/slider";
	}
}
