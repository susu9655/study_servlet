package day0526.ex3;

public class Jumun {
	Shop shop;
	int cnt;
	
	//setter����
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	public void showJumun() {
		System.out.println("**�ֹ���ǰ Ȯ��**");
		System.out.println("��ǰ�� : "+shop.getSangpum());
		System.out.println("��ǰ ����:"+shop.getPrice());
		System.out.println("��ǰ ���� : "+shop.getColor());
		System.out.println("�ֹ����� : "+cnt);
		
	}
}
