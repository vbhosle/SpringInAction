package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(CDPlayerConfig.class);
		SgtPeppers sgtPeppers = context.getBean("lonelyHeartsClub",SgtPeppers.class);
		sgtPeppers.play();
	}

}
