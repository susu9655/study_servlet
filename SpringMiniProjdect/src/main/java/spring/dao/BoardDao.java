package spring.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import spring.dto.BoardDto;

@Repository
public class BoardDao extends SqlSessionDaoSupport{
	public int getTotalCount() {
		return getSqlSession().selectOne("totalCountOfBoard");
	}
	
	public int getmaxNum() {
		return getSqlSession().selectOne("maxNumOfBoard");
	}
	
	public void updateRestep(int reg,int restep) {
		HashMap<String , Integer> map=new HashMap<String, Integer>();
		map.put("reg", reg);
		map.put("restep", restep);
		getSqlSession().update("updateReadCountOfBoard",map);
	}
	
	public void insertBoard(BoardDto dto)
	{
		//�������� ��������� ���� ���� �ٸ��� dto �� �־ ����
		int num=dto.getNum();
		int reg=dto.getReg();
		int restep=dto.getRestep();
		int relevel=dto.getRelevel();
		
		if(num==0)//�����ΰ��
		{
			reg=this.getmaxNum()+1;
			System.out.println(reg);
			restep=0;
			relevel=0;					
		}else {//����ΰ��
			this.updateRestep(reg, restep);
			restep+=1;
			relevel+=1;
		}
		//����� 3���� ���� dto �� �־��ش�
		dto.setReg(reg);
		dto.setRestep(restep);
		dto.setRelevel(relevel);
		
		getSqlSession().insert("insertOfBoard",dto);
	}

	
	public List<BoardDto> getList(int start,int perpage){
		HashMap<String, Integer>map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("perpage", perpage);
		
		return getSqlSession().selectList("selectPagingOfBoard",map);
	}
	
	public void updateReadCount(int num) {
		getSqlSession().update("updateRestepOfBoard",num);
		
	}
	
	public BoardDto getData(int num) {
		return getSqlSession().selectOne("selectOneOfBoard",num);
	}
	
	public String searchName(String id) {
		return getSqlSession().selectOne("searchNameOfMember",id);
	}
	
	public void updateBoard(BoardDto dto) {
		getSqlSession().update("updateOfBoard",dto);
	}
	
	public void deleteBoard(String num) {
		getSqlSession().delete("deleteOfBoard",num);
	}
}
