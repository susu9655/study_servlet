package day0526.ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InfoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=
				new ClassPathXmlApplicationContext("day0526/appcontext2.xml");
		MyInfo my1=(MyInfo)context.getBean("my");
		System.out.println(my1);//toString�޼��� �ڵ� ȣ��
		
		System.out.println("**person���� ���**");
		Person p=(Person)context.getBean("person");
		p.write();
	}

}
