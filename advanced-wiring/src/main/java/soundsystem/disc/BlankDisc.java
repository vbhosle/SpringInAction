package soundsystem.disc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class BlankDisc implements CompactDisc {
	
	private String title;
	private String artist;

	public BlankDisc() {};
	
	@Autowired
	public BlankDisc(
			@Value("${blankdisc.title}") String title, 
			@Value("${blankdisc.artist}") String artist
	) 
	{
		this.title = title;
		this.artist = artist;
	}

	public void play() {
		System.out.println("Playing " + title + " by " + artist);
	}

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
}