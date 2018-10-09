package soundsystem.disc.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import soundsystem.custom.annotations.Classical;
import soundsystem.disc.CompactDisc;

@Profile("generic")
@Component
public class GenericPlayer implements MediaPlayer {
	private CompactDisc cd;

	public GenericPlayer() {
		
	}
	
	//BlankDisc is marked @Primary
	@Autowired
	public GenericPlayer(CompactDisc cd) {
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