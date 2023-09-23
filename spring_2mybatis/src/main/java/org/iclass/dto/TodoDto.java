package org.iclass.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoDto {
	private long tno;
	private String title;						//제목
	
	
	  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
	  private LocalDate dueDate;
	 					//할일 기한 날짜. mybatis 에서 날짜타입을 Date 아닌
//	private Date dueDate;											//				ㄴ LocalDate 적용되는지 확인 필요
												//				ㄴ 스프링의 다른 기능 사용을 위해 날짜타입 LocalDate 로 함.
	private String writer;						//작성
	private boolean finished;					//완료여부

}
