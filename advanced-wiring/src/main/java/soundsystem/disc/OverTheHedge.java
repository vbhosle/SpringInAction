package soundsystem.disc;

import org.springframework.stereotype.Component;

@Component
public class OverTheHedge implements CompactDisc {
	private String title = "Over the hedge";
	private String artist = "DreamWorks Animation";

	public void play() {
		System.out.println("Playing " + title + " by " + artist);
	}
}