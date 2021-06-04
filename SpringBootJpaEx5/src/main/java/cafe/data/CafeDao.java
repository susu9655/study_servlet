package cafe.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class CafeDao {
	@Autowired
	CafeDaoInter dao;
	
	public void insert(CafeDto dto) {
		dao.save(dto);
	}
	
	 public List<CafeDto> getAllDatas() { 
		  return dao.findAll();
		  }
	  
	  public CafeDto getData(long num) {
		  CafeDto dto=dao.getById(num);
		  return dto;
	  }
	
	  public void update(CafeDto dto) {	
			dao.save(dto);// num 이 dto 에 포함이므로 수정
		}
	  
	  public void delete(long num) {
		  dao.deleteById(num);
	  }
}
