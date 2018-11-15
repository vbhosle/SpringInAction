package concert;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {

	public static void main(String args[]) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ConcertConfig.class);
		Performance performance = context.getBean("drama", Performance.class);
		performance.perform();
	}
}
