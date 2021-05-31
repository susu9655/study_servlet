package member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.dao.MemberDao;
import spring.dto.MemberDto;

@Controller
public class MemberMunjeController {
	@Autowired
	MemberDao dao;
	
	@GetMapping("member/updateform")
	public ModelAndView getdata(String num) {
		ModelAndView mview = new ModelAndView();
		MemberDto dto=dao.getMember(num);
		mview.addObject("dto",dto);
		mview.setViewName("/member/updateform");
		return mview;
	}
	
	@PostMapping("/member/update")
	public String update(@ModelAttribute MemberDto dto) {
		int count=dao.passCheck(dto.getNum(), dto.getPass());
		if(count==1) {
			//일치할 경우 수정후 멤버목록으로 이동
			dao.updateMember(dto);
			return "redirect:list";
		}else {
			//일치하지 않을 경우 passfail로 포워드
			return "/member/passfail";
		}
	}
	
	@GetMapping("member/delete")
	public String delete(@RequestParam String num,HttpSession session) {
		String myid=(String)session.getAttribute("myid");
		if(myid.equals("admin")) {
			//저장된 아이디가 admin일 경우삭제후 멤버목록
			dao.deleteMember(num);
			return "redirect:list";
		}else {
			return "/member/idfail";
		}
	}
}
