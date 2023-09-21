package org.iclass.my;

import org.springframework.beans.factory.annotation.Value;

public class ProductDao {

	private int count;
	
	public ProductDao() {
		System.out.println(":::::: ProductDao 기본 생성자 ::::::");
	}
	
	@Value("22")
	public void setCount(int count) {
		System.out.println("━━━━━━━━━━ProductDao setter 메소드━━━━━━━━━━"); 
		this.count = count;
	}
	
	public ProductDao(@Value("10") int count) {
		System.out.println(":::::: ProductDao 생성자 - int value 전달 ::::::");
		this.count = count;
	}
	
	public void product() {
		System.out.println("━━━━━━━━━━ProductDao product() 메소드━━━━━━━━━━");
		System.out.println("━━━━━━━━━━수량 : "+count+" 생산합니다.");
	}
	
}
