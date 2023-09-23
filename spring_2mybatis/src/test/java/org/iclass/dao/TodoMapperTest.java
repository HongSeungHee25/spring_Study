package org.iclass.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

import org.iclass.config.MybatisConfig;
import org.iclass.dto.PageRequestDTO;
import org.iclass.dto.TodoDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@DisplayName("todo mapper 의 crud 동작이 되어야 합니다.")
@ExtendWith(SpringExtension.class)								//테스트 클래스 기능을 위한 어노테이션
@ContextConfiguration(classes = MybatisConfig.class)			//테스트 클래스에서 설정파일 가져오기
@Slf4j
class TodoMapperTest {
	
	
	@Autowired
	private TodoMapper dao;
	
	@Test
	@DisplayName("insert 를 여러행 해봅시다.페이징 테스트를 위한 데이터 추가.")
	@Disabled
	void insertMany() {//i는 1부터 19까지 실행됩니다.
		IntStream.range(1, 20).forEach(i -> {	
			TodoDto vo = TodoDto.builder() 
					.title("집에 보내줘"+i)
					.dueDate(LocalDate.of(2023, 10, 3)) 
					.writer("모모" + (char)('A'+i)) 
					.finished(true)
					.build(); 
			
			dao.insert(vo);
		});
	}
	
	@Test
	@DisplayName("다양한 조건으로 검색합니다.")
	void search() {
//		PageRequestDTO pageRequestDTO = PageRequestDTO.of(1, 5,new String[] {"t", "w"},"매퍼",false,null,null);
		PageRequestDTO pageRequestDTO = PageRequestDTO.of(1, 100,null,null,false,LocalDate.of(2023, 9, 29),LocalDate.of(2023, 10, 2));
		
		List<TodoDto> list = dao.selectPageList(pageRequestDTO);
		list.forEach(dto -> log.info("★★★★★★★ search result : {}",dto));
		
		log.info("★★★★★★★★★★★★★★ total count : {}",dao.getCount(pageRequestDTO));
	}
	
	  @DisplayName("todo 테이블에 insert 가 되어야 합니다.")
	  @Test 
	  @Disabled
	  void insert() { 
//	  LocalDate date = LocalDate.of(2000, 9, 25);
	  log.info("insert() 실행"); 
	  TodoDto vo = TodoDto.builder() 
			  .title("mybatis 공부")
//			  .dueDate(Date.valueOf("2023-10-01")) 
			  .dueDate(LocalDate.of(2000, 9, 25)) 
			  .writer("승희") 
			  .build(); 
	  log.info(">>>>>>> vo : {}",vo);
	  assertNotEquals(0, dao.insert(vo));
	  
	  }
	
	  @DisplayName("tno 1개를 조건값으로 조회가 되어야 합니다.")
	  @Test
	  @Disabled
	  void selectOne() {
		  TodoDto dto = dao.selectOne(20111L);
		  log.info(">>>>>>> 조회된 dto : {}",dto);
		  assertNotNull(dto);
	  }
	 
	

}
