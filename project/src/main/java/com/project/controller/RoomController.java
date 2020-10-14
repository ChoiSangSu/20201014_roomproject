package com.project.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.dto.RoommasterDTO;
import com.project.service.RoomService;

@Controller
@RequestMapping("room")
public class RoomController {

	private static final Logger logger = LoggerFactory.getLogger(RoomController.class);
	
	@Resource
	private RoomService rservice;
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String room(RoommasterDTO rdto,Model model) throws Exception {
		List<RoommasterDTO> rlist = rservice.selectList(rdto.getRoomid());
		model.addAttribute("rlist", rlist);
		return "reserve/roomlist";
	}
	
	@RequestMapping(value="/select",method=RequestMethod.GET)
	public String roomSelect(RoommasterDTO rdto,Model model) throws Exception {
		List<RoommasterDTO> rlist = rservice.selectList(rdto.getRoomid());
		model.addAttribute("rlist", rlist);
		return "reserve/roomlist";
	}
	
	@RequestMapping(value="/addform",method = RequestMethod.GET)
	public String roomAddForm() {
		return "reserve/roomadd";
	}
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public String roomAdd(RoommasterDTO rdto, List<MultipartFile> files,RedirectAttributes rattr) throws Exception {
		rservice.insert(rdto, files);
		System.out.println("rdto");
		rattr.addFlashAttribute("msg", "추가완료");
		return "redirect:/room/select";		
	}
}
