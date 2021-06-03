package mycar.data;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "mycar")//자동으로 mycar라는 테이블이 생성,기존에 있다면 변경된 부분만 업데이트가 된다
@Data
public class MyCarDto {
	@Id //각 엔터티를 구별할 수 있게 식별 아이디를 갖도록 설게
	@GeneratedValue(strategy = GenerationType.AUTO)//db에 맞게 숫자가 자동 발생
	private long num;
	
	@Column(name = "carname")
	private String carname;
	@Column(name = "carprice")
	private int carprice;
	@Column(name = "carcolor")
	private String carcolor;
	@Column(name = "carguip")
	private String carguip;
	
	@CreationTimestamp //엔터티가 생성되는 시점의 시간이 자동 등록
	@Column(updatable = false) //save로 수정시 이 컬럼은 제외
	private Timestamp writeday;
	
	
}
