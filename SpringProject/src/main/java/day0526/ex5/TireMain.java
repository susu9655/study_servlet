package day0526.ex5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import day0526.ex4.ApplicationConfig;

public class TireMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("day0526/appcontext5.xml");
		
		Car car=(Car)context.getBean("car");
		car.writeTire();
				
	}

}
