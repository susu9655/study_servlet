package day0526.ex3;

import javax.swing.text.AbstractDocument.Content;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JumunMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Shop�� color�� ������ ����
		 * price�� sanpum�� setter����(���� �������)
		 * Jumun�� shop�� cnt��� setter������ ��
		 * JumunŬ���� ���� �� showJumun ȣ��
		 * 
		 * */
		
		ApplicationContext context=new ClassPathXmlApplicationContext("day0526/appcontext3.xml");
		Jumun j=(Jumun)context.getBean("jumun");
		j.showJumun();
	}

}
