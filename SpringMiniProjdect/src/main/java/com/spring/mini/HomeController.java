package com.spring.mini;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

import spring.dao.MemberDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	MemberDao dao;
	
	@GetMapping({"/","/home"})
	public String main() {
		//tiles layout설정한 곳으로 포워드
		return "/layout/main";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/login/loginmain";
	}

	@PostMapping("/loginprocess")
	public String loginCheck(@RequestParam String id,
			@RequestParam String pass,
			HttpSession session
			) {
		int n=dao.loginCheck(id, pass);
		String a="";
		if(n==1) {
			//세션 저장후 메인페이지로 리다이렉트
			session.setAttribute("loginok", "yes");
			session.setAttribute("myid", id);
			//메인 페이지로 리다이랙트
			a="redirect:home";
		}else {
			//loginfail.jsp로 포워드
			a="/login/loginfail";
		}
			
		return a;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginok");
		session.removeAttribute("myid");
		return "redirect:home";
	}
	
	@GetMapping("/mail/send")
	public String mailform() {
		return "/email/form";
	}
	
	
}
