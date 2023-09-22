package org.iclass.myFinal;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FinalProductService {

	private final FinalProductDao dao;
	
	public int product() {
		System.out.println("☆☆ ProductService product() 메소드 ☆☆");
		int result = dao.product();
		System.out.println("☆☆ dao result : "+result+" ☆☆");
	
		return result;
	}
}
