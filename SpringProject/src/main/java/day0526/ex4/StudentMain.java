package day0526.ex4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentMain {
	public static void writeStudent(Student s) {
		System.out.println("**�л�����**");
		System.out.println("�̸� : "+s.getName());
		System.out.println("���� : "+s.getAge());
		for(String h:s.getHobby())
			System.out.println("\t"+h);
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ȯ�漳���� xml�� �ƴ� �ڹ�Ŭ�������� ����
		AnnotationConfigApplicationContext abs=
				new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Student s1=(Student)abs.getBean("student1");
		writeStudent(s1);
		Student s2=(Student)abs.getBean("student2");
		writeStudent(s2);
				
	}

}
