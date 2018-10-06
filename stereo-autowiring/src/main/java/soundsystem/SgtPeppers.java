package soundsystem;

import org.springframework.stereotype.Component;
import javax.inject.Named;

@Component
//@Component("lonelyHeartsClub")
@Named("lonelyHeartsClub")
public class SgtPeppers implements CompactDisc {
	private String title = "Sgt. Pepper's Lonely Hearts Club Band";
	private String artist = "The Beatles";

	public void play() {
		System.out.println("Playing " + title + " by " + artist);
	}
}