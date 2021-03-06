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
@ActiveProfiles("classical")
//@ContextConfiguration(classes= {SoundSystemConfig.class})
//OR
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class ClassicalProfileTest {
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
		player.play();
		final String newLine = System.lineSeparator();
		assertEquals("Playing Indian Classical Raga" + " by Anoushka Shankar" + newLine,  systemOutRule.getLog());
	}
}