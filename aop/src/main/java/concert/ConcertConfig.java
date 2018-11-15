package concert;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class ConcertConfig {

	@Bean
	public Performance drama() {
		return new Drama();
	}
	
	@Bean
	public Audience audience() {
		return new Audience();
	}
}
