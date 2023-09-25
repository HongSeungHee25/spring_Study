package org.iclass.mvc.controller;

import org.iclass.mvc.dto.Community;
import org.iclass.mvc.service.CommunityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/community")
@Slf4j
public class CommunityController {

	private final CommunityService service;
	
	private CommunityController(CommunityService service) {
		this.service = service;
	}
	
	@GetMapping("/list")
	public void list(@RequestParam(defaultValue =  "1") 	//파라미터 값이 없으면 오류. 기본값 설정
			int page, Model model) {	//메소드 인자 int page 는 url 의 파라미터
		//Model : view 로 전달될 데이터를 주로 저장하는 역할
		//addAttribute 메소드 : request.setAttribute 와 동일.(session 도 Model 사용 가능. 로그인에서 사용)
		model.addAttribute("list",service.pagelist(page).get("list"));
		model.addAttribute("paging",service.pagelist(page).get("paging"));
		
	}
	
	@GetMapping("/read")
	public void read(long idx, 
			@ModelAttribute("page")		//파라미터로 받을 값을 Model 객체 - model.addAttribute 와 같이 저장합니다.
			int page, Model model) {
		model.addAttribute("vo", service.read(idx));
	}
	
	@GetMapping("/write")
	public void write() {
		//글쓰기 GET 요청은 view name 만 지정하고 끝.
	}
	@PostMapping("/write")
	public String save(Community dto) {	//파라미터가 많을 때, 그것들을 필드로 갖는 dto 또는 map 타입으로 전달받기
		log.info("dto : {}",dto);
		service.insert(dto);
		
		return "redirect:/community/list";
	}
	//location.href='list.jsp' 는 자바스크립트 - 클라이언트 브라우저에서 주소 변경
	//response.sendRedirect("list.jsp") 는 서버에서 클라이언트가 새로 보낼 요청을 강제로 실행.
	//			ㄴ POST 요청을 처리한 후에는 redirect 를 합니다.
	
	
}
