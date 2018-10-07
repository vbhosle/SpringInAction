package soundsystem;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations= {"spring.xml"})
public class CDPlayerTest {
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	//Either use Qualifier or use the same var name as the bean name
	@Autowired
	private MediaPlayer animationCdPlayer;
	
	@Autowired
	@Qualifier("overTheHedge")
	private CompactDisc cd;

	@Test
	public void cdShouldNotBeNull() {
		assertNotNull(cd);
	}

	@Test
	public void play() {
		animationCdPlayer.play();
		final String newLine = System.lineSeparator();
		assertEquals("Playing Over the hedge" + " by DreamWorks Animation" + newLine,  systemOutRule.getLog());
	}
}