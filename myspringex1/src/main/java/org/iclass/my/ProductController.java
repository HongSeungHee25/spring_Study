package org.iclass.my;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductController {

	private ProductService service;
	
	public ProductController() {
		System.out.println(":::::: ProductController 기본 생성자 ::::::");
	}
	
	@Autowired
	public void setService(ProductService service) {
		System.out.println("━━━━━━━━━━ProductController setter 메소드━━━━━━━━━━");
		this.service = service;
	}
	public ProductController(ProductService service) {
		System.out.println(":::::: ProductController 생성자 - ProductService bean 주입 ::::::");
		this.service = service;
	}
	
	public void product() {
		System.out.println("━━━━━━━━━━ProductController 생성자 - ProductService bean 주입━━━━━━━━━━");
		service.product();
	}
	
}
