package org.iclass.dao;

import java.util.List;
//import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.dto.PageRequestDTO;
import org.iclass.dto.TodoDto;

							// 인터페이스는 객체를 생성할 수 없다. 구현(체)클래스가 필요하다.
@Mapper						// 이 애노테이션은 mybatis mapper  인터페이스 ->  프록시가 구현체 만들어 줍니다.
public interface TodoMapper {
	
	int insert(TodoDto vo);
	TodoDto selectAll();
	TodoDto selectOne(long tno);
	long getCount(PageRequestDTO dto);
//	List<TodoDto> selectPageList(Map<String, Integer> map);
	List<TodoDto> selectPageList(PageRequestDTO dto);
}
