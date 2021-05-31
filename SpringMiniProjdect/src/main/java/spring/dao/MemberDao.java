package spring.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import spring.dto.MemberDto;
@Repository //xml�ڵ� ���(dao���� @Repository)
public class MemberDao extends SqlSessionDaoSupport{
	//���̵� �����ϸ� 1, �������� ������ 0��ȯ
	public int getIdCount(String id) {
		return getSqlSession().selectOne("idCheckOfMember",id);
	}
	
	public void insertMember(MemberDto dto) {
		getSqlSession().insert("insertOfMember",dto);
	}
	
	public List<MemberDto> getAllMembers(){
		return getSqlSession().selectList("listAllOfMember");
	}
	
	//���̵�� ����� ��� ������ 1��ȯ, Ʋ���� 0��ȯ
	public int loginCheck(String id, String pass) {
		HashMap<String , String> map=new HashMap<String, String>();
		map.put("id", id);
		map.put("pass", pass);
		return getSqlSession().selectOne("loginCheckOfMember",map);
	}
}
