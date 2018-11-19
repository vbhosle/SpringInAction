package soundsystem;

import java.util.List;

public class BlankDisc implements CompactDisc {

	private String title;
	private String artist;
	private List<String> tracks;

	public BlankDisc(String title, String artist, List<String> tracks) {
		this.title = title;
		this.artist = artist;
		this.tracks = tracks;
	}
	
	

	@Override
	public boolean playTrack(int trackNumber) {
		if(trackNumber<tracks.size()) {
			String track = tracks.get(trackNumber);
			System.out.println("Playing " + track + " by " + artist);
			return true;
		}
		else {
			System.out.println("Invalid tracknumber");
			return false;
		}
	}

}
