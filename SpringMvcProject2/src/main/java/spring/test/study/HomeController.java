package spring.test.study;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

		@GetMapping("/")
		public String menu(){
			
			
			return "day0527/menu";
		}
		
		@GetMapping("/shop/{path}")
		public String pathEx(Model model,
				@PathVariable("path") String p
				) {
			String mes="";
			if(p.equals("addcart")) {
				mes="��ٱ��Ͽ� ������ ��ǰ�� �߰��߾��~";
			}else if(p.equals("cartlist")) {
				mes="��ٱ��Ͽ� ��� ��ǰ���� ��� ����߾��";
			}else if(p.equals("delcart")) {
				mes="��ٱ��Ͽ��� ������ ��ǰ�� �����߾��";
			}else {
				mes="��ΰ� �߸��Ǿ����ϴ�.";
			}
			
			model.addAttribute("mes",mes);
			
			return "day0527/cartresult";
		}
	}
	

