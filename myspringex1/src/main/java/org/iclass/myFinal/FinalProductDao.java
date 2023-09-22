package org.iclass.myFinal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class FinalProductDao {

	private final int count;
	
	public FinalProductDao(@Value("10") int count) {
		System.out.println(":::::: ProductDao 생성자 - int value 전달 ::::::");
		this.count = count;
	}
	public int product() {
		System.out.println("★★ ProductDao Product() 메소드 ★★");
		int result = this.count;
		System.out.println("★★ 수량 : "+result+" 입니다.★★");
		return result;
	}
	
}
