package test.controller;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//lombok이 잘 설치되었다면 아래의 어노테이션을 추가해보자
/*@Setter
@Getter
@ToString*/
//위의 3가지 어노테이션은 @Data로 대체 가능
@Data
public class shopDto {
	private String sang;
	private int su;
	private int dan;
}
