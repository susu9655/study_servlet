package day0526.ex5;

import org.springframework.stereotype.Component;

@Component //xml�� �ڵ� ���
public class CanadaTire implements Tire {

	@Override
	public String getTireName() {
		// TODO Auto-generated method stub
		return "ĳ���� Ÿ�̾�";
	}

}
