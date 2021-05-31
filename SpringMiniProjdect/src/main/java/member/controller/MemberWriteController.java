package member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.dao.MemberDao;
import spring.dto.MemberDto;

@Controller
public class MemberWriteController {
	@Autowired
	MemberDao dao;
	
	@GetMapping("/member/form")
	public String writeform() {
		return "/member/memberform";
	}
	
	@GetMapping("/member/idcheck")
	public @ResponseBody Map<String, Integer> idCheck(
			@RequestParam String id)
	{
		Map<String,Integer> map=new HashMap<String, Integer>();
		int count=dao.getIdCount(id);
		System.out.println(count);
		map.put("count", count);
		return map;
	}
	
	@PostMapping("/member/insert")
	public String insertMember(@ModelAttribute MemberDto dto) {
		dao.insertMember(dto);
		return "redirect:list";
	}
}
