package com.spring.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shop.data.ShopDao;
import shop.data.ShopDto;

@Controller
public class ShopListController {
	@Autowired  //자동주입
	ShopDao dao;
	
	@GetMapping({"/","/list"})//매핑 두가지 적용
	public ModelAndView list()
	{
		ModelAndView mview=new ModelAndView();
		//db 에서 전체 갯수 가져오기
		int totalCount=dao.getTotalCount();
		
		List<ShopDto>list =dao.getAllDatas();
		
		
		//model 에 저장
		mview.addObject("totalCount",totalCount);
		mview.addObject("list",list);
		
		mview.setViewName("shop/list");
		return mview;
	}
	
	@GetMapping("/content")
	public ModelAndView detail(
			@RequestParam String num
			) {
		ModelAndView mview= new ModelAndView();
		ShopDto dto=dao.getData(num);
		mview.addObject("dto",dto);
		mview.setViewName("shop/content");
		return mview;
	}
}
