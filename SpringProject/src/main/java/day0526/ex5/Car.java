package day0526.ex5;

import java.nio.file.spi.FileSystemProvider;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //id�� car
public class Car {
	//@Autowired //���� Ÿ���� �ڵ� ����, ���Ե� ���� �Ѱ��� ���� ��� ����
	
	@Resource(name = "canadaTire")//��Ȯ�� �̸��� ���� ã�Ƽ� �����ϴ� ���
	Tire tire;
	
	//������ ����
	public Car(Tire tire) {
		// TODO Auto-generated constructor stub
		this.tire=tire;
	}
	
	public void writeTire() {
		System.out.println(" ������ Ÿ�̾� �귣Ʈ ���� "+tire.getTireName()+"�Դϴ�");
	}
}
