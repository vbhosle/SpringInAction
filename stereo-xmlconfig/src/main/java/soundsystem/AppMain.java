package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		System.out.println("XML Wiring");
		System.out.println("# XML wiring without id attribute");
		SgtPeppers sgtPeppers = context.getBean("soundsystem.SgtPeppers#0",SgtPeppers.class);
		sgtPeppers.play();
		
		sgtPeppers = context.getBean("soundsystem.SgtPeppers#1",SgtPeppers.class);
		sgtPeppers.play();
		
		System.out.println();
		System.out.println("# XML wiring with id attribute");
		sgtPeppers = context.getBean("sgtPeppers",SgtPeppers.class);
		sgtPeppers.play();
		
		System.out.println();
		System.out.println("# constructor-arg injection");
		MediaPlayer musicPlayer = context.getBean("musicPlayer", CDPlayer.class);
		musicPlayer.play();
		
		System.out.println();
		System.out.println("# c-namespace constructor injection for object reference");
		MediaPlayer animationPlayer = context.getBean("animationPlayer", CDPlayer.class);
		animationPlayer.play();
		
		System.out.println();
		System.out.println("# c-namespace constructor injection for literal value");
		CompactDisc disc = context.getBean("blankDisc",BlankDisc.class);
		disc.play();
		
		System.out.println();
		System.out.println("# constructor injection for list");
		disc = context.getBean("collections.blankDisc",soundsystem.collections.BlankDisc.class);
		disc.play();
		
		System.out.println();
		System.out.println("# property injection with <property>");
		musicPlayer = context.getBean("propertyInjected.musicPlayer", CDPlayer.class);
		musicPlayer.play();
		
		System.out.println();
		System.out.println("# property injection with pnamespace");
		musicPlayer = context.getBean("propertyInjected.pnamespace.musicPlayer", soundsystem.properties.CDPlayer.class);
		musicPlayer.play();
		
		System.out.println();
		System.out.println("# Property injection for literal value");
		disc = context.getBean("propertyInjection.literal.blankDisc",soundsystem.properties.BlankDisc.class);
		disc.play();
		
		System.out.println();
		System.out.println("# Property injection for literal value using namespace ");
		disc = context.getBean("propertyInjection.literal.namespace.blankDisc",soundsystem.properties.BlankDisc.class);
		disc.play();
	}

}
