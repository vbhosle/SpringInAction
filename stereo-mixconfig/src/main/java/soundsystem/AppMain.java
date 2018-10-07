package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SoundSystemConfig.class);
		System.out.println("Mixing and Importing Configs");
		System.out.println("# Referring to another JavaConfig from JavaConfig");
		CDPlayer cdPlayer = context.getBean("cdPlayer", CDPlayer.class);
		cdPlayer.play();
		
		System.out.println();
		System.out.println("# Import XML config into Java config with @ImportResource");
		CompactDisc disc = context.getBean("blankDisc", CompactDisc.class);
		disc.play();
	}

}
