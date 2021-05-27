package com.spring.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import shop.data.ShopDao;

@Controller
public class ShopListController {
	@Autowired  //�ڵ�����
	ShopDao dao;
	
	@GetMapping("/")
	public ModelAndView list()
	{
		ModelAndView mview=new ModelAndView();
		//db ���� ��ü ���� ��������
		int totalCount=dao.getTotalCount();
		
		//model �� ����
		mview.addObject("totalCount",totalCount);
		
		mview.setViewName("shop/list");
		return mview;
	}
}
