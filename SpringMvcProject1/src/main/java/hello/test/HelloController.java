package hello.test;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	//�ΰ��� �����ּҰ� ���� �޼��� ȣ��ǰ� �Ϸ���
	@GetMapping({"/info/my","/board/list"})
	public ModelAndView process1() {
		ModelAndView mview = new ModelAndView();
		mview.addObject("name","��ȣ��");
		mview.addObject("addr","���ֵ�");
		mview.setViewName("result2");
		return mview;
	}
	
	//���ǰ� ������ũ�� ���ÿ� ���� �ְ� ������
	@GetMapping("/stu/info")
	public String process2(HttpSession session, Model model) {
		model.addAttribute("mes","������Ʈ�� ����� ���ڿ�");//request�� ����
		session.setAttribute("myid", "angel");//���ǿ� ����
		return "result3";
	}
	
	@GetMapping("/guest/form")
	public ModelAndView guest(ModelAndView mview, HttpSession session) {
		mview.addObject("name","����");
		mview.addObject("java","100");
		mview.addObject("spring","100");
		session.setAttribute("birth", "1996-05-05");
		mview.setViewName("result4");
		return mview;
	}
}
