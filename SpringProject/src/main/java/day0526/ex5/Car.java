package day0526.ex5;

import java.nio.file.spi.FileSystemProvider;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //id는 car
public class Car {
	//@Autowired //같은 타입이 자동 주입, 주입될 빈이 한개만 있을 경우 가능
	
	@Resource(name = "canadaTire")//정확한 이름의 빈을 찾아서 주입하는 방식
	Tire tire;
	
	//생성자 주입
	public Car(Tire tire) {
		// TODO Auto-generated constructor stub
		this.tire=tire;
	}
	
	public void writeTire() {
		System.out.println(" 내차의 타이어 브랜트 명은 "+tire.getTireName()+"입니다");
	}
}
