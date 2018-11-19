package concert;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {

	public static void main(String args[]) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ConcertConfig.class);
		Performance drama = context.getBean("drama", Performance.class);
		drama.perform();
		
		System.out.println("\nNext performance ..\n");
		
		Performance circus = context.getBean("circus", Performance.class);
		try {
			circus.perform();
		}
		catch(PerformanceException ex) {
			
		}
	}
}
