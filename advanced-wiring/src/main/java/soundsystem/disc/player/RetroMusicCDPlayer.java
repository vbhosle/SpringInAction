package soundsystem.disc.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import soundsystem.custom.annotations.Retro;
import soundsystem.disc.CompactDisc;
import soundsystem.custom.annotations.Classical;

@Profile("retro")
@Component
public class RetroMusicCDPlayer implements MediaPlayer {
	private CompactDisc cd;

	public RetroMusicCDPlayer() {
		
	}
	
	//Example of using multiple qualifiers with custom qualifier @Retro
	@Autowired
	public RetroMusicCDPlayer(@Qualifier("music") @Retro CompactDisc cd) {
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