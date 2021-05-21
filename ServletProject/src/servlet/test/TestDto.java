package servlet.test;

public class TestDto {
	private String name;
	private String addr;
	private String hp;
	
	public TestDto() {
		// 기본 생성자
	}

	public TestDto(String name, String addr, String hp) {
		super();
		this.name = name;
		this.addr = addr;
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}
	
}
