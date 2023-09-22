package org.iclass.myFinal;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FinalProductController {

	private final FinalProductService service;
	
	public int product() {
		System.out.println("@@ ProductController product() 메소드 @@");
		int result = service.product();
		System.out.println("@@ service result : "+result+"@@");
		
		return result;
	}
}
