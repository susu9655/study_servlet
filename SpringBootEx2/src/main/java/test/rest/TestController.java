package test.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@GetMapping("/shop/info")
	public Map<String, String> hello(){
		Map<String, String> map=new HashMap<String, String>();
		map.put("mes", "dkssud");
		return map;
	}
}
