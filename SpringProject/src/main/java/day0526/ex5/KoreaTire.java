package day0526.ex5;

import org.springframework.stereotype.Component;

@Component //자동으로  xml에 등록하는데 클래스명이 id가 된다(첫글자는 소문자)
public class KoreaTire implements Tire{

	@Override
	public String getTireName() {
		// TODO Auto-generated method stub
		return "ㄴ";
	}
	
}
