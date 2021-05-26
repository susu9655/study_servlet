package spring.study.bit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	//���1
	/*
	 * @RequestMapping("/shop/detail")//�޼��� �⺻ ����� get�������� public String
	 * hello1(Model model) { //request�� ����
	 * model.addAttribute("mes","������ ��ſ� �������Դϴ�."); return "result1"; }
	 */
	
	//���2
	@GetMapping("/shop/detail")//������ 5���� ����
	public ModelAndView hello2() {
		ModelAndView mview = new ModelAndView();
		mview.addObject("mes","������ ������ �����??");
		//�������� ���ϸ� ����
		mview.setViewName("result1");
		return mview;
		
	}
	
}
