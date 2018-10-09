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
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import soundsystem.disc.CompactDisc;
import soundsystem.disc.player.MediaPlayer;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("classical")
@ContextConfiguration(locations = {"classpath:spring.xml"})
@TestPropertySource(properties="animation=true")
public class ConditionalBeanCreatedTest {
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	@Autowired(required=false)
	@Qualifier("animation")
	private CompactDisc disc;

	@Test
	public void discShouldNotBeNull() {
		assertNotNull(disc);
	}

	@Test
	public void play() {
		disc.play();
		final String newLine = System.lineSeparator();
		assertEquals("Playing Over the hedge" + " by DreamWorks Animation" + newLine,  systemOutRule.getLog());
	}
}