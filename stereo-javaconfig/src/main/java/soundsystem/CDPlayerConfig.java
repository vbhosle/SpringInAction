package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayerConfig {
	
	@Bean
	public CDPlayer musicCdPlayer() {
		return new CDPlayer(sgtPeppers());
	}
	
	//other way to wire
	@Bean
	public CDPlayer animationCdPlayer(CompactDisc overTheHedge) {
		return new CDPlayer(overTheHedge);
	}
	
	@Bean
	public CompactDisc sgtPeppers() {
		return new SgtPeppers();
	}
	
	@Bean
	public CompactDisc overTheHedge() {
		return new OverTheHedge();
	}
}