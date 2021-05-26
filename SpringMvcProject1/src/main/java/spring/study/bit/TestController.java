package spring.study.bit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	//방법1
	/*
	 * @RequestMapping("/shop/detail")//메서드 기본 방식은 get생략가능 public String
	 * hello1(Model model) { //request에 저장
	 * model.addAttribute("mes","오늘은 즐거운 수요일입니다."); return "result1"; }
	 */
	
	//방법2
	@GetMapping("/shop/detail")//스프링 5부터 가능
	public ModelAndView hello2() {
		ModelAndView mview = new ModelAndView();
		mview.addObject("mes","여러분 스프링 어렵죠??");
		//포워드할 파일명 지정
		mview.setViewName("result1");
		return mview;
		
	}
	
}
