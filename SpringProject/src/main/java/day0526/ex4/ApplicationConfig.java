package day0526.ex4;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration//���� ������ �������Ϸ� ����Ѵٰ� �˷���
@ImportResource("classpath:day0526/appcontext4.xml")
public class ApplicationConfig {
	
	@Bean //bean���� ����(�޼������ id�� �ν�)
	public Student student1() {
		//�̸��� ���̴� ������ ����
		Student s=new Student("��ȣ��", 23);
		
		//��̴� setter����
		ArrayList<String>hobby = new ArrayList<String>();
		hobby.add("����");
		hobby.add("����");
		hobby.add("����̺�");
		s.setHobby(hobby);
		return s;
		
	}
	
	@Bean //bean���� ����(�޼������ id�� �ν�)
	public Student student2() {
		//�̸��� ���̴� ������ ����
		Student s=new Student("����", 26);
		
		//��̴� setter����
		ArrayList<String>hobby = new ArrayList<String>();
		hobby.add("����");
		hobby.add("�����Ľ���");
		hobby.add("����");
		s.setHobby(hobby);
		return s;
		
	}
}
