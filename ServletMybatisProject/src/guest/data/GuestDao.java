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
	
	//총 개수 구하는 메서드
	public int getTotalCount() {
		//namespace는 같은 아이디가 있을 경우 충돌 방지를 위해 넣는 것이므로
				//같은 아이디가 없다면 생략가능하다
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
	
	//출력
	public List<GuestDto> getList(int start,int perpage){
		HashMap<String, Integer>map =new HashMap<String, Integer>();
		map.put("start", start);
		map.put("perpage", perpage);
		
		List<GuestDto>list=new Vector<GuestDto>();
		session=getSession();
		//파라미터는 여러 개를 보낼 경우 dto또는 map형태로 묶어서 보내야 한다
		list=session.selectList("pagingListOfGuest",map);
		session.close();
		return list;
	}
	
	//비밀번호 체크
		public int isCheckPass(String num,String pass)
		{
			int n;
			session=getSession();
			HashMap<String, String> map=new HashMap<String, String>();
			map.put("num", num);
			map.put("pass", pass);
			
			n=session.selectOne("passCheckOfGuest", map);
			session.close();
			return n;
		}
		
		public GuestDto getData(String num)
		{
			GuestDto dto=null;
			session=getSession();
			dto=session.selectOne("getDataOfGuest", num);
			session.close();
			return dto;		
		}
		
		public void updateGuest(GuestDto dto)
		{
			session=getSession();
			session.update("updateOfGuest", dto);
			session.close();		
		}
		
		public void deleteGuest(String num)
		{
			session=getSession();
			session.delete("deleteOfGuest", num);
			session.close();		
		}

}
