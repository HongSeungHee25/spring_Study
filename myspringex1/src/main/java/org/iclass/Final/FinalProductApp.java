package org.iclass.Final;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class FinalProductApp {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(FinalProductConfig.class);
		
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		FinalProductController controller = context.getBean(FinalProductController.class);
		System.out.println(controller.product());
		
		((AbstractApplicationContext) context).close();
		
	}
}
