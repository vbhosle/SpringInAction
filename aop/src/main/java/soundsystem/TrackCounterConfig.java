package soundsystem;

import java.util.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class TrackCounterConfig {

	@Bean
	public CompactDisc sgtPetters() {
	
		List<String> tracks = new ArrayList<String>();
		tracks.add("Sgt. Pepper's Lonely Hearts Club Band");
		tracks.add("With a Little Help from My Friends");
		tracks.add("Lucy in the Sky with Diamonds");
		tracks.add("Getting Better");
		tracks.add("Fixing a Hole");
		tracks.add("Lovely Rita");
		tracks.add("When I'm Sixty-Four");
		tracks.add("Within You Without You");
		tracks.add("Good Morning Good Morning");
		tracks.add("A Day In The Life");
		BlankDisc cd = new BlankDisc("Sgt. Pepper's Lonely Hearts Club Band", "The Beatles", tracks);
		return cd;
		
	}
	
	@Bean
	public TrackCounter trackCounter() {
		return new TrackCounter();
	}
}
