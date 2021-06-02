package rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.dao.BoardDao;
import spring.dto.BoardDto;

@RestController
public class BoardRestController {
	@Autowired
	BoardDao dao;
	
	@GetMapping("/ajax/list1")
	public List<BoardDto> list1(){
		return dao.getPhotoDatas(); //�ڵ����� json���·� ��ȯ
		
	}
	
	@GetMapping("/ajax/list2")
	public List<BoardDto> list2(){
		return dao.getAllDatas(); //�ڵ����� json���·� ��ȯ
	}
	
	@GetMapping("/ajax/data1")
	public BoardDto data1(int num) {
		return dao.getData(num);
	}
}
