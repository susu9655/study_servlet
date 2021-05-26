package day0526.ex6;

import org.springframework.stereotype.Component;

@Component("sdao") //자동으로 xml에 등록
public class ShopDao implements ShopDaoInter {
ShopDto dto;
	@Override
	public void insertShop(ShopDto dto) {
		// TODO Auto-generated method stub
		this.dto=dto;
		System.out.println("상품추가");

	}

	@Override
	public void updateShop(String sang) {
		// TODO Auto-generated method stub
		System.out.println(sang+"상품 업데이트");

	}

	@Override
	public void writeShop() {
		// TODO Auto-generated method stub
		System.out.println("**상품출력**");
		System.out.println("상품:"+dto.getSang());
		System.out.println("수량:"+dto.getSu());
		System.out.println("단가:"+dto.getDan());

	}

}
