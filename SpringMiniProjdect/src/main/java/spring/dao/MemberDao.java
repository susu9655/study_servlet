package spring.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import spring.dto.MemberDto;
@Repository //xml자동 등록(dao에는 @Repository)
public class MemberDao extends SqlSessionDaoSupport{
	//아이디가 존재하면 1, 존재하지 않으면 0반환
	public int getIdCount(String id) {
		return getSqlSession().selectOne("idCheckOfMember",id);
	}
	
	public void insertMember(MemberDto dto) {
		getSqlSession().insert("insertOfMember",dto);
	}
	
	public List<MemberDto> getAllMembers(){
		return getSqlSession().selectList("listAllOfMember");
	}
	
	//아이디와 비번이 모두 맞으면 1반환, 틀리면 0반환
	public int loginCheck(String id, String pass) {
		HashMap<String , String> map=new HashMap<String, String>();
		map.put("id", id);
		map.put("pass", pass);
		return getSqlSession().selectOne("loginCheckOfMember",map);
	}
}
