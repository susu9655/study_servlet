package guest.data;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.apache.ibatis.session.SqlSession;

import mybatis.setting.ConnectionManager;

public class GuestDao {
	ConnectionManager manager=ConnectionManager.getInstance();
	SqlSession session;
	
	private SqlSession getSession() {
		session=manager.openSession();
		return session;
	}
	
	//�� ���� ���ϴ� �޼���
	public int getTotalCount() {
		//namespace�� ���� ���̵� ���� ��� �浹 ������ ���� �ִ� ���̹Ƿ�
				//���� ���̵� ���ٸ� ���������ϴ�
		session=getSession();
		int total=session.selectOne("guest.totalCountOfGuest");
		session.close();
		return total;
	}
	
	//insert
	public void insertGuest(GuestDto dto) {
		session=getSession();
		session.insert("guest.insertOfGuest",dto);
		session.close();
	}
	
	//���
	public List<GuestDto> getList(int start,int perpage){
		HashMap<String, Integer>map =new HashMap<String, Integer>();
		map.put("start", start);
		map.put("perpage", perpage);
		
		List<GuestDto>list=new Vector<GuestDto>();
		session=getSession();
		//�Ķ���ʹ� ���� ���� ���� ��� dto�Ǵ� map���·� ��� ������ �Ѵ�
		list=session.selectList("pagingListOfGuest",map);
		session.close();
		return list;
	}
}
