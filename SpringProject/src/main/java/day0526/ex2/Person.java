package day0526.ex2;

public class Person {
	String schoolName;
	MyInfo info;
	
	//info������ �������ڸ� ���ؼ� ����
	public Person(MyInfo info) {
		// TODO Auto-generated constructor stub
		this.info=info;
	}
	
	//�б����� setter����
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	public void write() {
		System.out.println("**�л� ���� ���**");
		System.out.println("�б���:"+schoolName);
		System.out.println("�̸� : "+info.name);
		System.out.println("���� : "+info.age);
		System.out.println("�ּ� : "+info.addr);
	}
}
