package soundsystem;

public class CDPlayer implements MediaPlayer {
	private CompactDisc cd;

	public CDPlayer() {
		
	}
	
	public CDPlayer(CompactDisc cd) {
		this.cd = cd;
	}

	
	public CompactDisc getCd() {
		return cd;
	}
	
	public void setCd(CompactDisc compactDisc) {
		this.cd = compactDisc;
	}
	
	public void play() {
		cd.play();
	}
}