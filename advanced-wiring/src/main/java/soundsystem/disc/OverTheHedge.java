package soundsystem.disc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Qualifier("animation")
@Conditional(AnimationExistsCondition.class)
public class OverTheHedge implements CompactDisc {
	private String title = "Over the hedge";
	private String artist = "DreamWorks Animation";

	public void play() {
		System.out.println("Playing " + title + " by " + artist);
	}
}