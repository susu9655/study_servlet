package hello.test;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	//두가지 매핑주소가 같은 메서드 호출되게 하려면
	@GetMapping({"/info/my","/board/list"})
	public ModelAndView process1() {
		ModelAndView mview = new ModelAndView();
		mview.addObject("name","강호동");
		mview.addObject("addr","제주도");
		mview.setViewName("result2");
		return mview;
	}
	
	//세션과 리퀘스크에 동시에 값을 넣고 포워드
	@GetMapping("/stu/info")
	public String process2(HttpSession session, Model model) {
		model.addAttribute("mes","리퀘스트에 저장된 문자열");//request에 저장
		session.setAttribute("myid", "angel");//세션에 저장
		return "result3";
	}
	
	@GetMapping("/guest/form")
	public ModelAndView guest(ModelAndView mview, HttpSession session) {
		mview.addObject("name","현수");
		mview.addObject("java","100");
		mview.addObject("spring","100");
		session.setAttribute("birth", "1996-05-05");
		mview.setViewName("result4");
		return mview;
	}
}
