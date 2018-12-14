package spittr.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import spittr.config.db.H2DataSource;

@Import({H2DataSource.class})
@Configuration
@ComponentScan(basePackages= {"spittr"},
	excludeFilters= {
			@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)
	}
)
public class RootConfig {

	@Autowired
	DataSource dataSource;
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}
}
