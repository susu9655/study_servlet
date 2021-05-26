package day0526.ex2;

public class MyInfo {
	String name;
	int age;
	String addr;
	public MyInfo(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Myinfo [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
	
	
}
