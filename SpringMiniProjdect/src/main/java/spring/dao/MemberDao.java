package spring.dao;

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
}
