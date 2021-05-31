package spring.dao;

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
}
