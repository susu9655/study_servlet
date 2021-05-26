package day0526.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//기존에 알고있던 자바방식으로 생성해서 호출
		MessageInter m1 = new Message1();
		m1.sayHello("홍길동");
		
		MessageInter m2 = new Message2();
		m2.sayHello("이효리");
		
		System.out.println("스프링에서의 객체 생성과 호출");
		ApplicationContext context=
				new ClassPathXmlApplicationContext("day0526/appcontext1.xml");//xml파일 위치 선언
		MessageInter m3=(Message1)context.getBean("mesBean1");//반환타입이 object이므로 클래스타입으로 형변환해줘야함
		//bean을 생성하고 그 아이디를 이용해 객체를 생성
		m3.sayHello("유재석");
		
		//다른 방법
		MessageInter m4=context.getBean("mesBean2",Message2.class);
		m4.sayHello("캔디");
	}

}
