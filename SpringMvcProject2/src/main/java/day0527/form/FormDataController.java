package day0527.form;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
