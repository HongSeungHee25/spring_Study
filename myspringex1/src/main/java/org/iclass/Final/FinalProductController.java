package org.iclass.Final;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FinalProductController {

	//필드
	private final FinalProductService service;

	@Autowired
	public FinalProductController(FinalProductService service) {
		System.out.println("111 - Controller");
		this.service = service;
	}
	
	public int product() {
		System.out.println("111 - 메소드");
		int result = service.product();
		
		return result;
	}
	
	
}
