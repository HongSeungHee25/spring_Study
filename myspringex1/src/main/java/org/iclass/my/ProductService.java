package org.iclass.my;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component 	//싱글톤 클래스 빈을 생성
public class ProductService {

	private ProductDao dao;
	
	public ProductService() {
		System.out.println(":::::: ProductService 생성자 ::::::");
	}
	
	@Autowired
	public void setDao(ProductDao dao) {
		System.out.println("━━━━━━━━━━ProductService setter 메소드━━━━━━━━━━");
		this.dao = dao;
	}
	
	@Autowired
	public ProductService(ProductDao dao) {
		System.out.println(":::::: ProductService 생성자 - ProductDao bean 주입 ::::::");
		this.dao = dao;
	}
	
	public void product() {
		System.out.println("━━━━━━━━━━ProductService product() 메소드━━━━━━━━━━");
		dao.product();
	}
	
}
