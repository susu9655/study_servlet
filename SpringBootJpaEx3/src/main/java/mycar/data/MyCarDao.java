package mycar.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyCarDao {
	@Autowired
	MyCarDaoInter dao;
	
	//db에 데이타 추가
	public void insertCar(MyCarDto dto)
	{
		dao.save(dto);//id유무에 따라 자동으로 insert 또는 update
	}
	
	
	  public List<MyCarDto> getAllDatas() { 
		  return dao.findAll();
		  }
	  
	  public MyCarDto getData(long num) {
		  MyCarDto dto=dao.getById(num);
		  return dto;
	  }
	
	  public void updateCar(MyCarDto dto) {	
			dao.save(dto);// num 이 dto 에 포함이므로 수정
		}
	  
	  public void deleteCar(long num) {
		  dao.deleteById(num);
	  }

}
