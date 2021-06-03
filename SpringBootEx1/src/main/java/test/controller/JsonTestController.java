package test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonTestController {
	
	@GetMapping("/shop/list")
	public List<shopDto> list(){
		List<shopDto> list=new ArrayList<shopDto>();
		shopDto s1=new shopDto();
		s1.setSang("사과");
		s1.setDan(3);
		s1.setSu(1000);
		list.add(s1);
		
		shopDto s2=new shopDto();
		s2.setSang("사과");
		s2.setDan(3);
		s2.setSu(1000);
		list.add(s2);

		return list;
		
	}
}
