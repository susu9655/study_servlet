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
			//폼태그의 name과 읽는 변수명을 같게 할 경우 value는 생략가능
			//@RequestParam String name,
			//@RequestParam int age
			
			//입력을 안했을 경우 디폴트 값  설정
			@RequestParam(defaultValue = "lee") String name,
			@RequestParam(defaultValue = "10") int age,
			//pageNum값 안 넘어올때는 1로 초기값지정
			@RequestParam(defaultValue = "1") String pageNum
			) {
		ModelAndView mview = new ModelAndView();
		String data=name+"님의 나이는 "+age+"입니다.";
		//mview.addObject("data",data);
		mview.setViewName("read1");
		
		return mview;
	}

}