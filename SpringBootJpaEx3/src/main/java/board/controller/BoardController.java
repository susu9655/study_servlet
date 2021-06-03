package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mycar.data.MyCarDao;
import mycar.data.MyCarDto;

@Controller
public class BoardController {
	
	@Autowired
	MyCarDao dao;
	
	@GetMapping({"/","/list"})
	public ModelAndView list() {
		ModelAndView mview =new ModelAndView();
		mview.addObject("mes","스프링 부트 셋팅하기");
		
		List<MyCarDto>list=dao.getAllDatas();
		
		mview.addObject("list",list);
		mview.setViewName("list");
		return mview;
	}
	
	@GetMapping("/carform")
	public String form() {
		return "writeform";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute MyCarDto dto)
	{
		//db에 데이타 추가
		dao.insertCar(dto);
		//목록으로 이동
		return "redirect:list";
	}
	
	@GetMapping("/updateform")
	public ModelAndView updateform(@RequestParam long num) {
		ModelAndView mview = new ModelAndView();
		MyCarDto dto=dao.getData(num);
		mview.addObject("dto",dto);
		mview.setViewName("updateform");
		return mview;
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute MyCarDto dto)
	{
		//db에 데이타 수정
		dao.updateCar(dto);
		//목록으로 이동
		return "redirect:list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam long num) {
		dao.deleteCar(num);
		return "redirect:list";
	}

}
