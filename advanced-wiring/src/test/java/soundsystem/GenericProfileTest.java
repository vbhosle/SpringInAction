package soundsystem;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import soundsystem.disc.CompactDisc;
import soundsystem.disc.player.MediaPlayer;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("generic")
@ContextConfiguration(locations= {"classpath:spring.xml"})
public class GenericProfileTest {
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	@Autowired
	private MediaPlayer player;

	@Test
	public void playerShouldNotBeNull() {
		assertNotNull(player);
	}

	@Test
	public void play() {
		//Generic profile doesn't have any qualifier on the Injected CompactDisc
		//Blank disc is marked @Primary, thus it will be picked up
		player.play();
		final String newLine = System.lineSeparator();
		assertEquals("Playing blank title" + " by anonymous" + newLine,  systemOutRule.getLog());
	}
}