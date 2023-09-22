package org.iclass.Final;


import org.springframework.stereotype.Component;

@Component
public class FinalProductService {

	private final FinalProductDao dao;

	public FinalProductService(FinalProductDao dao) {
		System.out.println("222 - Service");
		this.dao = dao;
	}
	public int product() {
		System.out.println("222 - 메소드");
		int result = dao.product();
		
		return result;
	}
	
}
