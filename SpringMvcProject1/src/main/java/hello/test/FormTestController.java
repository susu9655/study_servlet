package hello.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormTestController {
	@GetMapping("/test/form")
	public String form1() {
		return "form1";
	}

	@GetMapping("/test/read")
	public ModelAndView read1(
			//@RequestParam(value = "name") String name,
			//@RequestParam(value = "age") int age
			//���±��� name�� �д� �������� ���� �� ��� value�� ��������
			//@RequestParam String name,
			//@RequestParam int age
			
			//�Է��� ������ ��� ����Ʈ ��  ����
			@RequestParam(defaultValue = "lee") String name,
			@RequestParam(defaultValue = "10") int age,
			//pageNum�� �� �Ѿ�ö��� 1�� �ʱⰪ����
			@RequestParam(defaultValue = "1") String pageNum
			) {
		ModelAndView mview = new ModelAndView();
		String data=name+"���� ���̴� "+age+"�Դϴ�.";
		//mview.addObject("data",data);
		mview.setViewName("read1");
		
		return mview;
	}

}