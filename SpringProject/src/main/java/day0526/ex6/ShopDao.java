package day0526.ex6;

import org.springframework.stereotype.Component;

@Component("sdao") //�ڵ����� xml�� ���
public class ShopDao implements ShopDaoInter {
ShopDto dto;
	@Override
	public void insertShop(ShopDto dto) {
		// TODO Auto-generated method stub
		this.dto=dto;
		System.out.println("��ǰ�߰�");

	}

	@Override
	public void updateShop(String sang) {
		// TODO Auto-generated method stub
		System.out.println(sang+"��ǰ ������Ʈ");

	}

	@Override
	public void writeShop() {
		// TODO Auto-generated method stub
		System.out.println("**��ǰ���**");
		System.out.println("��ǰ:"+dto.getSang());
		System.out.println("����:"+dto.getSu());
		System.out.println("�ܰ�:"+dto.getDan());

	}

}
