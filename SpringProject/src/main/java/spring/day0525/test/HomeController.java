package spring.day0525.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		return "views/home";
	}
	
	@RequestMapping(value="/shop/list",method = RequestMethod.GET)
	public String hello(Model model) {//�޼������ �������
		//request�� ����
		model.addAttribute("sangpum","���콺");
		model.addAttribute("price","1000");
		model.addAttribute("color","���");
		
		return "shop/list";//������ ���ϸ�
	}
	
	@RequestMapping(value="/stu/list",method = RequestMethod.GET)
	public String stu(Model model) {//�޼������ �������
		//request�� ����
		model.addAttribute("name","����");
		model.addAttribute("buseo","������");
		model.addAttribute("hp","010-2222-2222");
		
		return "shop/result";//������ ���ϸ�
	}
	
	@RequestMapping(value="/member/form",method = RequestMethod.GET)
	public String member(Model model) {//�޼������ �������
		//request�� ����
		model.addAttribute("name","����");
		model.addAttribute("buseo","������");
		model.addAttribute("pay","4000000");
		
		return "shop/info";//������ ���ϸ�
	}
}
