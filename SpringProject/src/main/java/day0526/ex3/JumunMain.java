package day0526.ex3;

import javax.swing.text.AbstractDocument.Content;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JumunMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Shop은 color는 생성자 주입
		 * price와 sanpum은 setter주입(값은 마음대로)
		 * Jumun은 shop과 cnt모두 setter주입한 후
		 * Jumun클래스 생성 후 showJumun 호출
		 * 
		 * */
		
		ApplicationContext context=new ClassPathXmlApplicationContext("day0526/appcontext3.xml");
		Jumun j=(Jumun)context.getBean("jumun");
		j.showJumun();
	}

}
