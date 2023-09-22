package org.iclass.Final;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FinalProductDao {

	private final int count;

	public FinalProductDao(@Value("111") int count) {
		System.out.println("333 - dao");
		this.count = count;
	}
	public int product() {
		System.out.println("333 - 메소드");
		int result = this.count;
		
		return result;
	}
	
}
