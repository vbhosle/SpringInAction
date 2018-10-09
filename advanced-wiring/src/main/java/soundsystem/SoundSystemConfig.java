package soundsystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ImportResource("classpath:spring.xml")
@PropertySource("classpath:default-blankdisc.properties")
public class SoundSystemConfig {

}