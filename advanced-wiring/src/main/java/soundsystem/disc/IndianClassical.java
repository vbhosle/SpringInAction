package soundsystem.disc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import soundsystem.custom.annotations.Classical;

@Component
@Qualifier("music")
@Classical
public class IndianClassical implements CompactDisc {
	private String title = "Indian Classical Raga";
	private String artist = "Anoushka Shankar";

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void play() {
		System.out.println("Playing " + title + " by " + artist);
	}
}