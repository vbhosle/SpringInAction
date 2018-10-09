package soundsystem.disc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import soundsystem.custom.annotations.Retro;

@Component
@Qualifier("music")
@Retro
public class Pardes implements CompactDisc {
	private String title = "Yeh Dil Deewana";
	private String artist = "Sonu Nigam";

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