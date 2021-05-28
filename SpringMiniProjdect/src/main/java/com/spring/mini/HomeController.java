package com.spring.mini;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@GetMapping({"/","/home"})
	public String main() {
		//tiles layout설정한 곳으로 포워드
		return "/layout/main";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/login/loginmain";
	}
	@GetMapping("/member/list")
	public String memberlist() {
		return "/member/memberlist";// 폴더명/파일명
	}
	
	@GetMapping("/board/list")
	public String boardlist() {
		return "/board/boardlist";
	}
}
