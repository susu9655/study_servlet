package day0527.form;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormDataController {
	@GetMapping("/form1")
	public String form1() {
		return "day0527/form1";
	}
	
	@GetMapping("/form2")
	public String form2() {
		return "day0527/form2";
	}
	
	@GetMapping("/form3")
	public String form3() {
		return "day0527/form3";
	}
	
	@PostMapping("/read1")
	//@RequestMapping(value = "/read1",method= RequestMethod.POST)//�� ���� ����
	public ModelAndView read1(
			@RequestParam String name,
			@RequestParam String gender,
			@RequestParam String ipsa
			) {
		ModelAndView mview = new ModelAndView();
		mview.addObject("name",name);
		mview.addObject("gender",gender);
		mview.addObject("ipsa",ipsa);
		mview.setViewName("day0527/result1");
		return mview;
	}
	
	@PostMapping("/read2")
	public String read2(@ModelAttribute("dto") FormDto dto) {
		System.out.println(dto.getSang());//��ǰ�� �ֿܼ� ���
		//@ModelAttribute �𵨿� ������ �Ǵµ� ���� �������� formDto
		//���� �ٸ� �̸����� ������ ���Ѵٸ� @ModelAttribute("dto")��� �����
		return "day0527/result2";
	}
	
	@PostMapping("/read3")
	public ModelAndView read3(
			//map���� ���� ��� ���±��� name�� key������ �ڵ� ����
			@RequestParam Map<String, String>map
			) {
		ModelAndView mview =new ModelAndView();
		mview.addObject("name",map.get("name"));
		mview.addObject("java",map.get("java"));
		mview.addObject("html",map.get("html"));
		mview.addObject("spring",map.get("spring"));
		mview.addObject("height",map.get("height"));
		mview.addObject("weight",map.get("weight"));
		
		
		mview.setViewName("day0527/result3");
		return mview;
	}
}
