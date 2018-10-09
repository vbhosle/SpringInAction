package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import soundsystem.disc.player.MediaPlayer;

public class AppMain {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SoundSystemConfig.class);
		System.out.println("Advance wiring");
		System.out.println("# title");
		MediaPlayer player = context.getBean("CDPlayer", MediaPlayer.class);
		player.play();
	}

}
